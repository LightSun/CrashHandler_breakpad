package com.heaven7.gui.main.bp;

import com.heaven7.gui.utils.ArgsParser;
import com.heaven7.java.base.util.Throwables;

import java.util.Arrays;

public final class BPMain {

    //--mode gen_symbol --workDir xxx --paths pathA,pathB,pathC
    //--mode strip --workDir xxx --paths pathA,pathB,pathC
    //--mode dump --workDir xxx --dump_file xxx.dmp
    //--mode UI
    public static void main(String[] args) {
        ArgsParser parser = new ArgsParser(args);
        new BPMain(parser).run();
    }

    private final ArgsParser parser;

    public BPMain(ArgsParser parser) {
        this.parser = parser;
    }
    void run(){
        String mode = parser.getValue("mode");
        switch (mode){
            case "UI":{
                BPGuiMain.main(new String[]{});
            }break;

            case "gen_symbol":{
                BPHelper helper = createBPHelper(true);
                System.out.println("gen_symbol: " + helper.generateSymbols());
            }break;

            case "strip":{
                BPHelper helper = createBPHelper(true);
                System.out.println("strip: " + helper.strip());
            }break;

            case "dump":{
                BPHelper helper = createBPHelper(false);
                String dump_file = parser.getValue("dump_file");
                Throwables.checkArgument(dump_file != null, "for dump, must define dump_file.");
                helper.dumpStackToStdout(dump_file);
            }break;

            default:
                throw new RuntimeException("wrong mode = " + mode);
        }
    }
    private BPHelper createBPHelper(boolean reqPaths){
        BPHelper helper = new BPHelper();
        String workDir = parser.getValue("workDir");
        String paths = parser.getValue("paths");
        if(reqPaths){
            Throwables.checkArgument(paths != null, "must define paths");
            String[] strs = paths.split(",");
            helper.setPaths(Arrays.asList(strs));
        }
        helper.setWorkDir(workDir);
        helper.check(reqPaths);
        return helper;
    }
}
