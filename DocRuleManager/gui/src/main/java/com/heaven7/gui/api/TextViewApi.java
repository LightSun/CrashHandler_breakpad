package com.heaven7.gui.api;

import javax.swing.*;

public class TextViewApi extends BaseApi<JLabel>{

    public TextViewApi() {
        super(new JLabel());
        addMouseClickListener();
    }

    @Override
    public void setBackgroundColor(String rgb) {

    }

    @Override
    public void setTextSize(float textSize) {
    }

    @Override
    public void setTextColor(String rgb) {

    }
    @Override
    public void setText(String txt) {
        getActor().setText(txt);
    }
    @Override
    public String getText() {
        return getActor().getText();
    }
}
