package com.heaven7.gui.api;

import com.heaven7.gui.Api;
import com.heaven7.gui.Orientation;
import com.heaven7.gui.View;
import com.heaven7.java.base.util.Predicates;
import com.heaven7.java.base.util.Throwables;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CardLayoutApi extends BaseApi<JPanel> implements Api.ICardLayout{

    private final CardLayout m_layout;
    private final Map<Integer,String> m_idTagMap = new HashMap<>();

    public CardLayoutApi() {
        super(new JPanel(new CardLayout()));
        m_layout = (CardLayout) getActor().getLayout();
    }
    @Override
    public void addView(View view) {
        Api.ICommon api = view.getActorApi();
        Throwables.checkArgument(!Predicates.isEmpty(api.getId()), "must define id for CardLayout");
        Object act = api.getActor();
        if(act instanceof Component){
            getActor().add((Component)act, api.getId());
        }
        int preSize = m_idTagMap.size();
        m_idTagMap.put(preSize, api.getId());
    }
    @Override
    public void setOrientation(Orientation ori) {
        //ignore
    }
    @Override
    public void show(String tag) {
        m_layout.show(getActor(), tag);
        getActor().revalidate();
        getActor().repaint();
    }
    @Override
    public void showByIndex(int index) {
        String tag = m_idTagMap.get(index);
        show(tag);
    }
    @Override
    public int getVisibleIndex() {
        int count = getActor().getComponentCount();
        for (int i = 0; i < count; i++) {
            if(getActor().getComponent(i).isVisible()){
                return i;
            }
        }
        return -1;
    }
    @Override
    public int getComponentCount() {
        return getActor().getComponentCount();
    }
}
