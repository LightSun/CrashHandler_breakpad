package com.heaven7.gui;

import com.heaven7.gui.anno.OnClick;
import com.heaven7.gui.anno.OnPopupItemSelected;
import com.heaven7.gui.anno.OnSelectState;
import com.heaven7.gui.anno.OnSelected;
import com.heaven7.gui.parser.SimpleViewParser;
import com.heaven7.java.base.util.Throwables;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GuiContext {

    private final HashMap<String, MethodInfo> m_onClickMap = new HashMap<>();
    private final HashMap<String, MethodInfo> m_onSelectMap = new HashMap<>();
    private final HashMap<String, MethodInfo> m_onSelectStateMap = new HashMap<>();
    private final HashMap<String, MethodInfo> m_onSelectPopupItemMap = new HashMap<>();
    private boolean m_parseDone = false;
    private final boolean m_debug;
    private BaseListener m_listener;
    private View m_rootView;

    public GuiContext(boolean m_debug) {
        this.m_debug = m_debug;
    }

    public boolean isDebug() {
        return m_debug;
    }

    public View parseFile(String file){
        SimpleViewParser m_parser = new SimpleViewParser(m_debug);
        m_parser.setGuiContext(this);
        return m_parser.parseFile(file);
    }

    public View parseContent(String content){
        SimpleViewParser m_parser = new SimpleViewParser(m_debug);
        m_parser.setGuiContext(this);
        return m_parser.parseContent(content);
    }

    public View getRootView() {
        return m_rootView;
    }
    public void setRootView(View rootView) {
        this.m_rootView = rootView;
        if(m_listener != null){
            m_listener.setRootView(rootView);
        }
    }
    public BaseListener getListener() {
        return m_listener;
    }
    public void setListener(BaseListener l) {
        this.m_listener = l;
        if(l != null){
            m_listener.setRootView(m_rootView);
        }
    }
    public boolean isParseDone(){
        return m_parseDone;
    }
    public void onParseDone(){
        m_parseDone = true;
        clearEventMap();
        Method[] methods = m_listener.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method m = methods[i];
            //
            OnClick[] onClicks = m.getAnnotationsByType(OnClick.class);
            handleRegOnClick(m, onClicks);
            //
            OnSelected[] selecteds = m.getAnnotationsByType(OnSelected.class);
            handleRegOnSelected(m, selecteds);
            //
            OnSelectState[] states = m.getAnnotationsByType(OnSelectState.class);
            handleRegOnSelectState(m, states);
            //
            OnPopupItemSelected[] states2 = m.getAnnotationsByType(OnPopupItemSelected.class);
            handleRegOnPopupItemSelect(m, states2);
        }
        getRootView().onParseDone();
    }
    //bind
    public void onClickEvent(Api.ICommon actApi){
        MethodInfo info = m_onClickMap.get(actApi.getId());
        if(info != null){
            info.invokeOnClick(m_listener);
        }else{
            System.err.println("onClickEvent >> can't find method reg for id = " + actApi.getId());
        }
    }
    //state: ItemEvent.SELECTED / ItemEvent.DESELECTED
    public void onSelectStateEvent(Api.ICommon actApi, String item, boolean select){
        MethodInfo info = m_onSelectStateMap.get(actApi.getId());
        if(info != null){
            info.invokeOnSelectState(m_listener, item, select);
        }else{
            //默认第一次会到这。
            System.err.println("onSelectEvent >> can't find method reg for id = " + actApi.getId());
        }
    }
    //path: file/dir
    public void onFileSelected(Api.ICommon actApi, String path){
        MethodInfo info = m_onSelectMap.get(actApi.getId());
        if(info != null){
            info.invokeOnSelect(m_listener, path);
        }else{
            System.err.println("onFileSelected >> can't find method reg for id = " + actApi.getId());
        }
    }
    public void onClickPopupItem(Api.ICommon actApi, String item){
        MethodInfo info = m_onSelectPopupItemMap.get(actApi.getId());
        if(info != null){
            info.invokeOnSelect(m_listener, item);
        }else{
            System.err.println("onClickPopupItem >> can't find method reg for id = " + actApi.getId());
        }
    }
    //------------------------
    private void handleRegOnPopupItemSelect(Method m, OnPopupItemSelected[] states) {
        if(states.length == 0){
            return;
        }
        checkParameterType(m, Arrays.asList(View.class, String.class),
                "require param types are 'View.class, String.class, boolean.class'");
        String viewId = states[0].value();
        View view = m_rootView.findViewById(viewId);
        if(view == null){
            throw new IllegalStateException("can't find view by id = " + viewId);
        }
        m_onSelectPopupItemMap.put(viewId, new MethodInfo(m, view));
    }
    private void handleRegOnSelectState(Method m, OnSelectState[] states) {
        if(states.length == 0){
            return;
        }
        checkParameterType(m, Arrays.asList(View.class, String.class, boolean.class),
                "require param types are 'View.class, String.class, boolean.class'");
        String viewId = states[0].value();
        View view = m_rootView.findViewById(viewId);
        if(view == null){
            throw new IllegalStateException("can't find view by id = " + viewId);
        }
        m_onSelectStateMap.put(viewId, new MethodInfo(m, view));
    }
    private void handleRegOnSelected(Method m, OnSelected[] selecteds) {
        if(selecteds.length == 0){
            return;
        }
        checkParameterType(m, Arrays.asList(View.class, String.class),
                "require param types are 'View.class, String.class'");
        String viewId = selecteds[0].value();
        View view = m_rootView.findViewById(viewId);
        if(view == null){
            throw new IllegalStateException("can't find view by id = " + viewId);
        }
        m_onSelectMap.put(viewId, new MethodInfo(m, view));
    }

    private void handleRegOnClick(Method m, OnClick[] onClicks) {
        if(onClicks.length == 0){
            return;
        }
        checkParameterType(m, Arrays.asList(View.class), "require param types are 'View.class'");
        String viewId = onClicks[0].value();
        View view = m_rootView.findViewById(viewId);
        if(view == null){
            throw new IllegalStateException("can't find view by id = " + viewId);
        }
        m_onClickMap.put(viewId, new MethodInfo(m, view));
    }
    private void clearEventMap(){
        m_onClickMap.clear();
        m_onSelectMap.clear();
        m_onSelectStateMap.clear();
        m_onSelectPopupItemMap.clear();
    }
    private static void checkParameterType(Method m, List<Class<?>> types, String msg){
        Class<?>[] classes = m.getParameterTypes();
        Throwables.checkArgument(classes.length == types.size(), msg);
        for (int i = 0; i < classes.length; i++) {
            if(classes[i] != types.get(i)){
                throw new IllegalStateException("parameter types not match. " + msg);
            }
        }
    }
    private static class MethodInfo{
        final Method method;
        final WeakReference<View> view;

        public MethodInfo(Method method, View view) {
            this.method = method;
            this.view = new WeakReference<>(view);
        }
        public View getView(){
            return view.get();
        }
        public void invokeOnClick(BaseListener l){
            try {
                method.invoke(l, getView());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        public void invokeOnSelect(BaseListener l,String val){
            try {
                method.invoke(l, getView(), val);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        public void invokeOnSelectState(BaseListener l,String val, boolean selected){
            try {
                method.invoke(l, getView(), val, selected);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
