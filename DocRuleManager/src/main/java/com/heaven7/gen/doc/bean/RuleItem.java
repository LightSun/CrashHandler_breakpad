package com.heaven7.gen.doc.bean;

public class RuleItem {

    private DocRule docRule;
    private DocRule.Module module;
    private DocRule.ClassItem classItem;
    private DocRule.ClassDefine classDefine;
    private DocRule.FieldInfo fieldInfo;
    private DocRule.MethodInfo methodInfo;
    private WholeConfigRule wholeConfigRule;
    private EnvRule envRule;
    private FilesRule filesRule;

    public EnvRule getEnvRule() {
        return envRule;
    }
    public void setEnvRule(EnvRule envRule) {
        this.envRule = envRule;
    }

    public FilesRule getFilesRule() {
        return filesRule;
    }

    public void setFilesRule(FilesRule filesRule) {
        this.filesRule = filesRule;
    }

    public WholeConfigRule getWholeConfigRule() {
        return wholeConfigRule;
    }
    public void setWholeConfigRule(WholeConfigRule wholeConfigRule) {
        this.wholeConfigRule = wholeConfigRule;
    }

    public DocRule.ClassDefine getClassDefine() {
        return classDefine;
    }
    public void setClassDefine(DocRule.ClassDefine classDefine) {
        this.classDefine = classDefine;
    }

    public DocRule getDocRule() {
        return docRule;
    }
    public void setDocRule(DocRule docRule) {
        this.docRule = docRule;
    }

    public DocRule.Module getModule() {
        return module;
    }
    public void setModule(DocRule.Module module) {
        this.module = module;
    }

    public DocRule.ClassItem getClassItem() {
        return classItem;
    }
    public void setClassItem(DocRule.ClassItem classItem) {
        this.classItem = classItem;
    }

    public DocRule.FieldInfo getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(DocRule.FieldInfo fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    public DocRule.MethodInfo getMethodInfo() {
        return methodInfo;
    }

    public void setMethodInfo(DocRule.MethodInfo methodInfo) {
        this.methodInfo = methodInfo;
    }
}
