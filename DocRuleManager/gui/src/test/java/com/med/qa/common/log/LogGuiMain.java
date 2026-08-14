package com.med.qa.common.log;

import com.heaven7.gui.GuiContext;
import com.heaven7.gui.View;

public class LogGuiMain {

    public static void main(String[] args) {
        GuiContext context = new GuiContext(true);
        View view = context.parseFile("res/ui_log_filter.txt");
        System.out.println(view);
    }
}
