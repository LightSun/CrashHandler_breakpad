package com.heaven7.gui;

import com.heaven7.gui.anno.OnClick;
import com.heaven7.gui.anno.OnSelected;

public class TestListener extends BaseListener{

    @OnClick("tv1")
    public void onClickTV1(View view){
        System.out.println("onClickTV1");
    }
    @OnSelected("selectFile1")
    public void onSelectFileDone(View view, String path){
        System.out.println("onSelectFileDone: " + path);
    }

}
