package com.heaven7.gen.doc.impl;

import com.heaven7.gen.doc.RuleTypeDelegate2;
import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.gen.doc.bean.RuleItem;

import java.util.Map;

public class FieldInfoTypeDelegate extends RuleTypeDelegate2<DocRule.FieldInfo> {

    @Override
    protected void populateKVPairs(Map<String, String> kvs) {
        kvs.put("name","name");
        kvs.put("type","type");
        kvs.put("desc","desc");
    }

    @Override
    protected DocRule.FieldInfo prepare(RuleItem container) {
        DocRule.FieldInfo module = container.getFieldInfo();
        if(module == null){
            module = new DocRule.FieldInfo();
            container.setFieldInfo(module);
        }
        return module;
    }

    @Override
    protected void addSubItem(DocRule.FieldInfo module, RuleItem ri) {

    }
}
