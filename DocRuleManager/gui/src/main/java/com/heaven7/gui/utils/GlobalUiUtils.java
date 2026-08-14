package com.heaven7.gui.utils;

import javax.swing.*;
import java.awt.*;

public final class GlobalUiUtils {

    public static void setGlobalFont(Font font) {
        // 方式一：通用默认
        UIManager.put("defaultFont", font);
        // 方式二：显式设置常用组件（增强兼容性）
        String[] keys = {
                "Label.font", "Button.font", "TextField.font",
                "TextArea.font", "List.font", "Table.font",
                "Tree.font", "Menu.font", "MenuItem.font",
                "CheckBox.font", "RadioButton.font", "ComboBox.font"
        };
        for (String key : keys) {
            UIManager.put(key, font);
        }
    }
}