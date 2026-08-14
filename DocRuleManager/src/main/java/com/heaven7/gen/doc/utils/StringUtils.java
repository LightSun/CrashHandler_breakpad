package com.heaven7.gen.doc.utils;

import com.heaven7.gen.doc.bean.UnitTestItem;
import com.heaven7.java.base.util.Throwables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class StringUtils {

    public static String rep_content(Map<String, String> map, String line){
        String val = line;
        if(line != null && !line.isEmpty()){
            String _key;
            int s1, s2;
            String newVal;
            while (true){
                s1 = val.indexOf("${");
                if(s1 >=0 ){
                    s2 = val.indexOf("}", s1 + 2);
                    _key = val.substring(s1 + 2, s2);
                    newVal = map.get(_key);
                    if(newVal == null){
                        System.out.println("ConvertModelOp >> can't find replacement, for key = " + _key);
                        break;
                    }else{
                        val = val.replace("${"+ _key + "}", newVal);
                        //val = h7::utils::replace("\\$\\{"+ _key + "\\}", newVal, val);
                    }
                }else{
                    break;
                }
            }
        }
        return val;
    }
    public static void parsePreset(UnitTestItem item, String str){
        String defStep = "1、编写用例函数\n2、调用测试函数";
        List<Pair> pairs = new ArrayList<>();
        int startIdx = 0;
        while (true){
            int id1 = str.indexOf("[", startIdx);
            if(id1 < 0){
                break;
            }
            int id2 = str.indexOf("]", id1 + 1);
            if(id2 < 0){
                throw new IllegalStateException("parsePreset >> failed. str = " + str);
            }
            String str2 = str.substring(id1 + 1, id2).trim();
            String[] strs = str2.split("->");
            Throwables.checkArgument(strs.length == 2, "");
            pairs.add(new Pair(strs[0], strs[1]));
            startIdx = id2 + 1;
        }
        for (int i = 0; i < pairs.size(); i++) {
            Pair p = pairs.get(i);
            if(p.first.isEmpty()){
                item.addPresetStepExpect("无", defStep, p.second);
            }else{
                item.addPresetStepExpect(p.first, defStep, p.second);
            }
        }
    }
    private static class Pair{
        String first;
        String second;
        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
