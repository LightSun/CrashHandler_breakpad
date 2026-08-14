package com.heaven7.gen.doc.utils;

import com.heaven7.java.base.util.IOUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class LineWriter {

    private final BufferedWriter mWriter;

    public LineWriter(BufferedWriter mWriter) {
        this.mWriter = mWriter;
    }
    public LineWriter(String file) {
        try {
            this.mWriter = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public LineWriter(File file) {
        try {
            this.mWriter = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLine(String line){
        try {
            mWriter.write(line);
            mWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLines(Collection<String> line){
        try {
            for (String str: line){
                mWriter.write(str);
                mWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLines(List<String> lines){
        try {
            for (int i = 0; i < lines.size(); i++) {
                mWriter.write(lines.get(i));
                mWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void newLine(){
        try {
            mWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void flush(){
        try {
            mWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(){
        IOUtils.closeQuietly(mWriter);
    }
}
