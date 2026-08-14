package com.heaven7.gui.api;

import com.heaven7.gui.Api;
import com.heaven7.gui.Orientation;
import com.heaven7.gui.View;
import com.heaven7.java.base.util.Throwables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowApi extends BaseApi<JFrame> implements Api.IContainer{

    public WindowApi() {
        super(new JFrame());

        getActor().addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void setSize(int width, int height) {
        Throwables.checkArgument(width > 0 && height > 0, "WindowApi");
        getActor().setSize(width, height);
    }

    @Override
    public void setBackgroundColor(String rgb) {

    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {

    }

    @Override
    public void setMargin(int left, int top, int right, int bottom) {

    }

    @Override
    public void setTextSize(float textSize) {

    }

    @Override
    public void setTextColor(String rgb) {

    }

    @Override
    public void setText(String txt) {
        getActor().setTitle(txt);
    }

    @Override
    public void addView(View view) {
        //getActor().removeAll();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                getActor().add((Component) view.getActor());
                getActor().setVisible(true);
            }
        });
    }
    @Override
    public void setOrientation(Orientation ori) {
        throw new RuntimeException();
    }
}
