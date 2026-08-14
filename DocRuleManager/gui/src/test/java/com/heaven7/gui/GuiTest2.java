package com.heaven7.gui;

public class GuiTest2 {

    public static void main(String[] args) {
        GuiContext context = new GuiContext(true);
        View view = context.parseFile("res/test_gui2.txt");
        System.out.println(view);
    }
}
