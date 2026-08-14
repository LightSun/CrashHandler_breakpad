package com.heaven7.gui.bean;

public class KVPair {

    public final String key;
    public final String value;

    public KVPair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "KVPair{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}