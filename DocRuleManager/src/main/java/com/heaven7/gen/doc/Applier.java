package com.heaven7.gen.doc;

import com.heaven7.gen.doc.bean.KVPair;

public interface Applier<T>{
    void applyKVPair(T t, KVPair p);
}