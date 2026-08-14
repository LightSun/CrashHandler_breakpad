package com.heaven7.gen.doc.bean;

import com.heaven7.gen.doc.utils.StringUtils;

import java.util.Map;

public class WholeConfigRule implements IParserBean{

    public String title;
    public String saveFile;
    public EnvRule envRule;
    public FilesRule filesRule;

    @Override
    public boolean isAllBaseValid() {
        return title != null && saveFile != null;
    }

    public void resolveEnv(Map<String,String> kenv){
        if(envRule == null){
            envRule = new EnvRule();
        }
        envRule.resolveEnv(kenv);
        saveFile = StringUtils.rep_content(envRule.env, saveFile);
        title = StringUtils.rep_content(envRule.env, title);
        if(filesRule != null ){
            filesRule.resolveEnv(envRule);
        }
    }
}
