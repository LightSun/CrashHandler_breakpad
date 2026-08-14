package com.heaven7.gui;

import com.heaven7.gui.anno.OnClick;
import com.heaven7.java.base.util.Throwables;

public class TestListener2 extends BaseListener{

    @OnClick("bt_switch")
    public void onCLickSwitchCard(View view){
        View cardView = getRootView().findViewById("card");
        Api.ICommon api = cardView.getActorApi();
        Api.ICardLayout layoutApi = api.cast(Api.ICardLayout.class);
        runUI(new Runnable() {
            @Override
            public void run() {
                layoutApi.showNext();
            }
        });
    }
}
