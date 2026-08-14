package com.heaven7.gui;

public class PairProperties {

    private int width = 0;
    private int height = 0;
    private boolean whValid = true;

    public boolean isWHValueValid(){
        return width != 0 && height != 0;
    }
    public boolean isWhValid(){
        return whValid;
    }
    public void markWhValid(boolean valid){
        whValid = valid;
        if(!valid){
            width = 0;
            height = 0;
        }
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
