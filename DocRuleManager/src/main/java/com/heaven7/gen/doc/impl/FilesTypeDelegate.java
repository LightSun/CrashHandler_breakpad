package com.heaven7.gen.doc.impl;

import com.heaven7.gen.doc.DocRuleParser;
import com.heaven7.gen.doc.RuleTypeDelegate;
import com.heaven7.gen.doc.bean.FilesRule;
import com.heaven7.gen.doc.bean.RuleItem;

public class FilesTypeDelegate extends RuleTypeDelegate {

    @Override
    public void parse(DocRuleParser.TypeContent tc, RuleItem container) {
        FilesRule rule = container.getFilesRule();
        if(rule == null){
            rule = new FilesRule();
            container.setFilesRule(rule);
        }
        for (int i = 0; i < tc.lines.size(); i++) {
            String s = tc.lines.get(i);
            if (isInvalidLine(s)) {
                continue;
            }
            if(s.contains(":")){
                int index = s.indexOf(":");
                String fp = s.substring(0, index).trim();
                String mod_idx = s.substring(index + 1).trim();
                rule.modelIndexMap.put(fp, Integer.parseInt(mod_idx));
            }
            else{
                rule.files.add(s);
            }
        }
    }
}
