package com.heaven7.gui.api;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonApi extends BaseApi<JButton> {

    public ButtonApi() {
        super(new JButton());
        getActor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiContext.onClickEvent(ButtonApi.this);
            }
        });
    }

    @Override
    public void setText(String txt) {
        getActor().setText(txt);
    }

    @Override
    public String getText() {
        return getActor().getText();
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        getActor().setBorder(BorderFactory.createCompoundBorder(
                getActor().getBorder(),                   // 原边框
                new EmptyBorder(top, left, bottom, right) // 内边距
        ));
    }
}
