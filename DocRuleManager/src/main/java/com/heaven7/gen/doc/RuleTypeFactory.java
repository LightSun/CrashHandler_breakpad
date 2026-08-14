package com.heaven7.gen.doc;

import com.heaven7.gen.doc.bean.RuleItem;
import com.heaven7.gen.doc.impl.*;

import java.util.HashMap;
import java.util.Map;

public class RuleTypeFactory {

    private final Map<DocRuleParser.Type, RuleTypeDelegate> sMap = new HashMap<>();
    private static final RuleTypeFactory sFactory = new RuleTypeFactory();

    public RuleTypeFactory() {
        sMap.put(DocRuleParser.Type.DocRule, new DocRuleTypeDelegate());
        sMap.put(DocRuleParser.Type.Module, new ModuleTypeDelegate());
        sMap.put(DocRuleParser.Type.ClassItem, new ClassItemTypeDelegate());
        sMap.put(DocRuleParser.Type.ClassDefine, new ClassDefineTypeDelegate());
        sMap.put(DocRuleParser.Type.Field, new FieldInfoTypeDelegate());
        sMap.put(DocRuleParser.Type.Method, new MethodInfoTypeDelegate());
        sMap.put(DocRuleParser.Type.WholeConfig, new WholeConfigTypeDelegate());
        sMap.put(DocRuleParser.Type.Env, new EnvTypeDelegate());
        sMap.put(DocRuleParser.Type.Files, new FilesTypeDelegate());
    }

    public static RuleTypeFactory get(){
        return sFactory;
    }

    public void parseRule(DocRuleParser.TypeContent tc, RuleItem parent){
        RuleTypeDelegate delegate = sMap.get(tc.type);
        delegate.parse(tc, parent);
    }
}
