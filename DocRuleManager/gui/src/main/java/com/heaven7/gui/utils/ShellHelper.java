package com.heaven7.gui.utils;

import com.heaven7.java.base.util.Platforms;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ShellHelper {

    private String[] envs;//a=b
    private File workDir;

    public void setEnvs(String[] envs) {
        this.envs = envs;
    }

    public void setWorkDir(File workDir) {
        this.workDir = workDir;
    }

    public static String runShell(String... strs){
        List<String> list = new ShellHelper().runShell2(strs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(Platforms.getNewLine());
        }
        return sb.toString();
    }

    public List<String> runShell2(String... strs){
//        String[] args = new String[strs.length + 2];
//        args[0] = "/bin/sh";
//        args[1] = "-c";
        String[] args = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            //args[i + 2] = strs[i];
            args[i] = strs[i];
        }
       // System.out.println("start run: " + Arrays.toString(args));
        Process process;
        int code = 0;
        List<String> rets = Collections.synchronizedList(new ArrayList<>());
        try{
            //if windows:  Runtime.getRuntime().exec(new String[]{"**cmd** exe","-c","command"});
            // process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", shStr});
            process = Runtime.getRuntime().exec(args, envs, workDir);
            // 必须读取 stdout 和 stderr
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        rets.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getErrorStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        rets.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            code = process.waitFor();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        System.out.println("runShell: code = " + code);
        if(code != 0){
            System.err.println("run failed: " + Arrays.toString(args));
        }
        return rets;
    }

    public static String concatCmds(String[] cmds){
        StringBuilder sb_cmd = new StringBuilder();
        for (int i = 0; i < cmds.length; i++) {
            sb_cmd.append(cmds[i]);
            if( i != cmds.length - 1){
                sb_cmd.append(" && ");
            }
        }
        return sb_cmd.toString();
    }

    public static void main(String[] args) {
        String ret;
        ret = runShell("bash doc/q_gene.sh -s hgnc_gene_symbol BMPR2"
              //  , "-s", "hgnc_gene_symbol", "BMPR2" //wrong
        );
        System.out.println("ret ---> ");
        System.out.println(ret);
    }
}