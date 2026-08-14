package com.med.qa.common.log;

import com.heaven7.gui.Api;
import com.heaven7.gui.BaseListener;
import com.heaven7.gui.View;
import com.heaven7.gui.anno.OnClick;
import com.heaven7.gui.anno.OnPopupItemSelected;
import com.heaven7.gui.anno.OnSelected;
import com.heaven7.gui.utils.HistoryManager;
import com.heaven7.gui.utils.LineReader;
import com.heaven7.java.base.util.Throwables;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.util.ArrayList;
import java.util.List;

public class LogListener extends BaseListener {

    private static final String ET_FILTER_ID = "et_filter_result";
    private final HistoryManager<String> m_keyHistoryM = new HistoryManager<>();
    private String m_file;
    //temp
    private String m_resultText;
    private List<Line> m_flines = new ArrayList<>();

    @OnPopupItemSelected(ET_FILTER_ID)
    public void onClickPopupItem(View view, String item){
        System.out.println("onClickPopupItem >> " + item);
        int headTailOffset = 20;
        if(item.equals("selected")){
            View kview = getRootView().findViewById("et_select_offset");
            String text = kview.getActorApi().cast(Api.IText.class).getText();
            try {
                headTailOffset = Integer.parseInt(text);
            }catch (Exception e){
                throw new RuntimeException(text, e);
            }
        }else if(item.contains("_")){
            String str = item.substring(item.lastIndexOf("_") + 1);
            try {
                headTailOffset = Integer.parseInt(str);
            }catch (Exception e){
                //ignore
            }
        }
        JTextArea area = view.getActorApi().getActorAs(JTextArea.class);
        //默认添加了2行在前面
        int startLine = getSelectStartLine(area) - 2;
        String selectedText = area.getSelectedText();
        if(startLine >= 1){
            Line line = m_flines.get(startLine - 1);
            int idx = line.idx;
            int startIdx = idx - headTailOffset;
            int endIdx = idx + headTailOffset;
            applyHeadTailLines(selectedText, startIdx, endIdx);
        }else{
            System.out.println("no select texts");
            showPopupMessage("no select texts");
        }
    }

    @OnClick("bt_clear")
    public void onClickClear(View view){
        m_keyHistoryM.clear();
    }

    @OnClick("bt_next")
    public void onClickNext(View view){
        String keyword = m_keyHistoryM.next();
        if(keyword != null){
            applyFilter(keyword);
        }
    }

    @OnClick("bt_previous")
    public void onClickPre(View view){
        String keyword = m_keyHistoryM.previous();
        if(keyword != null){
            applyFilter(keyword);
        }
    }

    @OnClick("bt_filter")
    public void onClickFilter(View view){
        //like grep "xx" -i
        //      | wc -l
        Throwables.checkNull(m_file);
        View rootView = getRootView();
        View et_view = rootView.findViewById("et_filter_txt");
        Throwables.checkNull(et_view);
        Api.IText iText = et_view.getActorApi().cast(Api.IText.class);
        String text = iText.getText();
        //
        m_keyHistoryM.add(text);
        applyFilter(text);
    }
    @OnSelected("selectFile1")
    public void onSelectFileDone(View view,String file){
        m_file = file;
    }

    private void applyHeadTailLines(String selectedText, int startIdx, int endIdx){
        runAsync(() -> applyHeadTailLinesImpl(selectedText, startIdx, endIdx), this::showFilterResult);
    }
    private void applyHeadTailLinesImpl(String selectedText, int startIdx, int endIdx){
        if(startIdx < 0) {
            startIdx = 0;
        }
        LineReader reader = new LineReader(m_file);
        List<String> lines = reader.readLines();
        if(endIdx >= lines.size()){
            endIdx = lines.size() - 1;
        }
        List<Line> flines = new ArrayList<>();
        for (int i = startIdx; i <= endIdx; i++) {
            String s = lines.get(i);
            flines.add(new Line(s, i));
        }
        flines.add(0, new Line("关键字符串(" + selectedText
                + ")-前后多行(" + startIdx + " - " + endIdx
                + "): 行数 = " + flines.size() + "\n", -1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < flines.size(); i++) {
            Line s = flines.get(i);
            sb.append(s.text).append("\n");
        }
        m_resultText = sb.toString();
        m_flines = flines;
    }
    private void applyFilter(String text){
        Throwables.checkNull(m_file);
        View rootView = getRootView();
        View et_result_view = rootView.findViewById(ET_FILTER_ID);
        Throwables.checkNull(et_result_view);
        //
        runAsync(new Runnable() {
            @Override
            public void run() {
                LineReader reader = new LineReader(m_file);
                List<String> lines = reader.readLines();
                List<Line> flines = new ArrayList<>();
                if(text.isEmpty()){
                    for (int i = 0; i < lines.size(); i++) {
                        flines.add(new Line(lines.get(i), i));
                    }
                }else{
                    for (int i = 0; i < lines.size(); i++) {
                        String s = lines.get(i);
                        if(s.contains(text)){
                            flines.add(new Line(s, i));
                        }
                    }
                }
                //head添加2行
                flines.add(0, new Line("过滤结果: 行数 = " + flines.size() + "\n", -1));
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < flines.size(); i++) {
                    Line s = flines.get(i);
                    sb.append(s.text).append("\n");
                }
                m_resultText = sb.toString();
                m_flines = flines;
            }
        }, this::showFilterResult);
    }
    private void showFilterResult(){
        View rootView = getRootView();
        View et_result_view = rootView.findViewById(ET_FILTER_ID);
        et_result_view.getActorApi().cast(Api.IText.class).setText(m_resultText);
        //must use SwingUtilities to invoke after ui update done.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                rootView.findViewById("scrollView").getActorApi().cast(Api.IScroll.class).resetScrollPosition();
            }
        });
    }
    private static class Line{
        String text;
        int idx;
        public Line(String text, int idx) {
            this.text = text;
            this.idx = idx;
        }
    }
}
