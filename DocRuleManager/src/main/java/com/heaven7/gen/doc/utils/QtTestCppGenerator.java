package com.heaven7.gen.doc.utils;

import com.heaven7.gen.doc.bean.UnitTestItem;
import com.heaven7.gen.doc.bean.UnitTestQtItem;
import com.heaven7.java.base.util.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QtTestCppGenerator {

    public void generateAll(UnitTestQtItem item, String outDir){
        new File(outDir).mkdirs();
        generate(item, outDir);
        generateCMake(item, outDir);
    }

    public void generate(UnitTestQtItem item, String outDir){
        String genName = item.getClassName() + "_Tester";
        String outFile = outDir + "/" + genName + ".cpp";
        LineWriter writer = new LineWriter(outFile);
        writer.writeLine("#include <QtTest>");
        writer.writeLine("#include <QCoreApplication>");
        writer.writeLine("");
        writer.writeLine("using String = std::string;");
        //other include.
        writer.writeLine("class " + genName + " : public QObject");
        writer.writeLine("{ Q_OBJECT");
        writer.writeLine("public:");
        writer.writeLine("\t" + genName + "();");
        writer.writeLine("\t~" + genName + "();");
        writer.writeLine("private slots:");
        writer.writeLine("\t" + "void initTestCase();");
        writer.writeLine("\t" + "void cleanupTestCase();");
        //
        int lastIdx = 0;
        for (int i = 0; i < item.getMethodNames().size(); i++) {
            String mn = item.getMethodNames().get(i);
            int excelCnt = item.getKitems().get(i).getMethodCount();
            for (int j = 0; j < excelCnt; j++) {
                int index = lastIdx + 1 + j;
                writer.writeLine("\t" + "void testCase" + index + "_" + mn + "_data();");
                writer.writeLine("\t" + "void testCase" + index + "_" + mn + "();");
            }
            lastIdx += excelCnt;
        }
        writer.writeLine("private:");
        writer.writeLine("};");
        writer.writeLine("Q_DECLARE_METATYPE(String);");
        //pri -codes
        //-------- gen impl ---------
        writer.writeLine("//-------- impl ---------");
        writer.writeLine(genName + "::" + genName + "()");
        writer.writeLine("{");
        writer.writeLine("}");
        writer.writeLine(genName + "::~" + genName + "()");
        writer.writeLine("{");
        writer.writeLine("}");
        //
        writer.writeLine("void " + genName + "::initTestCase()");
        writer.writeLine("{");
        writer.writeLine("}");
        writer.writeLine("void " + genName + "::cleanupTestCase()");
        writer.writeLine("{");
        writer.writeLine("}");
        //
        lastIdx = 0;
        for (int i = 0; i < item.getMethodNames().size(); i++) {
            String mn = item.getMethodNames().get(i);
            int excelCnt = item.getKitems().get(i).getMethodCount();
            for (int j = 0; j < excelCnt; j++) {
                int index = lastIdx + 1 + j;
                writer.writeLine("void "+ genName + "::testCase" + index + "_" + mn + "_data()");
                writer.writeLine("{");
                writer.writeLine("}");

                writer.writeLine("void "+ genName + "::testCase" + index + "_" + mn + "()");
                writer.writeLine("{");
                writer.writeLine("}");
            }
            lastIdx += excelCnt;
        }
        //Q_DECLARE_METATYPE(MassOperation)
        // QCOMPARE(bResult, true);
        writer.writeLine("QTEST_MAIN(" + genName + ")");
        writer.writeLine("#include \"" + genName + ".moc\"");
        //QFETCH(...)
        writer.flush();
        writer.close();
    }

    public void generateCMake(UnitTestQtItem item, String outDir){
        String genName = item.getClassName() + "_Tester";
        String outFile = outDir + "/CMakeLists.txt";
        //
        StringBuilder sb = new StringBuilder();
        sb.append("cmake_minimum_required(VERSION 3.5)\n" +
                "\n"
        );
        sb.append("project(").append(genName).append("  LANGUAGES CXX)\n");
        sb.append("\n");
        sb.append("set(CMAKE_INCLUDE_CURRENT_DIR ON)\n" +
                "\n" +
                "set(CMAKE_AUTOUIC ON)\n" +
                "set(CMAKE_AUTOMOC ON)\n" +
                "set(CMAKE_AUTORCC ON)\n" +
                "\n" +
                "set(CMAKE_CXX_STANDARD 17)\n" +
                "set(CMAKE_CXX_STANDARD_REQUIRED ON)\n" +
                "enable_testing()\n" +
                "\n" +
                "file(GLOB_RECURSE CPP_SOURCES \"*.cpp\")\n" +
                "file(GLOB_RECURSE C_SOURCES \"*.c\")\n" +
                "file(GLOB_RECURSE HEADERS \"*.h\")\n" +
                "file(GLOB_RECURSE FORMS \"*.ui\")\n" +
                "file(GLOB_RECURSE RESOURCES \"*.qrc\")"
        );
        sb.append("\n");
        sb.append("find_package(Qt5 COMPONENTS Core Test REQUIRED)\n");
        sb.append("\n");
        sb.append("add_test(NAME ")
                .append(genName)
                .append(" COMMAND ")
                .append(genName)
                .append(")");
        sb.append("\n");
        sb.append("add_executable(").append(genName)
                .append(" ${CPP_SOURCES} ${C_SOURCES} ${HEADERS} ${FORMS} ${RESOURCES})\n");
        sb.append("target_link_libraries(")
                .append(genName)
                .append(" ")
                .append("Qt5::Core Qt5::Test)\n");
        //
        FileUtils.writeTo(outFile, sb.toString());
    }

    public static void main(String[] args) {
        //test
        List<String> meNames = Arrays.asList("method1", "method2", "method3");
        ArrayList<UnitTestItem> kitems = new ArrayList<>();
        for (int i = 0; i < meNames.size(); i++) {
            UnitTestItem item = new UnitTestItem();
            item.presetCase = Arrays.asList("1", "2");
            kitems.add(item);
        }
        UnitTestQtItem item = new UnitTestQtItem();
        item.setClassName("FPS");
        item.setMethodNames(meNames);
        item.setKitems(kitems);
        //
        String outDir = "/home/heaven7/heaven7/temp/unit_test";
        QtTestCppGenerator generator = new QtTestCppGenerator();
        generator.generateAll(item, outDir);
    }
}
