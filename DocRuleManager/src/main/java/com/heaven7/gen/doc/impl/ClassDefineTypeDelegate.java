package com.heaven7.gen.doc.impl;

import com.heaven7.gen.doc.RuleTypeDelegate2;
import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.gen.doc.bean.RuleItem;

import java.util.Map;

public class ClassDefineTypeDelegate extends RuleTypeDelegate2<DocRule.ClassDefine> {

    @Override
    protected void populateKVPairs(Map<String, String> kvs) {
        kvs.put("className","className");
        kvs.put("superClassName","superClassName");
        kvs.put("extendMethod","extendMethod");
    }

    @Override
    protected DocRule.ClassDefine prepare(RuleItem container) {
        DocRule.ClassDefine module = container.getClassDefine();
        if(module == null){
            module = new DocRule.ClassDefine();
            container.setClassDefine(module);
        }
        return module;
    }

    @Override
    protected void addSubItem(DocRule.ClassDefine module, RuleItem ri) {

    }
}
