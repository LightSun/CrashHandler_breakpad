package com.heaven7.gen.doc.impl;

import com.heaven7.gen.doc.RuleTypeDelegate2;
import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.gen.doc.bean.RuleItem;

import java.util.Map;

public class ClassItemTypeDelegate extends RuleTypeDelegate2<DocRule.ClassItem> {

    @Override
    protected void populateKVPairs(Map<String, String> kvs) {
        kvs.put("desc", "desc");
        kvs.put("funcContent", "funcContent");
    }

    @Override
    protected DocRule.ClassItem prepare(RuleItem container) {
        DocRule.ClassItem module = container.getClassItem();
        if(module == null){
            module = new DocRule.ClassItem();
            container.setClassItem(module);
        }
        return module;
    }

    @Override
    protected void addSubItem(DocRule.ClassItem module, RuleItem ri) {
        if(ri.getClassDefine() != null){
            module.classDefine = ri.getClassDefine();
        }else if(ri.getFieldInfo() != null){
            module.fields.add(ri.getFieldInfo());
        }else if(ri.getMethodInfo() != null){
            module.methods.add(ri.getMethodInfo());
        }else{
            throw new RuntimeException("in ClassItemTypeDelegate");
        }
    }
}
