package com.heaven7.gen.doc.bean;

import com.heaven7.gen.doc.Applier;
import com.heaven7.gen.doc.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class EnvRule implements IParserBean, Applier<EnvRule> {

    public final Map<String,String> env = new HashMap<>();

    @Override
    public boolean isAllBaseValid() {
        return false;
    }
    @Override
    public void applyKVPair(EnvRule envRule, KVPair p) {
        env.put(p.key, p.value);
    }

    public void resolveEnv(Map<String,String> kenv){
        env.putAll(kenv);
        for (Map.Entry<String,String> en: env.entrySet()) {
            String value = en.getValue();
            String newVal = StringUtils.rep_content(env, value);
            en.setValue(newVal);
        }
    }
}
