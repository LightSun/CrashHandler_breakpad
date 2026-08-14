package com.heaven7.gui.api;

import javax.swing.*;
import java.awt.*;

public class EditTextAreaApi extends BaseApi<JTextArea> {

    public EditTextAreaApi() {
        super(new JTextArea());

        getActor().setLineWrap(true);
        getActor().setWrapStyleWord(true);
        //commentTextArea.setMargin(new Insets(5, 5, 5, 5));
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        getActor().setMargin(new Insets(top, left, bottom, right));
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
        getActor().getSelectionStart();
        return getActor().getSelectedText();
    }
}
