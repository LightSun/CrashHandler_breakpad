package com.heaven7.gen.doc.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 * //用例编号, 软件项（类名), 软件单元(函数完整签名), 用例描述(函数说明), 预置条件(单元测试的先验条件), 操作步骤, 预期结果(返回值), 测试结果
 */
@Getter
@Setter
@ContentRowHeight(80)
@HeadRowHeight(100)
@ColumnWidth(40)
public class ExcelUnitItem {

    @ExcelProperty("用例编号")
    private WriteCellData<String> caseId;
    @ExcelProperty("软件项(被测模块)")
    private WriteCellData<String> className;
    @ExcelProperty("软件单元(源代码)")
    private WriteCellData<String> methodSign;
    @ExcelProperty("用例描述")
    private WriteCellData<String> methodDesc;
    @ExcelProperty("预置条件")
    private WriteCellData<String> presetCase;
    @ExcelProperty("操作步骤")
    private WriteCellData<String> steps; // \n 隔离 1，2，3...
    @ExcelProperty("预期结果")
    private WriteCellData<String> expectResult;
    @ExcelProperty("测试结果")
    private WriteCellData<String> testResult;

    public static WriteCellData<String> newCellData(String str){
        WriteCellData<String> writeCellStyle = new WriteCellData<>(str);
        writeCellStyle.setType(CellDataTypeEnum.STRING);
        WriteCellStyle writeCellStyleData = new WriteCellStyle();
        writeCellStyleData.setHorizontalAlignment(HorizontalAlignment.CENTER);
        writeCellStyleData.setVerticalAlignment(VerticalAlignment.CENTER);
        writeCellStyle.setWriteCellStyle(writeCellStyleData);
        return writeCellStyle;
    }
}
