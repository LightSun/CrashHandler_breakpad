package com.heaven7.gen.doc;


import com.heaven7.gen.doc.bean.IParserBean;
import com.heaven7.gen.doc.bean.KVPair;
import com.heaven7.gen.doc.bean.RuleItem;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class RuleTypeDelegate2<T extends IParserBean> extends RuleTypeDelegate{

    private final Map<String, Applier<T>> applierMap = new HashMap<>();

    public RuleTypeDelegate2(){
        Map<String, String> kvs = new HashMap<>();
        populateKVPairs(kvs);
        setUpKVPairs(kvs);
    }

    private void setUpKVPairs(Map<String, String> kvs){
        for (Map.Entry<String, String> en: kvs.entrySet()){
            String key = en.getKey();
            String value = en.getValue();
            applierMap.put(key, new ApplierImpl<T>(value));
        }
    }

    //当 isAllBaseValid 处理之后，给定一个机会去解析可选的内容. 返回0 意味着不处理。
    //返回跳过的行数
    protected int skipLines(DocRuleParser.TypeContent tc, int curLineIdx, T bean){
        return 0;
    }

    @Override
    public final void parse(DocRuleParser.TypeContent tc, RuleItem container){
        T module = prepare(container);
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < tc.lines.size(); i++) {
            String s = tc.lines.get(i);
            if(isInvalidLine(s)){
                continue;
            }
            if(module.isAllBaseValid()){
                int skipCnt = skipLines(tc, i, module);
                if(skipCnt > 0){
                    i += skipCnt - 1;
                    continue;
                }
                subs.add(s);
            }else{
                KVPair kvPair = parseKV(s);
                if(kvPair != null){
                    if(!invokeByBean(module, kvPair)){
                        Applier<T> applier = applierMap.get(kvPair.key);
                        if(applier != null){
                            applier.applyKVPair(module, kvPair);
                        }
                    }
                }
            }
        }
        if(subs.isEmpty()){
            return;
        }
        List<DocRuleParser.TypeContent> newTcs = DocRuleParser.parse(subs);
        for (int i = 0; i < newTcs.size(); i++) {
            RuleItem ri = new RuleItem();
            DocRuleParser.TypeContent typeContent = newTcs.get(i);
            RuleTypeFactory.get().parseRule(typeContent, ri);
            addSubItem(module, ri);
        }
    }
    protected abstract void populateKVPairs(Map<String, String> kvs);

    protected abstract T prepare(RuleItem container);

    protected abstract void addSubItem(T module, RuleItem ri);

    private boolean invokeByBean(T bean, KVPair p){
        Class<?> cls = bean.getClass();
        Class<?>[] clss = cls.getInterfaces();
        Method targetM = null;
        for (Class<?> cls1: clss) {
            if(cls1 == Applier.class){
                Method[] methods = cls1.getDeclaredMethods();
                for (int i = 0; i < methods.length; i++) {
                    if(methods[i].getName().equals("applyKVPair")){
                        targetM = methods[i];
                        break;
                    }
                }
                if(targetM != null){
                    break;
                }
            }
        }
        if(targetM != null){
            targetM.setAccessible(true);
            try {
                targetM.invoke(bean, bean, p);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    private static class ApplierImpl<T> implements Applier<T>{

        private final String fieldName;

        public ApplierImpl(String fieldName) {
            this.fieldName = fieldName;
        }
        @Override
        public void applyKVPair(T bean, KVPair p) {
            Class<?> cls = bean.getClass();
            try {
                Field field = cls.getField(fieldName);
                field.setAccessible(true);
                if(field.getType() == String.class){
                    field.set(bean, p.value);
                }else if(field.getType() == int.class){
                    field.set(bean, Integer.parseInt(p.value));
                }else{
                    throw new IllegalStateException(p.toString());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
