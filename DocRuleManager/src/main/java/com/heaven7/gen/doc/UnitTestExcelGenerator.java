package com.heaven7.gen.doc;

import com.alibaba.excel.EasyExcel;
import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.gen.doc.bean.ExcelUnitItem;
import com.heaven7.gen.doc.bean.UnitTestItem;
import com.heaven7.gen.doc.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

//detail of design
//用例编号, 软件项（类名), 软件单元(函数完整签名), 用例描述(函数说明), 预置条件(单元测试的先验条件), 操作步骤, 预期结果(返回值), 测试结果
//其中: 操作步骤 -> 1、编写用例函数
//                2、调用测试函数
public class UnitTestExcelGenerator implements IDocRuleGenerator{

    public void gen(DocRule rule, String savePath){
        List<UnitTestItem> list = new ArrayList<>();
        if(rule.modules != null){
            for (int i = 0; i < rule.modules.size(); i++) {
                DocRule.Module module = rule.modules.get(i);
                if(module.classItems != null){
                    for (int k = 0; k < module.classItems.size(); k++) {
                        DocRule.ClassItem ci = module.classItems.get(k);
                        if(ci.classDefine == null){
                            throw new IllegalStateException("");
                        }
                        if(ci.methods != null){
                            for (DocRule.MethodInfo fi : ci.methods) {
                                String methodSign = fi.returnStr + " " + fi.name + "(" + fi.paramsStr + ");";
                                UnitTestItem kitem = new UnitTestItem();
                                kitem.className = ci.classDefine.className;
                                kitem.methodSign = methodSign;
                                kitem.methodDesc = fi.desc;
                                try {
                                    StringUtils.parsePreset(kitem, fi.preset);
                                }catch (Exception e){
                                    System.err.println("className = " + kitem.className + " ,methodSign = " + methodSign);
                                    throw e;
                                }
                                //contents.add(Arrays.asList(fi.name, fi.paramsStr, fi.returnStr, fi.desc));
                                list.add(kitem);
                            }
                        }
                    }
                }
            }
        }
        List<ExcelUnitItem> allItems = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            UnitTestItem item = list.get(i);
            allItems.addAll(item.toExcelItems());
        }
        EasyExcel.write(savePath, ExcelUnitItem.class).sheet("UT单元测试").doWrite(allItems);
//        Gson gson = new Gson();
//        LineWriter writer = new LineWriter(savePath);
//        for (int i = 0; i < list.size(); i++) {
//            UnitTestItem item = list.get(i);
//            String s = gson.toJson(item);
//            writer.writeLine(s);
//        }
//        writer.flush();
//        writer.close();

    }
}
