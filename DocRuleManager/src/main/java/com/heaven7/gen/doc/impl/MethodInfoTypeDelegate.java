package com.heaven7.gen.doc.impl;

import com.heaven7.gen.doc.DocRuleParser;
import com.heaven7.gen.doc.RuleTypeDelegate2;
import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.gen.doc.bean.RuleItem;

import java.util.Map;

public class MethodInfoTypeDelegate extends RuleTypeDelegate2<DocRule.MethodInfo> {

    @Override
    protected void populateKVPairs(Map<String, String> kvs) {
        kvs.put("name","name");
        kvs.put("paramStr","paramsStr");
        kvs.put("returnStr","returnStr");
        kvs.put("desc","desc");
        kvs.put("preset","preset");
    }

    @Override
    protected DocRule.MethodInfo prepare(RuleItem container) {
        DocRule.MethodInfo module = container.getMethodInfo();
        if(module == null){
            module = new DocRule.MethodInfo();
            container.setMethodInfo(module);
        }
        return module;
    }

    @Override
    protected void addSubItem(DocRule.MethodInfo module, RuleItem ri) {

    }

    @Override
    protected int skipLines(DocRuleParser.TypeContent tc, int curLineIdx, DocRule.MethodInfo bean) {
        String s = tc.lines.get(curLineIdx);
        if(s.startsWith("preset:")){
            int lineCnt = 1;
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            int id1 = s.indexOf("(");
            int id2 = s.indexOf(")");
            if(id1 < 0){
                throw new IllegalStateException("parse preset failed.");
            }
            if (id2 < 0){
                for(int i = curLineIdx + 1; i < tc.lines.size(); ++i){
                    s = tc.lines.get(i);
                    sb.append(s);
                    lineCnt ++;
                    id2 = s.indexOf(")");
                    if (id2 >= 0){
                        break;
                    }
                }
            }
            bean.preset = sb.toString();
            return lineCnt;
        }else{
            return 0;
        }
    }
}
