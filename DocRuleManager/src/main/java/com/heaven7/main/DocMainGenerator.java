package com.heaven7.main;

import com.heaven7.gen.doc.DocRuleExecutor;
import com.heaven7.gen.doc.UnitTestExcelGenerator;
import com.heaven7.gen.doc.utils.ArgsParser;
import com.heaven7.java.base.util.Throwables;

import java.io.File;
import java.util.Arrays;

public final class DocMainGenerator {

    public static void main(String[] args) {
        if(args.length == 0){
            String CUR = "/home/heaven7/heaven7/work/maide_src/IAS_Reg/Generator";
            String in_rule_file = CUR + "/EncDec.rule";
            String DIR = CUR + "/EncDec";
            String[] kargs = new String[] {
                    "--mode", "GenDesignWord",
                    "--in_rule_file", in_rule_file,
                    "--DIR", DIR,
                    "--CUR", CUR
            };
            main(kargs);
            return;
        }
        for (String s : args){
            System.out.println(s);
        }
        //mode . in - out
        ArgsParser parser = new ArgsParser(args);
        String mode = parser.getValue("mode");
        String in_rule = parser.getValue("in_rule_file");
        String out_file = parser.getValue("save_file");
        //
        ArgsParser envParser = parser.copy(Arrays.asList("mode", "in_rule_file", "save_file"));
        //
        if(out_file != null){
            File file = new File(out_file);
            if(file.getParentFile() != null){
                file.getParentFile().mkdirs();
            }
        }
        switch (mode){
            case "GenDesignWord":{
                Throwables.checkArgument(in_rule != null && !in_rule.isEmpty(), "'--in_rule_file xxx.rule' must config");
                DocRuleExecutor executor = new DocRuleExecutor();
                executor.setEnvs(envParser.getKmap());
                if(out_file != null && !out_file.isEmpty()){
                    executor.executeWholeConfigFile(in_rule, out_file);
                }else {
                    executor.executeWholeConfigFile(in_rule);
                }
            }break;

            case "GenUnitTestExcel":{
                Throwables.checkArgument(in_rule != null && !in_rule.isEmpty(), "'--in_rule_file xxx.rule' must config");
                Throwables.checkArgument(out_file != null && !out_file.isEmpty(), "'--save_file xxx.xlsx' must config");
                DocRuleExecutor executor = new DocRuleExecutor(new UnitTestExcelGenerator());
                executor.setEnvs(envParser.getKmap());
                executor.executeWholeConfigFile(in_rule, out_file);
            }break;

            default:
                System.err.println("wrong mode: " + mode);
        }
    }
}
