package com.heaven7.gui.api;

import com.heaven7.gui.Api;
import com.heaven7.gui.Orientation;
import com.heaven7.gui.View;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutApi extends BaseApi<JPanel> implements Api.IFlowLayout {

    public FlowLayoutApi() {
        super(new JPanel(new FlowLayout()));
    }

    @Override
    public void addView(View view) {
        getActor().add((Component) view.getActor());
    }

    @Override
    public void setOrientation(Orientation ori) {

    }
}
