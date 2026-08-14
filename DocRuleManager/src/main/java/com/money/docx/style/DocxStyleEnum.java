package com.money.docx.style;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.docx4j.wml.JcEnumeration;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum DocxStyleEnum {

    //1440 : 1yingcun
    DEFAULT_TOC_TITLE(DocxStyle.builder().align(JcEnumeration.CENTER).bold(true).fontSize(20L).build()),
    CONTENT(DocxStyle.builder().firstLineIndent(480).align(JcEnumeration.LEFT).fontSize(14L).build()),
    CONTENT2(DocxStyle.builder().firstLineIndent(960).align(JcEnumeration.LEFT).fontSize(14L).build()),
    ROW(DocxStyle.builder().align(JcEnumeration.CENTER).fontSize(14L).build()),
    TABLE_HEAD(DocxStyle.builder().align(JcEnumeration.CENTER).bold(true).fontSize(14L).build()),
    TABLE_WHOLE(DocxStyle.builder().tableIndent(960).build()),
    ;


    private final DocxStyle docxStyle;

}
