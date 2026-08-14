package com.heaven7.gui.main.bp;

import com.heaven7.gui.GuiContext;
import com.heaven7.gui.View;
import com.heaven7.gui.utils.GlobalUiUtils;
import com.heaven7.gui.utils.ResourceUtil;

import java.awt.*;

public final class BPGuiMain {

    public static void main(String[] args) {
        String uiStr = ResourceUtil.readTextResource("/ui_bp.txt");
        GlobalUiUtils.setGlobalFont(new Font("Dialog", Font.PLAIN, 30));
        GuiContext context = new GuiContext(false);
        View view = context.parseContent(uiStr);
        System.out.println(view);
    }
}
