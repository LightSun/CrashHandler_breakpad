package com.heaven7.gui.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public final class ResourceUtil {
    /**
     * 从 classpath 读取文本文件内容（返回字符串）
     */
    public static String readTextResource(String resourcePath){
        try {
            return readTextResource0(resourcePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static String readTextResource0(String resourcePath) throws IOException {
        try (InputStream is = ResourceUtil.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new FileNotFoundException("Resource not found: " + resourcePath);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                return sb.toString();
            }
        }
    }

    /**
     * 从 classpath 加载 properties 文件
     */
    public static Properties loadProperties(String resourcePath){
        try {
            return loadProperties0(resourcePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Properties loadProperties0(String resourcePath) throws IOException {
        try (InputStream is = ResourceUtil.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new FileNotFoundException("Properties file not found: " + resourcePath);
            }
            Properties props = new Properties();
            props.load(is);
            return props;
        }
    }

    public static void main(String[] args) {
        String s = ResourceUtil.readTextResource("/ui_bp.txt");
        System.out.println(s);
    }
}