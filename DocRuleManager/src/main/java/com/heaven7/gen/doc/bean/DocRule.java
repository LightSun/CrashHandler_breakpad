package com.heaven7.gen.doc.bean;

import java.util.ArrayList;
import java.util.List;

public class DocRule implements IParserBean{

    public String title;
    public String saveFile;
    public List<Module> modules = new ArrayList<>();

    public boolean isAllBaseValid(){
        return title != null && saveFile != null;
    }

    public void setAllModuleIndex(int index){
        for (int i = 0; i < modules.size(); i++) {
            Module module = modules.get(i);
            module.index = index;
        }
    }

    public static class Module implements IParserBean{
        public int index = -1;
        public String name;
        public List<ClassItem> classItems = new ArrayList<>();

        public boolean isAllBaseValid(){
            return index >= 0 && name != null;
        }
    }
    public static class ClassItem implements IParserBean{
        public String desc; //like 全局事件循环类
        public String funcContent;
        public ClassDefine classDefine;
        public List<FieldInfo> fields = new ArrayList<>();
        public List<MethodInfo> methods = new ArrayList<>();

        public boolean isAllBaseValid(){
            return desc != null && funcContent != null;
        }
    }
    public static class ClassDefine implements IParserBean{
        public String className;
        public String superClassName = "";
        public String extendMethod = "public";

        public boolean isAllBaseValid(){
            return className != null && superClassName != null
                    && extendMethod != null;
        }
    }
    public static class FieldInfo implements IParserBean{
        public String name;
        public String type;
        public String desc;

        public boolean isAllBaseValid(){
            return name != null && type != null
                    && desc != null;
        }
    }
    public static class MethodInfo implements IParserBean{
        public String name;
        public String paramsStr;
        public String returnStr;
        public String desc;
        public String preset;

        public boolean isAllBaseValid(){
            return name != null && paramsStr != null
                    && desc != null && returnStr != null;
        }
    }
}
