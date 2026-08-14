package com.heaven7.gui.api;

import com.heaven7.gui.Api;
import com.heaven7.gui.GuiContext;
import com.heaven7.gui.View;
import com.heaven7.gui.utils.HistoryManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public abstract class BaseApi<T extends Component> implements Api.IText{

    private String id;
    protected T actor;
    protected GuiContext guiContext;
    private final HistoryManager<List<String>> popupItemsManager = new HistoryManager<>();
    private final JPopupMenu popupMenu = new JPopupMenu();

    public BaseApi(T ins) {
        actor = ins;
        //
        popupMenu.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                //set enable or not enable?
                if(BaseApi.this instanceof PopupMenuListener){
                    PopupMenuListener pl = (PopupMenuListener) BaseApi.this;
                    pl.popupMenuWillBecomeVisible(e);
                }
            }
            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                if(BaseApi.this instanceof PopupMenuListener){
                    PopupMenuListener pl = (PopupMenuListener) BaseApi.this;
                    pl.popupMenuWillBecomeInvisible(e);
                }
            }
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                if(BaseApi.this instanceof PopupMenuListener){
                    PopupMenuListener pl = (PopupMenuListener) BaseApi.this;
                    pl.popupMenuCanceled(e);
                }
            }
        });
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public final T getActor() {
        return actor;
    }

    @Override
    public void bindGuiContext(GuiContext ctx) {
        guiContext = ctx;
    }
    @Override
    public void onParseDone(View view) {
        applyPopupItems();
    }
    @Override
    public void setPopupItems(List<String> items) {
        popupItemsManager.clear();
        popupItemsManager.add(items);
        if(guiContext.isParseDone()){
            applyPopupItems();
        }
    }
    @Override
    public HistoryManager<List<String>> getPopupHistoryManager() {
        return popupItemsManager;
    }

    @Override
    public void setSize(int width, int height) {
        getActor().setSize(width, height);
    }

    @Override
    public void setBackgroundColor(String rgb) {

    }
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        T actor = getActor();
        if(actor instanceof JComponent){
            ((JComponent)actor).setBorder(new EmptyBorder(top, left, bottom, right));
        }
    }

    @Override
    public void setMargin(int left, int top, int right, int bottom) {

    }
    @Override
    public void setTextSize(float textSize) {

    }

    @Override
    public void setTextColor(String rgb) {

    }

    @Override
    public void setText(String txt) {
    }
    @Override
    public String getText() {
        return null;
    }
    @Override
    public String getSelectedText() {
        return null;
    }

    protected void addMouseClickListener(){
        getActor().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                guiContext.onClickEvent(BaseApi.this);
            }
        });
    }
    private void applyPopupItems(){
        List<String> popupItems = popupItemsManager.current();
        applyPopupItems(popupItems);
    }
    @Override
    public void applyPopupItems(List<String> popupItems){
        //List<String> popupItems = popupItemsManager.current();
        if(popupItems != null && popupItems.size() > 0){
            //
            popupMenu.removeAll();
            for (int i = 0; i < popupItems.size(); i++) {
                JMenuItem cutItem = new JMenuItem(popupItems.get(i));
                cutItem.setEnabled(true);
                cutItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        guiContext.onClickPopupItem(BaseApi.this, cutItem.getText());
                    }
                });
                popupMenu.add(cutItem);
                if(i != popupItems.size() - 1){
                    popupMenu.addSeparator();
                }
            }
            T actor = getActor();
            if(actor instanceof JComponent){
                ((JComponent) actor).setComponentPopupMenu(popupMenu);
            }else{
                System.err.println("applyPopupItems >> actor is not JComponent.");
            }
        }
    }
}
