package com.heaven7.gen.doc;

import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.gen.doc.bean.RuleItem;
import com.heaven7.gen.doc.bean.WholeConfigRule;
import com.heaven7.gen.doc.utils.StringUtils;
import com.heaven7.java.base.util.Throwables;

import java.util.*;

public class DocRuleExecutor {

    private final IDocRuleGenerator m_gen;
    private final HashMap<String, String> mPresetEnv = new HashMap<>();

    public DocRuleExecutor(IDocRuleGenerator m_gen) {
        this.m_gen = m_gen;
    }
    public DocRuleExecutor() {
        this.m_gen = new DocGenerator();
    }
    public void setEnv(String key, String v){
        mPresetEnv.put(key, v);
    }

    public void setEnvs(Map<String, String> env){
        mPresetEnv.putAll(env);
    }

    public void execute(String file){
        execute(file, null);
    }
    public void execute(String file, String saveFile){
        List<DocRuleParser.TypeContent> typeContents = DocRuleParser.parseFile(file);
        List<DocRule> rules = parseDocRules(typeContents);
        for (int i = 0; i < rules.size(); i++) {
            DocRule docRule = rules.get(i);
            if(saveFile != null){
                m_gen.gen(docRule, saveFile);
            }else{
                m_gen.gen(docRule);
            }
        }
    }
    public void executeWholeConfigFile(String file){
        executeWholeConfigFile(file, null);
    }
    public void executeWholeConfigFile(String file, String saveFile){
        List<DocRuleParser.TypeContent> typeContents = DocRuleParser.parseFile(file);
        List<WholeConfigRule> rules = new ArrayList<>();
        for (int i = 0; i < typeContents.size(); i++) {
            DocRuleParser.TypeContent tc = typeContents.get(i);
            RuleItem ruleItem = new RuleItem();
            RuleTypeFactory.get().parseRule(tc, ruleItem);
            WholeConfigRule docRule = ruleItem.getWholeConfigRule();
            Throwables.checkArgument(docRule != null, "");
            rules.add(docRule);
        }
        for (int i = 0; i < rules.size(); i++) {
            WholeConfigRule wrule = rules.get(i);
            wrule.resolveEnv(mPresetEnv);
            //merge by same-module-index
            List<DocRule> allDocRules = new ArrayList<>();
            if(wrule.filesRule != null){
                List<String> files = wrule.filesRule.files;
                for (int j = 0; j < files.size(); j++) {
                    String f1 = files.get(j);
                    List<DocRuleParser.TypeContent> nss = DocRuleParser.parseFile(f1);
                    List<DocRule> krules = parseDocRules(nss);
                    Integer modelIndex = wrule.filesRule.getModelIndex(f1);
                    if(modelIndex != null){
                        for (DocRule dr1 : krules) {
                            dr1.setAllModuleIndex(modelIndex);
                        }
                    }
                    allDocRules.addAll(krules);
                }
            }
            Map<Integer, DocRule.Module> modMap = new TreeMap<>();
            for (int j = 0; j < allDocRules.size(); j++) {
                DocRule rule1 = allDocRules.get(j);
                List<DocRule.Module> modules = rule1.modules;
                if(modules != null){
                    for (DocRule.Module m: modules) {
                        DocRule.Module nmod = modMap.get(m.index);
                        if(nmod == null){
                            modMap.put(m.index, m);
                        }else{
                            nmod.classItems.addAll(m.classItems);
                        }
                    }
                }
            }
            DocRule docRule = new DocRule();
            docRule.title = wrule.title;
            if(saveFile != null){
                docRule.saveFile = saveFile;
            }else{
                docRule.saveFile = wrule.saveFile;
            }
            if(docRule.saveFile != null){
                docRule.saveFile = StringUtils.rep_content(wrule.envRule.env, docRule.saveFile);
            }
            for (Map.Entry<Integer, DocRule.Module> en: modMap.entrySet()) {
                docRule.modules.add(en.getValue());
            }
            m_gen.gen(docRule);
        }
    }
    private static List<DocRule> parseDocRules(List<DocRuleParser.TypeContent> typeContents){
        List<DocRule> rules = new ArrayList<>();
        for (int i = 0; i < typeContents.size(); i++) {
            DocRuleParser.TypeContent tc = typeContents.get(i);
            RuleItem ruleItem = new RuleItem();
            RuleTypeFactory.get().parseRule(tc, ruleItem);
            DocRule docRule = ruleItem.getDocRule();
            Throwables.checkArgument(docRule != null, "");
            rules.add(docRule);
        }
        return rules;
    }

}
