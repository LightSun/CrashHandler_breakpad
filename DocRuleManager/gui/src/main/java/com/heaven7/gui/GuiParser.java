package com.heaven7.gui;

import java.util.HashMap;

public final class GuiParser {

    public static final HashMap<String, Type> sTypeMap = new HashMap<>();

    public enum Type{
        NONE, Annotation,
        Window,
        LinearLayout,
        CardLayout,
        FlowLayout,
        TextView,
        EditText,
        EditTextArea,
        PullDownBox,
        Space,
        Button,
        ImageView,
        ProgressBar,
        Scrollable,
        //
        SelectFileLine,
    }
    static{
        Type[] values = Type.values();
        for (int i = 0; i < values.length; i++) {
            sTypeMap.put(values[i].name(), values[i]);
        }
    }
    public static Type str2type(String str){
        Type kt = sTypeMap.get(str);
        if(kt != null){
            return kt;
        }
        if(str.startsWith("/**/")){
            kt = sTypeMap.get(str.substring(4));
            if(kt != null){
                return Type.Annotation;
            }
        }
        throw new RuntimeException("wrong node = " + str);
    }
}
