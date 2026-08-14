package com.heaven7.gui.api;

import com.heaven7.gui.Api;
import com.heaven7.gui.Orientation;
import com.heaven7.gui.View;
import com.heaven7.java.base.util.Throwables;

import javax.swing.*;
import java.awt.*;

public class LinearLayoutApi extends BaseApi<Box> implements Api.ILinearLayout {

    private Orientation orientation;

    public LinearLayoutApi() {
        super(null);
    }
    @Override
    public void setOrientation(Orientation ori) {
        if(ori == Orientation.Horizontal){
            actor = Box.createHorizontalBox();
            actor.setMaximumSize(new Dimension(1000, 50));
        }else{
            actor = Box.createVerticalBox();
            actor.setMaximumSize(new Dimension(50, 1000));
        }
        this.orientation = ori;
    }
    @Override
    public void addView(View view) {
        Throwables.checkNull(actor);
        //Component impl = (Component)view.getActor();
        actor.add((Component) view.getActor());
    }
}
