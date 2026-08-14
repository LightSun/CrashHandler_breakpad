package com.heaven7.gen.doc;

import com.heaven7.gen.doc.bean.DocRule;
import com.heaven7.java.base.util.Throwables;
import com.money.docx.DocxPainter;
import com.money.docx.factory.DocxFactory;
import com.money.docx.item.DocxCell;
import com.money.docx.item.DocxRow;
import com.money.docx.item.DocxTable;
import com.money.docx.item.DocxText;
import com.money.docx.style.DocxStyle;
import com.money.docx.style.DocxStyleEnum;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.money.docx.style.DocxStyleEnum.TABLE_WHOLE;
//detail of design
public class DocGenerator implements IDocRuleGenerator{

    public void gen(DocRule rule, String savePath){
        DocxPainter docxPainter = new DocxPainter();
        if(rule.title != null){
            docxPainter.addToc(DocxFactory.createParagraph(new DocxText(rule.title,
                    DocxStyleEnum.DEFAULT_TOC_TITLE.getDocxStyle())));
        }
        docxPainter.add(DocxFactory.newPage());
        DocxStyle tableStyle = TABLE_WHOLE.getDocxStyle();
        if(rule.modules != null){
            for (int i = 0; i < rule.modules.size(); i++) {
                DocRule.Module module = rule.modules.get(i);
                String mn = module.index + " " + module.name;
                docxPainter.add(DocxFactory.createHeading("Heading1", new DocxText(mn)));
                if(module.classItems != null){
                    for (int k = 0; k < module.classItems.size(); k++) {
                        DocRule.ClassItem ci = module.classItems.get(k);
                        String prefix = module.index + "." + (k + 1);
                        //
                        String mainStr = prefix + "  " + ci.desc;
                        docxPainter.add(DocxFactory.createParagraph(new DocxText(mainStr,
                                        DocxStyleEnum.CONTENT.getDocxStyle())));
                        //func
                        String funcTitle = prefix + ".1 功能";
                        docxPainter.add(DocxFactory.createParagraph(new DocxText(funcTitle,
                                DocxStyleEnum.CONTENT.getDocxStyle())));
                        docxPainter.add(DocxFactory.createParagraph(new DocxText(ci.funcContent,
                                DocxStyleEnum.CONTENT2.getDocxStyle())));
                        //class def
                        String classDefStr = prefix + ".2 类定义";
                        docxPainter.add(DocxFactory.createParagraph(new DocxText(classDefStr,
                                DocxStyleEnum.CONTENT.getDocxStyle())));
                        if(ci.classDefine != null){
                            List<List<String>> contents = new ArrayList<>();
                            contents.add(Arrays.asList(ci.classDefine.className, ci.classDefine.superClassName,
                                    ci.classDefine.extendMethod));
                            DocxTable table = newTable(Arrays.asList("类名", "基类", "继承方式"), contents);
                            docxPainter.add(DocxFactory.createTable(table, docxPainter.getWpk(), tableStyle));
                        }
                        //filed def
                        String fieldStr = prefix + ".3 成员列表";
                        docxPainter.add(DocxFactory.createParagraph(new DocxText(fieldStr,
                                DocxStyleEnum.CONTENT.getDocxStyle())));
                        if(ci.fields != null){
                            List<List<String>> contents = new ArrayList<>();
                            for (DocRule.FieldInfo fi : ci.fields) {
                                contents.add(Arrays.asList(fi.name, fi.type, fi.desc));
                            }
                            DocxTable table = newTable(Arrays.asList("名称", "类型", "说明"), contents);
                            docxPainter.add(DocxFactory.createTable(table, docxPainter.getWpk(), tableStyle));
                        }
                        //method
                        String methodStr = prefix + ".4 方法";
                        docxPainter.add(DocxFactory.createParagraph(new DocxText(methodStr,
                                DocxStyleEnum.CONTENT.getDocxStyle())));
                        if(ci.methods != null){
                            List<List<String>> contents = new ArrayList<>();
                            for (DocRule.MethodInfo fi : ci.methods) {
                                contents.add(Arrays.asList(fi.name, fi.paramsStr, fi.returnStr, fi.desc));
                            }
                            DocxTable table = newTable(Arrays.asList("名称", "参数", "返回值", "说明"), contents);
                            docxPainter.add(DocxFactory.createTable(table, docxPainter.getWpk(), tableStyle));
                        }
                    }
                }
            }
        }
        docxPainter.save(new File(savePath));
    }
    //contents: List<String> as row
    private static DocxTable newTable(List<String> titles, List<List<String>> contents){
        List<DocxCell> cells_head = new ArrayList<>();
        for (int i = 0 ; i < titles.size(); ++i){
            String s = titles.get(i);
            cells_head.add(new DocxCell(s, DocxStyle.builder()
                    .bold(true)
                    .cellColor("D6DAD5")
                    .cellWidth(1000L)
                    .build()));
        }
        DocxRow headRow = new DocxRow(cells_head, DocxStyleEnum.TABLE_HEAD.getDocxStyle());
        List<DocxRow> rows = new ArrayList<>();
        rows.add(headRow);
        for (int i = 0; i < contents.size(); i++) {
            List<String> rowList = contents.get(i);
            Throwables.checkArgument(rowList.size() == titles.size(), "");
            List<DocxCell> cells = new ArrayList<>();
            for (int j = 0; j < rowList.size(); j++) {
                String s = rowList.get(j);
                cells.add(new DocxCell(s, DocxStyle.builder().cellWidth(1000L).build()));
            }
            DocxRow row = new DocxRow(cells, DocxStyleEnum.ROW.getDocxStyle());
            rows.add(row);
        }
        return new DocxTable(rows);
    }
}
