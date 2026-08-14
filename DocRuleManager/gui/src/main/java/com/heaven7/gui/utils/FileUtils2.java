package com.heaven7.gui.utils;

import com.heaven7.java.base.util.FileUtils;
import com.heaven7.java.base.util.IOUtils;
import com.heaven7.java.base.util.Platforms;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.heaven7.java.base.util.IOUtils.closeQuietly;

public final class FileUtils2 {

    public static byte[] getFileBytes(String file){
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            return IOUtils.readBytes(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            closeQuietly(in);
        }
    }
    public static String readFileAsString(String path) {
        byte[] bytes = getFileBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static String getLastPath(String path){
        int idx = path.lastIndexOf("/");
        if(idx < 0){
            idx = path.lastIndexOf("\\");
        }
        return path.substring(idx + 1);
    }
    public static String getSoftLinkActualPath(String p){
        Path path = Paths.get(p);
        if (Files.isSymbolicLink(path)) {
            //System.out.println(path + " 是一个符号链接");
            try {
                Path src = path;
                while(true) {
                    Path target = Files.readSymbolicLink(src);
                    if(Files.isSymbolicLink(target)){
                        src = target;
                    }else{
                        //this will return the current work dir + relative soft path
                        //return target.toFile().getAbsolutePath();
                        return target.toString();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            //System.out.println(path + " 不是符号链接");
            return null;
        }
    }
    public static boolean isSoftLink(String p){
        Path path = Paths.get(p);
        return Files.isSymbolicLink(path);
    }
    public static boolean isExe(String file){
        try {
            boolean executable = isProbablyExecutable(Paths.get(file));
            if(Platforms.isLinux()){
                return isELF0(new File(file)) && executable;
            }else{
                return executable;
            }
        } catch (IOException e) {
            return false;
        }
    }
    //可执行程序判断
    private static boolean isELF0(File file) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            if (raf.length() < 4) return false;
            byte[] magic = new byte[4];
            raf.readFully(magic);
            return magic[0] == 0x7F && magic[1] == 0x45 && magic[2] == 0x4C && magic[3] == 0x46;
        }
    }
    public static boolean isProbablyExecutable(Path path) {
        String name = path.getFileName().toString();
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (os.contains("win")) {
            // Windows 常见可执行扩展名
            return name.endsWith(".exe") || name.endsWith(".bat") ||
                    name.endsWith(".cmd") || name.endsWith(".com");
        } else {
            // Unix: 检查文件是否具有执行权限且内容可能是 ELF 脚本等（可选）
            return Files.isExecutable(path) && !Files.isDirectory(path);
        }
    }
///media/heaven7/h71/study/github/google/breakpad/tmp/release/t1/unittest
//../unittest
    //only for linux-style
    public static String processSoftLink(String p1, String link){
        String dir = FileUtils.getFileDir(p1, 1, true);
        String dstP = dir + "/" + link;
        List<String> strs = new ArrayList<>(Arrays.asList(dstP.split("/")));
        while (true){
            int dotIdx = -1;
            for (int i = 0; i < strs.size(); i++) {
                String s = strs.get(i);
                if(s.equals("..")){
                    dotIdx = i;
                    break;
                }
            }
            if(dotIdx == -1){
                break;
            }
            strs.remove(dotIdx - 1);
            strs.remove(dotIdx - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i));
            if(i != strs.size() - 1){
                sb.append("/");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String f1 = "/media/heaven7/h71/study/github/google/breakpad/tmp/release/t1/unittest";
        System.out.println(new File(f1).isFile());
        String path = getSoftLinkActualPath(f1);
        System.out.println(path);
        String newP = processSoftLink(f1, path);
        System.out.println(newP);
    }
}
