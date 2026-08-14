package com.heaven7.gui.api;

import com.heaven7.gui.Api;
import com.heaven7.gui.BaseListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class SelectFileLineApi extends BaseApi<Box> implements Api.ISelectFileLine {

    private final JLabel lab;
    private final JTextField et;
    private final JButton btn;
    private String basePath = "";
    private Mode mode = Mode.FILE;

    public SelectFileLineApi() {
        super(Box.createHorizontalBox());

        Box box = getActor();
        lab = new JLabel("", JLabel.CENTER);
        JTextField jf = new JTextField();
        et = jf;
        btn = new JButton();
        addTextChangeListener(jf, new Consumer<String>() {
            @Override
            public void accept(String s) {
                basePath = s;
            }
        });
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String file = BaseListener.openAndSelectFileMode((Component) guiContext.getRootView().getActor(),
                        modeToJFileMode(mode), basePath);
                if(file != null){
                    //save record
                    basePath = file;
                    //ui
                    et.setText(file);
                    //callback
                    guiContext.onFileSelected(SelectFileLineApi.this, file);
                }
                //guiContext.getRootView().getActor();
            }
        });
        box.add(Box.createHorizontalStrut(20));
        box.add(lab);
        box.add(Box.createHorizontalStrut(10));
        box.add(jf);
        box.add(Box.createHorizontalStrut(10));
        box.add(btn);
        box.add(Box.createHorizontalStrut(20));
        box.setMaximumSize(new Dimension(1000, 50));
    }

    @Override
    public void setLabelText(String text) {
        lab.setText(text);
    }

    @Override
    public void setLabelSize(int w, int h) {
        lab.setSize(w, h);
    }

    @Override
    public void setButtonText(String text) {
        btn.setText(text);
    }

    @Override
    public void setButtonSize(int w, int h) {
        btn.setSize(w, h);
    }
    @Override
    public void setEditTextSize(int w, int h) {
        et.setSize(w, h);
    }

    @Override
    public void setBasePath(String path) {
        basePath = path;
        BaseListener.runUI(new Runnable() {
            @Override
            public void run() {
                et.setText(path);
            }
        });
    }
    @Override
    public void setSelectFileMode(Mode mode) {
        this.mode = mode;
    }
    @Override
    public String getBasePath() {
        return basePath;
    }

    private static int modeToJFileMode(Mode mode){
        switch (mode){
            default:
            case FILE:
                return JFileChooser.FILES_ONLY;

            case DIR:
                return JFileChooser.DIRECTORIES_ONLY;

            case FILE_WITH_DIR:
                return JFileChooser.FILES_AND_DIRECTORIES;
        }
    }
    public static void addTextChangeListener(JTextField tf, Consumer<String> listener) {
        tf.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { listener.accept(tf.getText()); }
            @Override public void removeUpdate(DocumentEvent e) { listener.accept(tf.getText()); }
            @Override public void changedUpdate(DocumentEvent e) { listener.accept(tf.getText()); }
        });
    }
}
