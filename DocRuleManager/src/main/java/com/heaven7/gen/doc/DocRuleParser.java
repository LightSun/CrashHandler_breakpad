package com.heaven7.gen.doc;

import com.heaven7.java.base.util.IOUtils;
import com.heaven7.java.base.util.Throwables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DocRuleParser {

    public enum Type{
        NONE, AnnoNode, DocRule, Module, ClassItem, ClassDefine, Field, Method,
        WholeConfig, Env, Files
    }
    public static class TypeContent{
        public final Type type;
        public final List<String> lines;

        public TypeContent(Type type, List<String> all){
            this.type = type;
            this.lines = all;
        }

        public TypeContent(Type type, List<String> all, int start, int end){
            this.type = type;
            this.lines = all.subList(start, end);
        }
        public static Type str2type(String str){
            HashMap<String, Type> map = new HashMap<>();
            map.put("DocRule", Type.DocRule);
            map.put("Module", Type.Module);
            map.put("ClassItem", Type.ClassItem);
            map.put("ClassDefine", Type.ClassDefine);
            map.put("Field", Type.Field);
            map.put("Method", Type.Method);
            map.put("WholeRule", Type.WholeConfig);
            map.put("Env", Type.Env);
            map.put("Files", Type.Files);
            Type kt = map.get(str);
            if(kt != null){
                return kt;
            }
            if(str.startsWith("/**/")){
                kt = map.get(str.substring(4));
                if(kt != null){
                    return Type.AnnoNode;
                }
            }
            throw new RuntimeException("wrong node = " + str);
        }
    }

    public static List<TypeContent> parseFile(String file){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            List<String> list = IOUtils.readStringLines(reader);
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i).trim();
                if(s.startsWith("\t")){
                    do{
                        s = s.substring(1);
                    }while (s.startsWith("\t"));
                }
                if(s.endsWith("\t")){
                    do{
                        s = s.substring(0, s.length() - 1);
                    }while (s.endsWith("\t"));
                }
                list.set(i, s);
            }
            return parse(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            IOUtils.closeQuietly(reader);
        }
    }

    public static List<TypeContent> parse(List<String> lines){
        List<TypeContent> typeCss = new ArrayList<>();
        Type startType = Type.NONE;
        int startI = -1;
        int startCnt = 0;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if(line.isEmpty() || line.startsWith("#")){
                continue;
            }
            if(line.startsWith("::")){
                continue;
            }
            int idx = line.indexOf("{");
            if(idx > 0 && idx == line.length() - 1){
                if(startType == Type.NONE){
                    String str = line.substring(0, idx);
                    startType = TypeContent.str2type(str);
                    startI = i;
                }
                startCnt ++;
            }
            if(line.equals("}")){
                startCnt --;
                if(startCnt == 0){
                    if(i == startI + 1){
                        startType = Type.NONE;
                        //may have multi, we must do next parse
                        continue;
                    }
                    Throwables.checkArgument(i > startI + 1, "");
                    typeCss.add(new TypeContent(startType, lines, startI + 1, i));
                    startType = Type.NONE;
                }
            }
        }
        Throwables.checkArgument(startType == Type.NONE, "rule file content error. un-closed '{'");
        for(int i = typeCss.size() - 1 ; i >= 0 ; --i){
            TypeContent tc = typeCss.get(i);
            if(tc.type == Type.AnnoNode){
                typeCss.remove(i);
            }
        }
        return typeCss;
    }

}
