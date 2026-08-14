package com.heaven7.gui;

import com.heaven7.gui.utils.HistoryManager;

import java.util.List;

public interface Api {

    int MATCH_PARENT = -1;

    interface ICommon{

        String getId();
        void setId(String id);
        void bindGuiContext(GuiContext ctx);
        void onParseDone(View view);
        void setPopupItems(List<String> items);
        void applyPopupItems(List<String> popupItems);
        HistoryManager<List<String>> getPopupHistoryManager();

        Object getActor();
        void setSize(int width, int height);
        void setBackgroundColor(String rgb);
        void setPadding(int left, int top, int right, int bottom);
        void setMargin(int left, int top, int right, int bottom);

        default IText asText(){
            return (IText)this;
        }
        default <T> T cast(Class<T> cls){
            Class<? extends ICommon> curCls = getClass();
            if(curCls == cls || cls.isAssignableFrom(curCls)){
                return (T) this;
            }
            throw new RuntimeException();
        }
        default <T> T getActorAs(Class<T> cls){
            Object actor = getActor();
            if(cls.isAssignableFrom(actor.getClass())){
                return (T) actor;
            }
            throw new RuntimeException();
        }
    }
    interface IContainer{
        void addView(View view);
        void setOrientation(Orientation ori);
    }
    interface IText extends ICommon{
        void setTextSize(float textSize);
        void setTextColor(String rgb);
        void setText(String txt);
        String getText();
        String getSelectedText();
    }
    interface IImage extends ICommon{
        void setBounds(int x, int y, int w, int h);
        void setImageFile(String path);
    }
    interface IScroll extends IContainer{
        void setContainerView(View view);
        void resetScrollPosition();
    }
    interface IPullDownBox{
        void setItems(List<String> l);
        void addItem(String item);
        void removeAllItems();
    }
    interface ILinearLayout extends IContainer{
    }
    interface ICardLayout extends IContainer{
        default void showNext(){
            int idx = getVisibleIndex();
            if(idx >= getComponentCount() - 1){
                idx = 0;
            }else{
                idx ++;
            }
            showByIndex(idx);
        }
        void showByIndex(int index);
        void show(String tag);
        int getVisibleIndex();
        int getComponentCount();
    }
    interface IFlowLayout extends IContainer{

    }
    interface ISpace{

    }
    interface IProgressBar{
        int getMaxProgress();
        void setMaxProgress(int max);
        void setProgress(int val);
        int getProgress();
    }
    interface ISelectFileLine{
        void setLabelText(String text);
        void setLabelSize(int w, int h);
        void setButtonText(String text);
        void setButtonSize(int w, int h);
        void setEditTextSize(int w, int h);
        void setBasePath(String path);
        void setSelectFileMode(Mode mode);
        String getBasePath();
        enum Mode{
            FILE, DIR, FILE_WITH_DIR
        }
    }
}
