package com.heaven7.gui.parser;

import java.util.*;

public class UIElement {
    private final String name;
    private final Map<String, String> attributes = new LinkedHashMap<>();
    private final List<UIElement> children = new ArrayList<>();

    public UIElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public List<UIElement> getChildren() {
        return children;
    }

    public void setAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public void addChild(UIElement child) {
        children.add(child);
    }

    public String getAttr(String key) {
        return attributes.get(key);
    }

    public List<Integer> getAttrAsIntList(String key) {
        String val = attributes.get(key);
        if (val == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        for (String s : val.split(",")) res.add(Integer.parseInt(s.trim()));
        return res;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString2() {
        return this.getClass().getName() + "@" + Integer.toHexString(this.hashCode());
    }

    private String toString(int indent) {
        StringBuilder sb0 = new StringBuilder();
        for(int i = 0 ; i < indent; ++i){
            sb0.append("  ");
        }
        String pad = sb0.toString();
        StringBuilder sb = new StringBuilder(pad).append(name).append(" {\n");
        for (Map.Entry<String, String> e : attributes.entrySet())
            sb.append(pad).append("  ").append(e.getKey()).append(": ").append(e.getValue()).append("\n");
        for (UIElement child : children) sb.append(child.toString(indent + 1));
        sb.append(pad).append("}\n");
        return sb.toString();
    }
}