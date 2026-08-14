package com.heaven7.gen.doc;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.heaven7.gen.doc.utils.StringUtils.rep_content;

public class StringUtilsTest {

    @Test
    public void testRep(){
        String line = "/xxx/${a}bcd/${b}/c";
        Map<String, String> env = new HashMap<>();
        env.put("a", "123");
        env.put("b", "456");
        String s = rep_content(env, line);
        System.out.println(s);
    }
}
