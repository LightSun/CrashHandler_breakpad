package com.heaven7.gui;

import com.heaven7.java.base.util.Throwables;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class View {

    private View parent;
    private Api.ICommon actorApi;
    //for debug
    private final List<View> children = new ArrayList<>();
    private final HashMap<String, WeakReference<View>> m_IdMap = new HashMap<>();

    public View(View parent, Api.ICommon actorApi) {
        this.parent = parent;
        this.actorApi = actorApi;
        if(parent != null){
            parent.addChildView(this);
        }
    }

    public void addChildView(View child){
        children.add(child);
    }
    public int getChildrenCount(){
        return children.size();
    }

    public View getChildAt(int idx){
        return children.get(idx);
    }

    public String getId() {
        return actorApi != null ? actorApi.getId() : null;
    }
    public void setId(String id) {
        Throwables.checkNull(actorApi);
        actorApi.setId(id);
    }
    public Object getActor() {
        return actorApi != null ? actorApi.getActor() : null;
    }
    public Api.ICommon getActorApi() {
        return actorApi;
    }

    public View getParent() {
        return parent;
    }
    public void setParent(View parent) {
        this.parent = parent;
    }
    public void setActorApi(Api.ICommon actorApi) {
        this.actorApi = actorApi;
    }
    public View findViewById(String id){
        if(actorApi.getId() != null && actorApi.getId().equals(id)){
            return this;
        }
        WeakReference<View> ref = m_IdMap.get(id);
        if(ref != null){
            View actView = ref.get();
            if(actView != null){
                return actView;
            }
        }
        for (int i = 0; i < children.size(); i++) {
            View view = children.get(i);
            View cv = view.findViewById(id);
            if(cv != null){
                m_IdMap.put(id, new WeakReference<>(cv));
                return cv;
            }
        }
        return null;
    }

    public View getRootView(){
        if(parent != null){
            return parent.getRootView();
        }
        return this;
    }
    public void onParseDone(){
        actorApi.onParseDone(this);
        for (int i = 0; i < children.size(); i++) {
            View view = children.get(i);
            view.onParseDone();
        }
    }
}
