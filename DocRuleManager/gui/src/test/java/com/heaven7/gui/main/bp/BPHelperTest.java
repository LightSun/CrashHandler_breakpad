package com.heaven7.gui.main.bp;

import org.junit.jupiter.api.Test;

public class BPHelperTest {

    @Test
    public void test_gen(){
        BPHelper helper = new BPHelper();
        helper.setWorkDir("/media/heaven7/h71/study/github/google/breakpad/work_dir");
        helper.addPath("/media/heaven7/h71/study/github/google/breakpad/tmp/release");
        //
        helper.check();
       // helper.generateSymbols();
    }

    @Test
    public void test_dump(){
        BPHelper helper = new BPHelper();
        helper.setWorkDir("/media/heaven7/h71/study/github/google/breakpad/work_dir");
        helper.addPath("/media/heaven7/h71/study/github/google/breakpad/tmp/release");
        //
        String crash_dmp = "/media/heaven7/h71/study/github/google/breakpad/tmp/release/cf6b4456-ac46-47f0-2808da98-61a5d426.dmp";
        helper.check();
        helper.dumpStackToStdout(crash_dmp);
    }

    @Test
    public void test_strip(){
        BPHelper helper = new BPHelper();
        helper.setWorkDir("/media/heaven7/h71/study/github/google/breakpad/work_dir");
        helper.addPath("/media/heaven7/h71/study/github/google/breakpad/tmp/release");
        helper.check();
        helper.strip();
    }

    @Test
    public void test_dump_af_strip(){
        BPHelper helper = new BPHelper();
        helper.setWorkDir("/media/heaven7/h71/study/github/google/breakpad/work_dir");
        helper.addPath("/media/heaven7/h71/study/github/google/breakpad/work_dir/strip/release");
        //
        String crash_dmp = "/media/heaven7/h71/study/github/google/breakpad/tmp/release/cf6b4456-ac46-47f0-2808da98-61a5d426.dmp";
        helper.check();
        helper.dumpStackToStdout(crash_dmp);
    }
}
