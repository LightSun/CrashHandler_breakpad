package com.heaven7.gui.parser;

public class UIParser {
    private String src;
    private int pos;

    public UIElement parse(String source) {
        this.src = source;
        this.pos = 0;
        skipWhitespaceAndComments();
        UIElement root = parseElement();
        skipWhitespaceAndComments();
        if (pos < src.length()) throw new RuntimeException("Unexpected trailing characters");
        return root;
    }

    private UIElement parseElement() {
        String name = readIdentifier();
        expect('{');
        UIElement elem = new UIElement(name);
        parseElementBody(elem);
        expect('}');
        return elem;
    }

    private void parseElementBody(UIElement elem) {
        while (true) {
            skipWhitespaceAndComments();
            if (peek() == '}') break;

            String key = readIdentifier();
            skipWhitespaceAndComments();

            if (peek() == ':') {
                pos++; // 跳过 ':'
                skipWhitespaceAndComments();
                String value = readAttributeValue();
                elem.setAttribute(key, value);
            } else if (peek() == '{') {
                UIElement child = new UIElement(key);
                expect('{');
                parseElementBody(child);
                expect('}');
                elem.addChild(child);
            } else {
                throw new RuntimeException("Expected ':' or '{' after '" + key + "' at " + pos);
            }
        }
    }

    private String readIdentifier() {
        skipWhitespaceAndComments();
        StringBuilder sb = new StringBuilder();
        while (pos < src.length()) {
            char c = src.charAt(pos);
            if (Character.isLetterOrDigit(c) || c == '_' || c == '.') {
                sb.append(c);
                pos++;
            } else break;
        }
        if (sb.length() == 0) throw new RuntimeException("Expected identifier at " + pos);
        return sb.toString();
    }

    private String readAttributeValue() {
        // 属性值内部不跳过注释，保持原样
        StringBuilder sb = new StringBuilder();
        while (pos < src.length()) {
            char c = src.charAt(pos);
            if (c == '\n' || c == '\r') {
                pos++;
                break;
            }
            if (c == '}') break;
            sb.append(c);
            pos++;
            // 提前结束检测：如果后面紧跟空白和 '}'
            int look = pos;
            while (look < src.length() && Character.isWhitespace(src.charAt(look))) look++;
            if (look < src.length() && src.charAt(look) == '}') break;
        }
        return sb.toString().trim();
    }

    private void expect(char ch) {
        skipWhitespaceAndComments();
        if (pos >= src.length() || src.charAt(pos) != ch)
            throw new RuntimeException("Expected '" + ch + "' at " + pos);
        pos++;
    }

    private char peek() {
        skipWhitespaceAndComments();
        return pos < src.length() ? src.charAt(pos) : 0;
    }

    // 核心方法：跳过空白字符及注释（单行 //，多行 /* */）
    private void skipWhitespaceAndComments() {
        boolean changed;
        do {
            changed = false;
            // 1. 跳过普通空白字符
            while (pos < src.length() && Character.isWhitespace(src.charAt(pos))) {
                pos++;
                changed = true;
            }
            // 2. 跳过单行注释 //
            if (pos + 1 < src.length() && src.charAt(pos) == '/' && src.charAt(pos + 1) == '/') {
                pos += 2;
                while (pos < src.length() && src.charAt(pos) != '\n' && src.charAt(pos) != '\r') {
                    pos++;
                }
                changed = true;
                continue; // 继续循环，可能后面还有空白或注释
            }
            // 3. 跳过多行注释 /* */
            if (pos + 1 < src.length() && src.charAt(pos) == '/' && src.charAt(pos + 1) == '*') {
                pos += 2;
                while (pos + 1 < src.length() && !(src.charAt(pos) == '*' && src.charAt(pos + 1) == '/')) {
                    pos++;
                }
                if (pos + 1 < src.length()) {
                    pos += 2; // 跳过 "*/"
                } else {
                    throw new RuntimeException("Unclosed multi-line comment at " + pos);
                }
                changed = true;
                continue;
            }
        } while (changed);
    }
}