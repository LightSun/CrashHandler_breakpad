package com.heaven7.gen.doc.bean;


import com.heaven7.gen.doc.utils.StringUtils;
import com.heaven7.java.base.util.FileUtils;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

public class FilesRule implements IParserBean{

    public final List<String> files = new ArrayList<>();
    public final Map<String, Integer> modelIndexMap = new HashMap<>();

    @Override
    public boolean isAllBaseValid() {
        return false;
    }

    public void resolveEnv(EnvRule env){
        for (int i = 0; i < files.size(); i++) {
            String s = files.get(i);
            String newS = StringUtils.rep_content(env.env, s);
            files.set(i, newS);
        }
        resolveDir(env);
    }
    public Integer getModelIndex(String file){
        Set<String> keySet = modelIndexMap.keySet();
        for (String s: keySet) {
            if(file.startsWith(s)){
                return modelIndexMap.get(s);
            }
        }
        return null;
    }
    private void resolveDir(EnvRule env){
        Set<String> keySet = new HashSet<>(modelIndexMap.keySet());
        for (String s: keySet) {
            Integer val = modelIndexMap.get(s);
            String newS = StringUtils.rep_content(env.env, s);
            modelIndexMap.put(newS, val);
        }
        for (String s: keySet) {
            modelIndexMap.remove(s);
        }
        keySet = modelIndexMap.keySet();
        for (String s: keySet) {
            if(new File(s).isDirectory()){
                List<String> tfiles = new ArrayList<>();
                FileUtils.getFiles(new File(s), new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        String p = file.getAbsolutePath();
                        return p.endsWith(".rule") && !p.contains(".bak.");
                    }
                }, tfiles);
                files.addAll(tfiles);
            }else{
                System.err.println("not dir: " + s);
            }
        }
    }
}
