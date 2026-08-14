package com.heaven7.gui.utils;

import java.util.HashMap;
import java.util.Map;

public final class ArgsParser {
    private final Map<String, String> kmap = new HashMap<>();

    public ArgsParser(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            String arg1 = args[i];
            kmap.put(arg1.substring(2), args[i + 1]);
        }
    }
    public ArgsParser(Map<String, String> sm) {
        kmap.putAll(sm);
    }

    public String getValue(String k) {
        return kmap.get(k);
    }

    public void put(String k, String v) {
        kmap.put(k, v);
    }

    public ArgsParser copy() {
        return new ArgsParser(kmap);
    }
}