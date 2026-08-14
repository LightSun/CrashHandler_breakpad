package com.heaven7.gui.parser;

public class UIParseTest {

    public static void main(String[] args) {
        String dsl = "Window{\n" +
                "// this is doc1 \n" +
                "                title: test_heaven7\n" +
                "                size: 800,600\n" +
                "                listener: com.heaven7.gui.TestListener.class\n" +
                "  /* doc2 \n doc3 \n*/ \n" +
                "                LinearLayout{\n" +
                "                    orientation: vertical\n" +
                "                    TextView{\n" +
                "                        id: tv1\n" +
                "                        text: text_view1\n" +
                "                        size: 120,30\n" +
                "                    }\n" +
                "                    Space{\n" +
                "                        size:0,30\n" +
                "                    }\n" +
                "                    EditText{\n" +
                "                        id: et1\n" +
                "                        text: default_text1\n" +
                "                        size: 200,50\n" +
                "                    }\n" +
                "                }\n" +
                "            }";
        UIParser parser = new UIParser();
        UIElement root = parser.parse(dsl);
        System.out.println(root);
        System.out.println("Window title: " + root.getAttr("title"));
        System.out.println("TextView id: " + root.getChildren().get(0).getChildren().get(0).getAttr("id"));
    }
}
