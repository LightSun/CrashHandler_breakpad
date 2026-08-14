package com.heaven7.gui.main.bp;

import com.heaven7.gui.Api;
import com.heaven7.gui.BaseListener;
import com.heaven7.gui.View;
import com.heaven7.gui.anno.OnClick;
import com.heaven7.gui.anno.OnSelected;
import com.heaven7.java.base.util.Predicates;

import javax.swing.*;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogListener extends BaseListener {

    private static final String ET_FILTER_ID = "et_filter_result";

    private final BPHelper m_bpHelper = new BPHelper();
    private String m_dumpFile;
    private String m_resultText = "";

    @OnSelected("sfl_work_dir")
    public void onSelectWorkDirDone(View view,String file){
        m_bpHelper.setWorkDir(file);
        m_resultText = m_bpHelper.toString();
        runUI(this::showFilterResult);
    }
    @OnSelected("sfl_bp_bin")
    public void onSelectBpBinDirDone(View view,String file){
        m_bpHelper.setExeByBinDir(file);
        m_resultText = m_bpHelper.toString();
        runUI(this::showFilterResult);
    }
    @OnSelected("sfl_add_path")
    public void onSelectAddPathDone(View view,String file){
        m_bpHelper.addPath(file);
        m_resultText = m_bpHelper.toString();
        runUI(this::showFilterResult);
    }
    @OnSelected("sfl_dump_file")
    public void onSelectDumpFileDone(View view,String file){
        m_dumpFile = file;
        m_resultText = m_bpHelper.toString();
        runUI(this::showFilterResult);
    }
    @OnClick("bt_clear_path")
    public void onClickClearPath(View view){
        m_bpHelper.clearPath();
        m_resultText = m_bpHelper.toString();
        runUI(this::showFilterResult);
    }
    @OnClick("bt_gen_symbol")
    public void onClickGenSymbol(View view){
        runAsync(new Runnable() {
            @Override
            public void run() {
                m_resultText = checkToUi();
                if(m_resultText.isEmpty()){
                    boolean b = m_bpHelper.generateSymbols();
                    m_resultText = "generateSymbols Done !!!" + b;
                }
            }
        }, this::showFilterResult);
    }
    @OnClick("bt_dump")
    public void onClickDumpSymbol(View view){
        if(m_dumpFile == null || m_dumpFile.isEmpty()){
            showPopupMessage("please select dump file first.");
            return;
        }
        runAsync(new Runnable() {
            @Override
            public void run() {
                m_resultText = checkToUi();
                if(m_resultText.isEmpty()){
                    m_resultText = m_bpHelper.dumpStack(m_dumpFile);
                }
            }
        }, this::showFilterResult);
    }

    @OnClick("bt_strip")
    public void onClickStrip(View view){
        runAsync(new Runnable() {
            @Override
            public void run() {
                m_resultText = checkToUi();
                if(m_resultText.isEmpty()){
                    boolean ok = m_bpHelper.strip();
                    m_resultText = "strip ok = " + (ok ? "true" : "false");
                }
            }
        }, this::showFilterResult);
    }

    @OnClick("bt_look_setting")
    public void onClickBPSetting(View view){
        m_resultText = m_bpHelper.toString();
        runUI(this::showFilterResult);
    }

    private String checkToUi(){
        try {
            m_bpHelper.check();
            return "";
        }catch (Exception e){
            StringWriter sw = new StringWriter();
            PrintWriter writer = new PrintWriter(sw);
            e.printStackTrace(writer);
            return sw.toString();
        }
    }

    private void showFilterResult(){
        if(Predicates.isEmpty(m_resultText)){
            return;
        }
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
}
