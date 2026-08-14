package com.heaven7.gen.doc.impl;

import com.heaven7.gen.doc.RuleTypeDelegate2;
import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.gen.doc.bean.RuleItem;

import java.util.Map;

public class ModuleTypeDelegate extends RuleTypeDelegate2<DocRule.Module> {

    @Override
    protected void populateKVPairs(Map<String, String> kvs) {
        kvs.put("index", "index");
        kvs.put("name", "name");
    }

    @Override
    protected DocRule.Module prepare(RuleItem container) {
        DocRule.Module module = container.getModule();
        if(module == null){
            module = new DocRule.Module();
            container.setModule(module);
        }
        return module;
    }

    @Override
    protected void addSubItem(DocRule.Module item, RuleItem sub) {
        item.classItems.add(sub.getClassItem());
    }
}
