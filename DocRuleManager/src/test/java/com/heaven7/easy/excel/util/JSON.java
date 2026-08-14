package com.heaven7.easy.excel.util;

import com.google.gson.Gson;

public final class JSON {

    public static String toJSONString(Object obj){
        return new Gson().toJson(obj);
    }
}
