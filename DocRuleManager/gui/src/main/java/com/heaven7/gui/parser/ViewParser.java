package com.heaven7.gui.parser;

import com.heaven7.gui.*;
import com.heaven7.gui.bean.KVPair;
import com.heaven7.java.base.util.IOUtils;
import com.heaven7.java.base.util.Throwables;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public abstract class ViewParser {

    private GuiContext context;

    public GuiContext getGuiContext() {
        return context;
    }
    public void setGuiContext(GuiContext context) {
        this.context = context;
    }

    public static KVPair parseKV(String line){
        int index = line.indexOf("=");
        if(index < 0){
            index = line.indexOf(":");
        }
        if(index < 0){
            return null;
        }
        String key = line.substring(0, index).trim();
        String val = line.substring(index + 1).trim();
        return new KVPair(key, val);
    }
    public static boolean isInvalidLine(String l){
        return l.isEmpty() || l.startsWith("#");
    }
    protected static int parseWidthOrHeight(String value){
        if(value.equals("MATCH_PARENT")){
            return Api.MATCH_PARENT;
        }else{
            return Integer.parseInt(value);
        }
    }
    public static String[] splitWithTrim(String value){
        String[] strs = value.split(",");
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].trim();
        }
        return strs;
    }
    private static void applySize(View cur, String value){
        Api.ICommon api = cur.getActorApi();
        String[] strs = splitWithTrim(value);
        Throwables.checkArgument(strs.length == 2, "");
        int w = parseWidthOrHeight(strs[0].trim());
        int h = parseWidthOrHeight(strs[1].trim());
        api.setSize(w, h);
    }
    private static void applyPadding(View cur, String value){
        Api.ICommon api = cur.getActorApi();
        String[] strs = splitWithTrim(value);
        Throwables.checkArgument(strs.length == 4, "");
        api.setPadding(Integer.parseInt(strs[0]),
                Integer.parseInt(strs[1]),
                Integer.parseInt(strs[2]),
                Integer.parseInt(strs[3])
                );
    }
    private static void applyMargin(View cur, String value){
        Api.ICommon api = cur.getActorApi();
        String[] strs = splitWithTrim(value);
        Throwables.checkArgument(strs.length == 4, "");
        api.setMargin(Integer.parseInt(strs[0]),
                Integer.parseInt(strs[1]),
                Integer.parseInt(strs[2]),
                Integer.parseInt(strs[3])
        );
    }
    private static void applyImageBounds(View cur, String value){
        Api.IImage api = cur.getActorApi().cast(Api.IImage.class);
        String[] strs = splitWithTrim(value);
        Throwables.checkArgument(strs.length == 4, "");
        api.setBounds(Integer.parseInt(strs[0]),
                Integer.parseInt(strs[1]),
                Integer.parseInt(strs[2]),
                Integer.parseInt(strs[3])
        );
    }
    private static void applyLabelSize(View cur, String value){
        Api.ISelectFileLine api = cur.getActorApi().cast(Api.ISelectFileLine.class);
        String[] strs = splitWithTrim(value);
        Throwables.checkArgument(strs.length == 2, "");
        api.setLabelSize(Integer.parseInt(strs[0]),
                Integer.parseInt(strs[1])
        );
    }
    private static void applyButtonSize(View cur, String value){
        Api.ISelectFileLine api = cur.getActorApi().cast(Api.ISelectFileLine.class);
        String[] strs = splitWithTrim(value);
        Throwables.checkArgument(strs.length == 2, "");
        api.setButtonSize(Integer.parseInt(strs[0]),
                Integer.parseInt(strs[1])
        );
    }
    private static void applyEditTextSize(View cur, String value){
        Api.ISelectFileLine api = cur.getActorApi().cast(Api.ISelectFileLine.class);
        String[] strs = splitWithTrim(value);
        Throwables.checkArgument(strs.length == 2, "");
        api.setEditTextSize(Integer.parseInt(strs[0]),
                Integer.parseInt(strs[1])
        );
    }
    private static void applyPopupItems(View cur, String value){
        String[] strs = splitWithTrim(value);
        Throwables.checkArgument(strs.length > 0, "");
        cur.getActorApi().setPopupItems(new ArrayList<>(Arrays.asList(strs)));
    }

    private static void applyItems(View cur, String value){
        String[] strs = splitWithTrim(value);
        Throwables.checkArgument(strs.length > 0, "");
        Api.ICommon api = cur.getActorApi();
        if(api instanceof Api.IPullDownBox){
            ((Api.IPullDownBox) api).setItems(Arrays.asList(strs));
        }
    }

    //------------------------------
    public View parseFile(String file){
        BufferedInputStream in  = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            String ts = new String(IOUtils.readBytes(in));
            return parseContent(ts);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            IOUtils.closeQuietly(in);
        }
    }
    //dsl: include '\n'
    public View parseContent(String dsl){
        UIParser parser = new UIParser();
        UIElement root = parser.parse(dsl);
        View rootView = parseImpl(null, root);
        getGuiContext().setRootView(rootView);
        getGuiContext().onParseDone();
        return rootView;
    }

    private View parseImpl(View parent, UIElement e){
//        if(context != null && context.isDebug()){
//            System.out.println("parent: " + parent + " --> " + e.toString2());
//        }
        PairProperties pp = new PairProperties();
        GuiParser.Type eleType = GuiParser.str2type(e.getName());
        View curView = new View(parent, createActorApi(eleType));
        //
        for(Map.Entry<String,String> en : e.getAttributes().entrySet()){
            KVPair p = new KVPair(en.getKey(), en.getValue());
            PropType type = getPropType(p.key);
            switch (type){
                case SIMPLE:{
                    parseSimple0(curView, pp, p);
                }break;

                case ARRAY:{
                    parseArray(curView, pp, p);
                }break;

                case EVENT:{
                    parseEvent(curView, pp, p);
                }break;
            }
        }
        for (int i = 0; i < e.getChildren().size(); i++) {
            UIElement ele = e.getChildren().get(i);
            View child = parseImpl(curView, ele);
            curView.getActorApi().cast(Api.IContainer.class).addView(child);
        }
        return curView;
    }

    protected abstract Api.ICommon createActorApi(GuiParser.Type type);
    //
    protected void parseSimple(View cur, PairProperties pp, KVPair p){

    }
    private void parseSimple0(View cur, PairProperties pp, KVPair p){
        switch (p.key){
            case "id":{
                cur.getActorApi().setId(p.value);
            }break;

            case "title":
            case "text": {
                cur.getActorApi().asText().setText(p.value);
            }break;

            case "textColor":{
                //#rgba
                cur.getActorApi().asText().setTextColor(p.value);
            }break;

            case "textSize":{
                cur.getActorApi().asText().setTextSize(Float.parseFloat(p.value));
            }break;

            case "width":{
                pp.setWidth(parseWidthOrHeight(p.value));
            }break;

            case "height":{
                pp.setHeight(parseWidthOrHeight(p.value));
            }break;

            case "orientation" : {
                applyOrientation(cur, p.value);
            }break;

            case "imagePath":{
                cur.getActorApi().cast(Api.IImage.class).setImageFile(p.value);
            }break;

            case "lab_text":{
                cur.getActorApi().cast(Api.ISelectFileLine.class).setLabelText(p.value);
            }break;
            case "btn_text":{
                cur.getActorApi().cast(Api.ISelectFileLine.class).setButtonText(p.value);
            }break;
            case "basePath":{
                cur.getActorApi().cast(Api.ISelectFileLine.class).setBasePath(p.value);
            }break;
            case "mode":{
                Api.ISelectFileLine.Mode mode = Api.ISelectFileLine.Mode.valueOf(p.value);
                cur.getActorApi().cast(Api.ISelectFileLine.class).setSelectFileMode(mode);
            }break;

            case "max_progress":{
                int val = Integer.parseInt(p.value);
                cur.getActorApi().cast(Api.IProgressBar.class).setMaxProgress(val);
            }break;
        }
        if(pp.isWhValid() && pp.isWHValueValid()){
            Api.ICommon api = cur.getActorApi();
            api.setSize(pp.getWidth(), pp.getHeight());
            pp.markWhValid(false);
        }
        parseSimple(cur, pp, p);
    }

    protected void parseArray(View cur, PairProperties pp, KVPair p){
        switch (p.key){
            case "size": {
                applySize(cur, p.value);
            }break;
            case "padding": {
                applyPadding(cur, p.value);
            }break;
            case "margin": {
                applyMargin(cur, p.value);
            }break;
            case "bounds": {
                applyImageBounds(cur, p.value);
            }break;

            case "lab_size":{
                applyLabelSize(cur, p.value);
            }break;

            case "btn_size":{
                applyButtonSize(cur, p.value);
            }break;

            case "et_size":{
                applyEditTextSize(cur, p.value);
            }break;

            case "items":{
                applyItems(cur, p.value);
            }break;

            case "popup_items":{
                applyPopupItems(cur, p.value);
            }break;
        }
    }
    protected void parseEvent(View cur, PairProperties pp, KVPair p){
        if(p.key.equals("listener")){
            try {
                Class<?> aClass = Class.forName(p.value);
                Object obj = aClass.getConstructor().newInstance();
                getGuiContext().setListener((BaseListener) obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void applyOrientation(View cur, String value){
        Api.IContainer layout = cur.getActorApi().cast(Api.IContainer.class);
        if(Orientation.Horizontal.name().toLowerCase().equals(value)){
            layout.setOrientation(Orientation.Horizontal);
        }else if(Orientation.Vertical.name().toLowerCase().equals(value)){
            layout.setOrientation(Orientation.Vertical);
        }
    }
    public static PropType getPropType(String key){
        if("items".equals(key)
                || "size".equals(key)
                || "padding".equals(key)
                || "margin".equals(key)
                || "bounds".equals(key)
                || "lab_size".equals(key)
                || "btn_size".equals(key)
                || "et_size".equals(key)
                || "popup_items".equals(key)
        ){
            return PropType.ARRAY;
        }
        if(key.equals("listener")){
            return PropType.EVENT;
        }
        return PropType.SIMPLE;
    }
    public enum PropType{
        SIMPLE, ARRAY, EVENT
    }
}
