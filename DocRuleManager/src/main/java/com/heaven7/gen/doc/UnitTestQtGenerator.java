package com.heaven7.gen.doc;

import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.gen.doc.bean.UnitTestItem;
import com.heaven7.gen.doc.bean.UnitTestQtItem;
import com.heaven7.gen.doc.utils.QtTestCppGenerator;
import com.heaven7.gen.doc.utils.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UnitTestQtGenerator implements IDocRuleGenerator{

    public void gen(DocRule rule, String savePath){
        File file = new File(savePath);
        file.mkdirs();
        if(!file.isDirectory()){
            throw new RuntimeException("UnitTestQtGenerator >> must be dir");
        }
        List<UnitTestQtItem> list = new ArrayList<>();
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
                            ArrayList<String> mns = new ArrayList<>();
                            List<UnitTestItem> kitems = new ArrayList<>();
                            for (DocRule.MethodInfo fi : ci.methods) {
                                mns.add(fi.name);
                                //
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
                                kitems.add(kitem);
                            }
                            UnitTestQtItem kitem = new UnitTestQtItem();
                            kitem.setClassName(ci.classDefine.className);
                            kitem.setMethodNames(mns);
                            kitem.setKitems(kitems);
                            list.add(kitem);
                        }
                    }
                }
            }
        }
        QtTestCppGenerator cppGenerator = new QtTestCppGenerator();
        for (int i = 0; i < list.size(); i++) {
            UnitTestQtItem item = list.get(i);
            String outDir = savePath + "/" + item.getClassName() + "_Test";
            new File(outDir).mkdirs();
            cppGenerator.generateAll(item, outDir);
        }
    }
}
