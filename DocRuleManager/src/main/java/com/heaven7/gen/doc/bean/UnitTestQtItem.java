package com.heaven7.gen.doc.bean;

import java.util.List;

public class UnitTestQtItem {

    private String className;
    private List<String> methodNames;
    private List<UnitTestItem> kitems;

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getMethodNames() {
        return methodNames;
    }
    public void setMethodNames(List<String> methodName) {
        this.methodNames = methodName;
    }

    public List<UnitTestItem> getKitems() {
        return kitems;
    }
    public void setKitems(List<UnitTestItem> kitems) {
        this.kitems = kitems;
    }
}
