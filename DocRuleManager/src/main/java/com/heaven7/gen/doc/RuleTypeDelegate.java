package com.heaven7.gen.doc;

import com.heaven7.gen.doc.bean.KVPair;
import com.heaven7.gen.doc.bean.RuleItem;

public abstract class RuleTypeDelegate {

    public abstract void parse(DocRuleParser.TypeContent tc, RuleItem container);

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
}
