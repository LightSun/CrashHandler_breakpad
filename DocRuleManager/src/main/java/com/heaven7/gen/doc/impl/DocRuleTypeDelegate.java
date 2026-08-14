package com.heaven7.gen.doc.impl;

import com.heaven7.gen.doc.RuleTypeDelegate2;
import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.gen.doc.bean.RuleItem;

import java.util.Map;

public class DocRuleTypeDelegate extends RuleTypeDelegate2<DocRule> {

    public DocRuleTypeDelegate() {
        super();
    }

    @Override
    protected void populateKVPairs(Map<String, String> kvs) {
        kvs.put("title", "title");
        kvs.put("saveFile", "saveFile");
    }

    @Override
    protected DocRule prepare(RuleItem container) {
        DocRule rule = container.getDocRule();
        if(rule == null){
            rule = new DocRule();
            container.setDocRule(rule);
        }
        return rule;
    }
    @Override
    protected void addSubItem(DocRule item, RuleItem sub) {
        item.modules.add(sub.getModule());
    }
}
