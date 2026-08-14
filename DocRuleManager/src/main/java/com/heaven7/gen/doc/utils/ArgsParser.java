package com.heaven7.gen.doc.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgsParser {
    private final Map<String, String> kmap = new HashMap<>();

    public ArgsParser(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            String arg1 = args[i];
            kmap.put(arg1.substring(2), args[i + 1]);
        }
    }

    public ArgsParser(int startIdx, String[] args) {
        for (int i = startIdx; i < args.length; i += 2) {
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

    public ArgsParser copy(List<String> excludeKeys) {
        Map<String, String> newMap = new HashMap<>();
        for(Map.Entry<String,String> en : kmap.entrySet()){
            if(!excludeKeys.contains(en.getKey())){
                newMap.put(en.getKey(), en.getValue());
            }
        }
        return new ArgsParser(newMap);
    }
    public Map<String, String> getKmap() {
        return kmap;
    }

    public int size(){
        return kmap.size();
    }
}