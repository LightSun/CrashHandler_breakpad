package com.heaven7.gui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.io.File;

public class BaseListener {

    private View m_rootView;

    public View getRootView() {
        return m_rootView;
    }
    public void setRootView(View rootView) {
        this.m_rootView = rootView;
    }
    public void showPopupMessage(String msg){
        runUI(new Runnable() {
            @Override
            public void run() {
                JFrame frame = m_rootView.getActorApi().getActorAs(JFrame.class);
                new PopupDialog(frame, msg).setVisible(true);
            }
        });
    }
    //onClick, onSelect
    public static String openAndSelectDir(Component mainFrame, String baseDir) {
        return openAndSelectFileMode(mainFrame, JFileChooser.DIRECTORIES_ONLY, baseDir);
    }
    public static String openAndSelectFile(Component mainFrame, String baseDir) {
        return openAndSelectFileMode(mainFrame, JFileChooser.FILES_ONLY, baseDir);
    }

    public static String openAndSelectFileMode(Component mainFrame, int mode, String baseDir) {
        JFileChooser m_jfc = new JFileChooser(new File(baseDir));
        m_jfc.setFileSelectionMode(mode);
        int result = m_jfc.showOpenDialog(mainFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            return m_jfc.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    public static void runAsync(Runnable async, Runnable ui) {
        new Thread(new Runnable() {
            public void run() {
                async.run();
                SwingUtilities.invokeLater(ui);
            }
        }).start();
    }
    public static void runUI(Runnable r){
        SwingUtilities.invokeLater(r);
    }
    public static void runAsync(Runnable r){
        new Thread(r).start();
    }
    public static int getSelectStartLine(JTextArea textArea){
        String text = textArea.getSelectedText();
        if(text == null || text.isEmpty()){
            return -1;
        }
        int start = textArea.getSelectionStart();
        int end = textArea.getSelectionEnd();
        try {
            int startLine = textArea.getLineOfOffset(start);
            int endLine = textArea.getLineOfOffset(end);
            System.out.println("选中起始行: " + (startLine + 1));
            System.out.println("选中结束行: " + (endLine + 1));
            return startLine + 1;
        } catch (BadLocationException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    public static String getLineText(JTextArea textArea, int line) {
        try {
            int start = textArea.getLineStartOffset(line);
            int end = textArea.getLineEndOffset(line);
            return textArea.getText(start, end - start);
        } catch (BadLocationException e) {
            // 行号无效（超出范围）
            return null;
        }
    }
    public static class PopupDialog extends JDialog{

        final JLabel m_iv;

        public PopupDialog(JFrame frame, String msg) { //第三个参数表示阻塞父窗体
            super(frame, "Notice", true);
            Rectangle tv_rect = new Rectangle();
            m_iv = new JLabel(msg, JLabel.CENTER);
            m_iv.getBounds(tv_rect);
            Container container = getContentPane();
            container.add(m_iv);
            Rectangle pBox = frame.getBounds();
            int x = (int) ((pBox.width - tv_rect.getWidth()) / 2);
            int y = (int) ((pBox.height - tv_rect.getHeight()) / 2);
            setBounds(x, y, (int) (x + tv_rect.getWidth()),
                    (int) (y + tv_rect.getHeight()));
        }
    }
}
