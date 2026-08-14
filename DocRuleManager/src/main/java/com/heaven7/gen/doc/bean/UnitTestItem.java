package com.heaven7.gen.doc.bean;

import java.util.ArrayList;
import java.util.List;

public class UnitTestItem {
    public String caseId = "";
    public String className;
    public String methodSign;
    public String methodDesc;
    public List<String> presetCase;
    public List<String> steps; // \n 隔离 1，2，3...
    public List<String> expectResults;
    public List<String> testResults;

    public void addPresetStepExpect(String pre, String step, String expect) {
        if(presetCase == null){
            presetCase = new ArrayList<>();
        }
        if(steps == null){
            steps = new ArrayList<>();
        }
        if(expectResults == null){
            expectResults = new ArrayList<>();
        }
        if(testResults == null){
            testResults = new ArrayList<>();
        }
        presetCase.add(pre);
        steps.add(step);
        expectResults.add(expect);
        testResults.add("PASS");
    }

    public List<ExcelUnitItem> toExcelItems(){
        ArrayList<ExcelUnitItem> list = new ArrayList<>();
        if(presetCase != null){
            for (int i = 0; i < presetCase.size(); i++) {
                ExcelUnitItem item = new ExcelUnitItem();
                item.setCaseId(ExcelUnitItem.newCellData(caseId));
                item.setClassName(ExcelUnitItem.newCellData(className));
                item.setMethodSign(ExcelUnitItem.newCellData(methodSign));
                item.setMethodDesc(ExcelUnitItem.newCellData(methodDesc));
                item.setPresetCase(ExcelUnitItem.newCellData(presetCase.get(i)));
                item.setSteps(ExcelUnitItem.newCellData(steps.get(i)));
                item.setExpectResult(ExcelUnitItem.newCellData(expectResults.get(i)));
                item.setTestResult(ExcelUnitItem.newCellData(testResults.get(i)));
                list.add(item);
            }
        }
        return list;
    }
    public int getMethodCount(){
        return presetCase != null ? presetCase.size() : 0;
    }
}