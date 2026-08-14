package com.heaven7.gen.doc.impl;

import com.heaven7.gen.doc.RuleTypeDelegate2;
import com.heaven7.gen.doc.bean.EnvRule;
import com.heaven7.gen.doc.bean.RuleItem;

import java.util.Map;

public class EnvTypeDelegate extends RuleTypeDelegate2<EnvRule> {

    @Override
    protected void populateKVPairs(Map<String, String> kvs) {

    }
    @Override
    protected EnvRule prepare(RuleItem container) {
        EnvRule rule = container.getEnvRule();
        if(rule == null){
            rule = new EnvRule();
            container.setEnvRule(rule);
        }
        return rule;
    }
    @Override
    protected void addSubItem(EnvRule module, RuleItem ri) {

    }
}
