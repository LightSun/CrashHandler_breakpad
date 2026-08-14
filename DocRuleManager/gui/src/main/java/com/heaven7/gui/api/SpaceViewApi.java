package com.heaven7.gui.api;

import com.heaven7.gui.Api;

import javax.swing.*;
import java.awt.*;

public class SpaceViewApi extends BaseApi<Box.Filler> implements Api.ISpace{

    public SpaceViewApi() {
        super((Box.Filler) Box.createGlue());
    }

    @Override
    public void setSize(int width, int height) {
        if(width > 0){
            Dimension min = new Dimension(width, 0);
            Dimension prefer = new Dimension(width, 0);
            Dimension max = new Dimension(width, 32767);
            getActor().changeShape(min, prefer, max);
        }else if(height > 0){
            Dimension min = new Dimension(0, height);
            Dimension prefer = new Dimension(0, height);
            Dimension max = new Dimension(32767, height);
            getActor().changeShape(min, prefer, max);
        }else{
            //ignore
        }
    }
}
