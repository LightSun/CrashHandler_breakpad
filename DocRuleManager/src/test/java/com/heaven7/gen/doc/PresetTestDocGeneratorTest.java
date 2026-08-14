package com.heaven7.gen.doc;

import org.junit.jupiter.api.Test;

public class PresetTestDocGeneratorTest {

    @Test
    public void genExcel(){
        String outFile = "docx/test.xlsx";
        DocRuleExecutor executor = new DocRuleExecutor(new UnitTestExcelGenerator());
        executor.executeWholeConfigFile("rule/EncDec.rule", outFile);
    }

    @Test
    public void genExcel2(){
        String outFile = "excel/ruxian_cj.xlsx";
        DocRuleExecutor executor = new DocRuleExecutor(new UnitTestExcelGenerator());
        executor.executeWholeConfigFile("rule/ruxian_cj.rule", outFile);
    }
}
