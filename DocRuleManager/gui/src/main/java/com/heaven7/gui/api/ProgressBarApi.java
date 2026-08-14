package com.heaven7.gui.api;

import com.heaven7.gui.Api;

import javax.swing.*;

//max_progress
public class ProgressBarApi extends BaseApi<JProgressBar> implements Api.IProgressBar{

    //oritation default hor
    public ProgressBarApi() {
        super(new JProgressBar(0, 100));
        getActor().setStringPainted(true);
        // act.setOrientation(var1);
    }

    @Override
    public int getMaxProgress() {
        return getActor().getMaximum();
    }

    @Override //call in ui.
    public void setMaxProgress(int max) {
        JProgressBar act = getActor();
        act.setModel(new DefaultBoundedRangeModel(0, 0, 0, max));
        act.updateUI();
    }
    @Override
    public void setProgress(int val) {
        getActor().setValue(val);
    }
    @Override
    public int getProgress() {
        return getActor().getValue();
    }
}
