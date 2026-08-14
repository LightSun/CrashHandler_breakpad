package com.heaven7.gen.doc;

import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.java.base.util.Throwables;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DocGeneratorTest {

    @Test
    public void testGenFromRule(){
        DocRuleExecutor executor = new DocRuleExecutor();
        executor.execute("rule/test.rule");
    }

    @Test
    public void testWholeRule(){
        DocRuleExecutor executor = new DocRuleExecutor();
        executor.executeWholeConfigFile("rule/EncDec.rule");
    }

    @Test
    public void testWholeRule2(){
        DocRuleExecutor executor = new DocRuleExecutor();
        executor.executeWholeConfigFile("rule/ruxian_cj.rule");
    }

    @Test
    public void testGenDoc1(){
        DocRule rule = new DocRule();
        rule.title = "乳腺肿块超声影像辅助诊断软件";
        rule.modules = new ArrayList<>();
        rule.modules.add(newModule());
        rule.saveFile = "test_docx/2.docx";
        //
        DocGenerator gen = new DocGenerator();
        gen.gen(rule, "test_docx/2.docx");
    }

    private DocRule.Module newModule(){
        DocRule.Module mod = new DocRule.Module();
        mod.name = "系统登录模块";
        mod.index = 1;
        mod.classItems = new ArrayList<>();
        mod.classItems.add(newClassItem());
        mod.classItems.add(newClassItem());
        return mod;
    }
    private DocRule.ClassItem newClassItem(){
        DocRule.ClassItem ci = new DocRule.ClassItem();
        ci.desc = "事件循环处理";
        ci.funcContent = "完成配置文件的验证和主窗口创建等初始化工作";
        ci.classDefine = new DocRule.ClassDefine();
        ci.classDefine.className = "PreMain";
        ci.classDefine.superClassName = "QObject";
        //
        ci.fields = new ArrayList<>();
        ci.methods = new ArrayList<>();
        //
        ci.fields.add(newFiledInfo("pMainFrame", "MainFrame *", "主窗口框架 "));
        ci.fields.add(newFiledInfo("pMainFrame2", "MainFrame *", "主窗口框架 "));
        //
        ci.methods.add(newMethodInfo(Arrays.asList("init", "void", "bool", "初始化配置文件以及数据库信息等等")));
        ci.methods.add(newMethodInfo(Arrays.asList("init2", "void", "bool", "初始化配置文件以及数据库信息等等")));
        return ci;
    }
    private DocRule.MethodInfo newMethodInfo(List<String> cs){
        Throwables.checkArgument(cs.size() == 4, "");
        DocRule.MethodInfo info = new DocRule.MethodInfo();
        info.name = cs.get(0);
        info.paramsStr = cs.get(1);
        info.returnStr = cs.get(2);
        info.desc = cs.get(3);
        return info;
    }
    private DocRule.FieldInfo newFiledInfo(String name, String type, String desc){
        DocRule.FieldInfo info = new DocRule.FieldInfo();
        info.name = name;
        info.type = type;
        info.desc = desc;
        return info;
    }
}
