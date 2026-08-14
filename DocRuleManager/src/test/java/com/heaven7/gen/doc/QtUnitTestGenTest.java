package com.heaven7.gen.doc;

import org.junit.jupiter.api.Test;

public class QtUnitTestGenTest {

    @Test
    public void genUnitTestQt(){
        String outFile = "test_docx/test0";
        DocRuleExecutor executor = new DocRuleExecutor(new UnitTestQtGenerator());
        executor.executeWholeConfigFile("rule/EncDec.rule", outFile);
    }

    @Test
    public void genUnitTestQt2(){
        String outFile = "test_docx/ruxian_cj";
        DocRuleExecutor executor = new DocRuleExecutor(new UnitTestQtGenerator());
        executor.executeWholeConfigFile("rule/ruxian_cj.rule", outFile);
    }
}
