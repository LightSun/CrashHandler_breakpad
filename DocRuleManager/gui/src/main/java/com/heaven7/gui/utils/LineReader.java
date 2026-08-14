package com.heaven7.gui.utils;

import com.heaven7.java.base.util.IOUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class LineReader {

    private final BufferedReader mReader;

    public LineReader(String file) {
        try {
            this.mReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public LineReader(Reader reader) {
        this.mReader = reader instanceof BufferedReader ? (BufferedReader)(reader): new BufferedReader(reader);
    }

    public void readLines(Callback callback){
        String line;
        try {
            while ((line = mReader.readLine()) != null){
                callback.onGotLine(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            IOUtils.closeQuietly(mReader);
        }
    }

    public List<String> readLines(){
        List<String> list = new ArrayList<>();
        String line;
        try {
            while ((line = mReader.readLine()) != null){
                list.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            IOUtils.closeQuietly(mReader);
        }
        return list;
    }

    public void close(){
        IOUtils.closeQuietly(mReader);
    }

    public interface Callback {
        void onGotLine(String line);
    }
}
