package com.heaven7.gui;

public class GuiTest {

    public static void main(String[] args) {
        GuiContext context = new GuiContext(true);
        //View view = context.parseFile("res/ui_log_filter.txt");
        View view = context.parseFile("res/test_gui.txt");
        System.out.println(view);
    }
}
