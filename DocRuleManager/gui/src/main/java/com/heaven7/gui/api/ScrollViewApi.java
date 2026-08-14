package com.heaven7.gui.api;

import com.heaven7.gui.Api;
import com.heaven7.gui.Orientation;
import com.heaven7.gui.View;

import javax.swing.*;
import java.awt.*;

public class ScrollViewApi extends BaseApi<JScrollPane> implements Api.IScroll {

    public ScrollViewApi() {
        super(new JScrollPane());
    }

    @Override
    public void setOrientation(Orientation ori) {
        JScrollPane actor = getActor();
        if(ori == Orientation.Vertical){
            actor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            actor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        }else{
            actor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            actor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        }
    }
    @Override
    public void setContainerView(View view) {
        JScrollPane actor = getActor();
        Component com = (Component) view.getActor();
        actor.setViewportView(com);
    }
    @Override
    public void resetScrollPosition() {
        JScrollPane actor = getActor();
        actor.getVerticalScrollBar().setValue(0);
        actor.getHorizontalScrollBar().setValue(0);
    }
    @Override
    public void addView(View view) {
        JScrollPane actor = getActor();
        Component com = (Component) view.getActor();
        actor.setViewportView(com);
    }
}
