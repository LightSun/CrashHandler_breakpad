package com.heaven7.gen.doc.impl;

import com.heaven7.gen.doc.RuleTypeDelegate2;
import com.heaven7.gen.doc.bean.RuleItem;
import com.heaven7.gen.doc.bean.WholeConfigRule;

import java.util.Map;

public class WholeConfigTypeDelegate extends RuleTypeDelegate2<WholeConfigRule> {

    @Override
    protected void populateKVPairs(Map<String, String> kvs) {
        kvs.put("title", "title");
        kvs.put("saveFile", "saveFile");
    }
    @Override
    protected WholeConfigRule prepare(RuleItem container) {
        WholeConfigRule rule = container.getWholeConfigRule();
        if(rule == null){
            rule = new WholeConfigRule();
            container.setWholeConfigRule(rule);
        }
        return rule;
    }
    @Override
    protected void addSubItem(WholeConfigRule module, RuleItem ri) {
        if(ri.getEnvRule() != null){
            module.envRule = ri.getEnvRule();
        }else if(ri.getFilesRule() != null){
            module.filesRule = ri.getFilesRule();
        }
    }
}
