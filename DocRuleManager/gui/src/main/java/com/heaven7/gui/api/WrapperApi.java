package com.heaven7.gui.api;

import com.heaven7.gui.Api;
import com.heaven7.gui.GuiContext;
import com.heaven7.gui.Orientation;
import com.heaven7.gui.View;
import com.heaven7.gui.utils.HistoryManager;

import java.util.List;

public class WrapperApi implements Api.ICommon, Api.IContainer, Api.IImage, Api.ISpace,
        Api.ILinearLayout, Api.IPullDownBox, Api.IScroll,Api.IText,
        Api.ISelectFileLine, Api.ICardLayout, Api.IFlowLayout,
        Api.IProgressBar
        {

    private final Api.ICommon impl;
    private final String name;

    public WrapperApi(Api.ICommon impl) {
        this.impl = impl;
        name = impl.getClass().getSimpleName();
    }

    public Api.ICommon getImpl(){
        return impl;
    }

    @Override
    public String getId() {
        return impl.getId();
    }

    @Override
    public void setId(String id) {
        System.out.println(name + " >> setId() -> " + id);
        impl.setId(id);
    }

    @Override
    public void bindGuiContext(GuiContext ctx) {
        System.out.println(name + " >> bindGuiContext() -> " + ctx);
        impl.bindGuiContext(ctx);
    }
    @Override
    public void onParseDone(View view) {
        impl.onParseDone(view);
    }
    @Override
    public void setPopupItems(List<String> items) {
        System.out.println(name + " >> setPopupItems() -> " + items);
        impl.setPopupItems(items);
    }
    @Override
    public HistoryManager<List<String>> getPopupHistoryManager() {
        return impl.getPopupHistoryManager();
    }
    @Override
    public void applyPopupItems(List<String> popupItems) {
        impl.applyPopupItems(popupItems);
    }

    @Override
    public Object getActor() {
        return impl.getActor();
    }

    @Override
    public void setSize(int width, int height) {
        System.out.println(name + " >> setSize() -> " + width + " ," + height);
        impl.setSize(width, height);
    }

    @Override
    public void setBackgroundColor(String rgb) {
        System.out.println(name + " >> setBackgroundColor() -> " + rgb);
        impl.setBackgroundColor(rgb);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        System.out.println(name + " >> setPadding() -> " + left + "," + top + "," + right + "," + bottom);
        impl.setPadding(left, top, right, bottom);
    }

    @Override
    public void setMargin(int left, int top, int right, int bottom) {
        System.out.println(name + " >> setMargin() -> " + left + "," + top + "," + right + "," + bottom);
        impl.setMargin(left, top, right, bottom);
    }

    @Override
    public void addView(View view) {
        System.out.println(name + " >> addView() -> " + view);
        impl.cast(Api.IContainer.class).addView(view);
    }

    @Override
    public void setOrientation(Orientation ori) {
        System.out.println(name + " >> setOrientation() -> " + ori);
        impl.cast(Api.IContainer.class).setOrientation(ori);
    }

    @Override
    public void setTextSize(float textSize) {
        System.out.println(name + " >> setTextSize() -> " + textSize);
        impl.cast(Api.IText.class).setTextSize(textSize);
    }

    @Override
    public void setTextColor(String rgb) {
        System.out.println(name + " >> setTextColor() -> " + rgb);
        impl.cast(Api.IText.class).setTextColor(rgb);
    }

    @Override
    public void setText(String txt) {
        System.out.println(name + " >> setText() -> " + txt);
        impl.cast(Api.IText.class).setText(txt);
    }

    @Override
    public void setBounds(int x, int y, int w, int h) {
        System.out.println(name + " >> setBounds() -> " + x + "," + y + "," + w + "," + h);
        impl.cast(Api.IImage.class).setBounds(x,y,w,h);
    }

    @Override
    public void setImageFile(String path) {
        System.out.println(name + " >> setImageFile() -> " + path);
        impl.cast(Api.IImage.class).setImageFile(path);
    }

    @Override
    public void setContainerView(View view) {
        System.out.println(name + " >> setContainerView() -> " + view);
        impl.cast(Api.IScroll.class).setContainerView(view);
    }

    @Override
    public void resetScrollPosition() {
        System.out.println(name + " >> resetScrollPosition() -> ");
        impl.cast(Api.IScroll.class).resetScrollPosition();
    }

    @Override
    public void setItems(List<String> l) {
        System.out.println(name + " >> setItems() -> " + l);
        impl.cast(Api.IPullDownBox.class).setItems(l);
    }

    @Override
    public void addItem(String item) {
        System.out.println(name + " >> addItem() -> " + item);
        impl.cast(Api.IPullDownBox.class).addItem(item);
    }

    @Override
    public void removeAllItems() {
        System.out.println(name + " >> removeAllItems() -> ");
        impl.cast(Api.IPullDownBox.class).removeAllItems();
    }

    @Override
    public void setLabelText(String text) {
        System.out.println(name + " >> setLabelText() -> " + text);
        impl.cast(Api.ISelectFileLine.class).setLabelText(text);
    }

    @Override
    public void setLabelSize(int w, int h) {
        System.out.println(name + " >> setLabelText() -> " + w + ", " + h);
        impl.cast(Api.ISelectFileLine.class).setLabelSize(w, h);
    }

    @Override
    public void setButtonText(String text) {
        System.out.println(name + " >> setButtonText() -> " + text);
        impl.cast(Api.ISelectFileLine.class).setButtonText(text);
    }

    @Override
    public void setButtonSize(int w, int h) {
        System.out.println(name + " >> setButtonSize() -> " + w + ", " + h);
        impl.cast(Api.ISelectFileLine.class).setButtonSize(w, h);
    }

    @Override
    public void setEditTextSize(int w, int h) {
        System.out.println(name + " >> setEditTextSize() -> " + w + ", " + h);
        impl.cast(Api.ISelectFileLine.class).setEditTextSize(w, h);
    }
    @Override
    public void setBasePath(String text) {
        System.out.println(name + " >> setBasePath() -> " + text);
        impl.cast(Api.ISelectFileLine.class).setBasePath(text);
    }

    @Override
    public void setSelectFileMode(Mode mode) {
        System.out.println(name + " >> setSelectFileMode() -> " + mode);
        impl.cast(Api.ISelectFileLine.class).setSelectFileMode(mode);
    }
    @Override
    public String getText() {
        return impl.cast(Api.IText.class).getText();
    }
    @Override
    public String getSelectedText() {
        return impl.cast(Api.IText.class).getSelectedText();
    }
    @Override
    public String getBasePath() {
        return impl.cast(Api.ISelectFileLine.class).getBasePath();
    }

    @Override
    public void showByIndex(int index) {
        System.out.println(name + " >> showByIndex() -> " + index);
        impl.cast(Api.ICardLayout.class).showByIndex(index);
    }

    @Override
    public void show(String tag) {
        System.out.println(name + " >> show() -> " + tag);
        impl.cast(Api.ICardLayout.class).show(tag);
    }
    @Override
    public int getVisibleIndex() {
        return impl.cast(Api.ICardLayout.class).getVisibleIndex();
    }

    @Override
    public int getComponentCount() {
        return impl.cast(Api.ICardLayout.class).getComponentCount();
    }

    @Override
    public int getMaxProgress() {
        return impl.cast(Api.IProgressBar.class).getMaxProgress();
    }

    @Override
    public void setMaxProgress(int max) {
        System.out.println(name + " >> setMaxProgress() -> " + max);
        impl.cast(Api.IProgressBar.class).setMaxProgress(max);
    }

    @Override
    public void setProgress(int val) {
        System.out.println(name + " >> setProgress() -> " + val);
        impl.cast(Api.IProgressBar.class).setProgress(val);
    }

    @Override
    public int getProgress() {
        return impl.cast(Api.IProgressBar.class).getProgress();
    }
}
