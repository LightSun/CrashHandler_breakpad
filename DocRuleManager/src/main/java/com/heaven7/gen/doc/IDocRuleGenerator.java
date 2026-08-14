package com.heaven7.gen.doc;

import com.heaven7.gen.doc.bean.DocRule;

/**
 * generate the file you want by rule
 */
public interface IDocRuleGenerator {

    default void gen(DocRule rule){
        gen(rule, rule.saveFile);
    }

    void gen(DocRule rule, String savePath);
}
