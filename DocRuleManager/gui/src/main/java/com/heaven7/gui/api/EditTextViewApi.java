package com.heaven7.gui.api;

import javax.swing.*;

public class EditTextViewApi extends BaseApi<JTextField>{

    public EditTextViewApi() {
        super(new JTextField());
    }

    @Override
    public void setTextSize(float textSize) {
        super.setTextSize(textSize);
    }

    @Override
    public void setTextColor(String rgb) {
        super.setTextColor(rgb);
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
    public String getSelectedText() {
        return getActor().getSelectedText();
    }
}
