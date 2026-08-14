package com.heaven7.gui.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class SymLinkCreator {

    /**
     * 创建相对路径的符号链接 from target to link
     *
     * @param targetPath 目标文件（真实文件）的路径，可以是绝对或相对，但建议传绝对路径
     * @param linkPath   要创建的链接文件的路径
     */
    public static void createRelativeSymLink(String targetPath, String linkPath){
        Path dst = Paths.get(targetPath);
        Path link = Paths.get(linkPath);
        try {
            createRelativeSymLink(dst, link);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 创建相对路径的符号链接 from target to link
     *
     * @param targetPath 目标文件（真实文件）的路径，可以是绝对或相对，但建议传绝对路径
     * @param linkPath   要创建的链接文件的路径
     * @throws IOException 如果创建失败或文件已存在且无法覆盖
     */
    public static void createRelativeSymLink(Path targetPath, Path linkPath) throws IOException {
        // 1. 确保链接文件的父目录存在
        Path parent = linkPath.getParent();
        if (parent != null && !Files.exists(parent)) {
            Files.createDirectories(parent);
        }

        // 2. 如果链接文件已存在，先删除（或可改为备份，此处演示覆盖行为）
        if (Files.exists(linkPath)) {
            Files.delete(linkPath);
        }

        // 3. 计算从链接文件所在目录到目标文件的相对路径
        //    注意：relativize 方法要求两个路径都在同一文件系统（根目录相同），否则会抛异常
        Path linkParent = linkPath.getParent(); // 链接文件的父目录
        Path relativeTarget = linkParent.relativize(targetPath); // 相对路径

        // 4. 创建符号链接（使用相对路径）
        Files.createSymbolicLink(linkPath, relativeTarget);
    }

    public static void main(String[] args) {
        try {
            Path target = Paths.get("/media/heaven7/h71/study/github/google/breakpad/work_dir/strip/release/unittest");
            Path link   = Paths.get("/media/heaven7/h71/study/github/google/breakpad/work_dir/strip/t1/unittest");

            createRelativeSymLink(target, link);

            System.out.println("软链接创建成功！");
            System.out.println("链接内容指向: " + Files.readSymbolicLink(link));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}