package com.heaven7.gui.parser;

import com.heaven7.gui.Api;
import com.heaven7.gui.GuiParser;
import com.heaven7.gui.api.*;
import com.heaven7.java.base.util.Throwables;

import java.util.HashMap;

public class SimpleViewParser extends ViewParser {

    private final HashMap<GuiParser.Type, Class<? extends Api.ICommon>> m_map;
    private final boolean m_debug;

    public SimpleViewParser(boolean dbg){
        m_debug = dbg;
        m_map = new HashMap<>();
        m_map.put(GuiParser.Type.TextView, TextViewApi.class);
        m_map.put(GuiParser.Type.Button, ButtonApi.class);
        m_map.put(GuiParser.Type.EditText, EditTextViewApi.class);
        m_map.put(GuiParser.Type.EditTextArea, EditTextAreaApi.class);
        m_map.put(GuiParser.Type.LinearLayout, LinearLayoutApi.class);
        m_map.put(GuiParser.Type.PullDownBox, PullDownBoxApi.class);
        m_map.put(GuiParser.Type.Scrollable, ScrollViewApi.class);
        m_map.put(GuiParser.Type.Space, SpaceViewApi.class);
        m_map.put(GuiParser.Type.ImageView, ImageViewApi.class);
        m_map.put(GuiParser.Type.ProgressBar, ProgressBarApi.class);
        //
        m_map.put(GuiParser.Type.Window, WindowApi.class);
        m_map.put(GuiParser.Type.SelectFileLine, SelectFileLineApi.class);
        //
        m_map.put(GuiParser.Type.CardLayout, CardLayoutApi.class);
        m_map.put(GuiParser.Type.FlowLayout, FlowLayoutApi.class);
    }

    @Override
    protected Api.ICommon createActorApi(GuiParser.Type type) {
        Class<? extends Api.ICommon> cls = m_map.get(type);
        Throwables.checkNull(cls);
        try {
            Api.ICommon ins;
            if(m_debug){
                ins = new WrapperApi(cls.getConstructor().newInstance());
            }else{
                ins = cls.getConstructor().newInstance();
            }
            //ins = cls.getConstructor().newInstance();
            ins.bindGuiContext(getGuiContext());
            return ins;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
