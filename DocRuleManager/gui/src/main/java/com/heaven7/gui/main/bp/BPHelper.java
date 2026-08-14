package com.heaven7.gui.main.bp;

import com.heaven7.gui.utils.FileUtils2;
import com.heaven7.gui.utils.ShellHelper;
import com.heaven7.gui.utils.SymLinkCreator;
import com.heaven7.java.base.util.FileUtils;
import com.heaven7.java.base.util.Platforms;
import com.heaven7.java.base.util.Predicates;
import com.heaven7.java.base.util.Throwables;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**lessionFrames
 你平时分析崩溃堆栈用 minidump_stackwalk；
 想深入看原始数据用 minidump_dump；
 想转成 GDB 调试用 minidump-2-core；
 自动上报用 minidump_upload。
 note: 编译和运行app时，依赖库的版本和运行时要一样，如果编译选项不一样(比如opencv), 那么得到的堆栈可能是错的。
 */
public final class BPHelper {

    public static final String NEW_LINE = Platforms.getNewLine();
    private List<String> paths = new ArrayList<>(); //include dynamic lib and entry exe.(compiled with -g)
    private String dumpExe = "/usr/local/bin/dump_syms";
    private String stackwalkExe = "/usr/local/bin/minidump_stackwalk";
    private String workDir = "/tmp/bp_dump";
    private String stripExe = "/usr/bin/strip";

    public void toStr(StringBuilder sb){
        sb.append("paths:").append(NEW_LINE);
        for(String p : paths){
            sb.append(p).append(NEW_LINE);
        }
        sb.append(NEW_LINE);
        sb.append("dumpExe: ").append(dumpExe).append(NEW_LINE);
        sb.append("walkExe: ").append(stackwalkExe).append(NEW_LINE);
        sb.append("stripExe: ").append(stripExe).append(NEW_LINE);
        sb.append("workDir: ").append(workDir).append(NEW_LINE);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStr(sb);
        return sb.toString();
    }

    public List<String> getPaths() {
        return paths;
    }
    public void clearPath(){
        paths.clear();
    }
    public void addPath(String path){
        paths.add(path);
    }
    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
    public void setDumpExe(String dumpExe) {
        this.dumpExe = dumpExe;
    }
    public void setStackwalkExe(String stackwalkExe) {
        this.stackwalkExe = stackwalkExe;
    }
    public void setWorkDir(String workDir) {
        this.workDir = workDir;
    }
    public void setExeByBinDir(String dir){
        dumpExe = dir + "/dump_syms";
        stackwalkExe = dir + "/minidump_stackwalk";
    }
    public void check(){
        check(true);
    }
    public void check(boolean checkPaths){
        Throwables.checkArgument(FileUtils2.isExe(dumpExe), "dump_syms must be ok.");
        Throwables.checkArgument(FileUtils2.isExe(stackwalkExe), "minidump_stackwalk must be ok.");
        Throwables.checkArgument(new File(workDir).isDirectory(), "workDir must be ok.");
        if(checkPaths){
            Throwables.checkArgument(paths != null && !paths.isEmpty(), "paths must be ok.");
        }
    }

    //dump_syms ./test > test.sym
    public boolean generateSymbols(){
        //String txt = "MODULE Linux x86_64 089E6F06E59E7FA85479C873709076100 unittest\n";
        String symbolDir = workDir + "/symbols";
        new File(symbolDir).mkdirs();
        //
        for (String path : paths){
            if(new File(path).isFile()){
                if (!genSymbolImpl(symbolDir, path)) {
                    return false;
                }
            }else if(new File(path).isDirectory()){
                //xxx.so
                List<String> files = FileUtils.getFiles(new File(path), "so");
                for(String f1 : files){
                    if(!genSymbolImpl(symbolDir, f1)){
                        return false;
                    }
                }
                //xxx.so.1
                files = FileUtils.getFiles(new File(path), new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        return file.isFile() && file.getAbsolutePath().contains(".so.");
                    }
                });
                for(String f1 : files){
                    if(!genSymbolImpl(symbolDir, f1)){
                        return false;
                    }
                }
                //exe
                files = FileUtils.getFiles(new File(path), new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        return file.isFile() && FileUtils2.isExe(file.getAbsolutePath());
                    }
                });
                for(String f1 : files){
                    if(!genSymbolImpl(symbolDir, f1)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean strip(){
        //strip --strip-unneeded -o 输出文件名 输入文件名
        //正在运行的程序不要用strip
        String stripDir = workDir + "/strip";
        new File(stripDir).mkdirs();
        //
        List<String> softLinkFiles = new ArrayList<>();
        for (String path: paths) {
            if (new File(path).isFile()) {
                if(FileUtils2.isSoftLink(path)){
                    softLinkFiles.add(path);
                }else{
                    strip0(stripDir, path);
                }
            }else{
                List<String> files = FileUtils.getFiles(new File(path), new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        boolean isSo1 = file.getAbsolutePath().endsWith(".so");
                        boolean isSo2 = file.getAbsolutePath().contains(".so.");
                        boolean isExe = FileUtils2.isExe(file.getAbsolutePath());
                        return file.isFile() && !FileUtils2.isSoftLink(file.getAbsolutePath())
                                && (isSo1 || isSo2 || isExe);
                    }
                });
                for(String f1 : files){
                    if(!strip0(stripDir, f1)){
                        return false;
                    }
                }
                files = FileUtils.getFiles(new File(path), new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        return file.isFile() && FileUtils2.isSoftLink(file.getAbsolutePath());
                    }
                });
                //
                if(Platforms.isLinux()){
                    for(String f1 : files){
                        String path1 = FileUtils2.getSoftLinkActualPath(f1);
                        Throwables.checkNull(path1);
                        //path1 may be absolute path
                        if(path1.startsWith("/")){
                            if(!strip0(stripDir, f1)){
                                return false;
                            }
                        }else{
                            softLinkFiles.add(f1);
                        }
                    }
                }else{
                    throw new RuntimeException("current only support linux");
                }
            }
        }
        //sort by filename-length, DESC
        softLinkFiles.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        });
        //ln -s src dst
        for (String f1 : softLinkFiles){
            String path1 = FileUtils2.getSoftLinkActualPath(f1);
            Throwables.checkNull(path1);
            //ln -s src dst
            String actPath = FileUtils2.processSoftLink(f1, path1);
            String srcActP = getStripDstF(stripDir, actPath);
            String dstP = getStripDstF(stripDir, f1);
            SymLinkCreator.createRelativeSymLink(srcActP, dstP);
        }
        return true;
    }
    public String dumpStack(String crashDmp){
        Throwables.checkArgument(new File(crashDmp).isFile(), "");
        String symbolDir = workDir + "/symbols";
        return ShellHelper.runShell(stackwalkExe, crashDmp, symbolDir);
    }

    public void dumpStackToStdout(String crashDmp){
        String str = dumpStack(crashDmp);
        System.out.println(str);
    }

    private boolean strip0(String stripDir, String path){
        String dstF = getStripDstF(stripDir, path);
        //
        String s = ShellHelper.runShell(stripExe, "--strip-unneeded", "-o", dstF, path);
        if(!Predicates.isEmpty(s)){
            System.out.println(s);
        }
        return true;
    }
    private static String getStripDstF(String stripDir,String path){
        String dn1 = FileUtils.getFileDir(path, 1, false);
        String dn0 = FileUtils.getFileDir(path, 1, true);
        String dn2 = FileUtils.getFileDir(dn0, 1, false);
        String dstDir = stripDir + "/" + dn2 + "/" + dn1;
        String dstF = dstDir + "/" + getFN(path);
        new File(dstDir).mkdirs();
        return dstF;
    }

    private boolean genSymbolImpl(String symbolDir, String path) {
        String fn = getFN(path);
        String dstF = workDir + "/" + fn + ".sym";
        String dst_content = ShellHelper.runShell(dumpExe, path);
        FileUtils.writeTo(dstF, dst_content);
        if(new File(dstF).exists()){
            //write file and read right-now may have problem.
            String res = dst_content.split("\\n")[0];
            String[] strs = res.split(" ");
            if(strs.length == 1){
                System.err.println("head -n1 failed. " + dstF);
                return false;
            }
            String id = strs[strs.length-2];
            //String name = strs[strs.length-1];
            //Throwables.checkArgument(name.equals(fn), "");
            String act_sym_dir = symbolDir + "/" + fn + "/" + id;
            new File(act_sym_dir).mkdirs();
            String res0 = ShellHelper.runShell("mv", dstF, act_sym_dir);
            if(!Predicates.isEmpty(res0)){
                System.out.println(res0);
            }
        }else{
            return false;
        }
        return true;
    }
    private static String getFN(String path){
        String fn = "";
        if(path.contains(".")){
            fn = FileUtils.getSimpleFileName(path);
        }else{
            int index = path.lastIndexOf("/");
            if (index == -1) {
                index = path.lastIndexOf("\\");
                fn = path.substring(index + 2);
            }else{
                fn = path.substring(index + 1);
            }
        }
        return fn;
    }
}
