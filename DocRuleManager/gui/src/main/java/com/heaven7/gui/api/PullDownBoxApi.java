package com.heaven7.gui.api;

import com.heaven7.gui.Api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class PullDownBoxApi extends BaseApi<JComboBox<String>> implements Api.IPullDownBox{

    public PullDownBoxApi() {
        super(new JComboBox<>());
        getActor().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String str = (String) e.getItem();
                switch (e.getStateChange()) {
                    case ItemEvent.SELECTED:
                        guiContext.onSelectStateEvent(PullDownBoxApi.this, str, true);
                        //System.out.println("选中" + e.getItem());
                        break;
                    case ItemEvent.DESELECTED:
                        guiContext.onSelectStateEvent(PullDownBoxApi.this, str, false);
                        //System.out.println("取消选中" + e.getItem());
                        break;
                }
            }
        });
    }

    @Override
    public void setItems(List<String> l) {
        removeAllItems();
        for (int i = 0; i < l.size(); i++) {
            String s = l.get(i);
            addItem(s);
        }
    }

    @Override
    public void addItem(String item) {
        getActor().addItem(item);
    }

    @Override
    public void removeAllItems() {
        getActor().removeAllItems();
    }
    @Override
    public void setSize(int width, int height) {
        getActor().setPreferredSize(new Dimension(width, height));
    }
}
