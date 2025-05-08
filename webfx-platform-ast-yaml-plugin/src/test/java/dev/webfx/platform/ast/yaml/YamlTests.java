package dev.webfx.platform.ast.yaml;

/**
 * @author Bruno Salmon
 */
public class YamlTests {

    public void test1() {
        /*ReadOnlyAstNode parsed = Yaml.parseObject("x: 1 y: 2");
        String formatted = Yaml.formatNode(parsed);
        System.out.println("result: " + formatted);*/
    }

    public void testStringFormats() {
/*
        // Test single-quoted string with escape sequences
        // In single-quoted strings, backslashes are treated as literal characters
        ReadOnlyAstObject parsed1 = Yaml.parseObject("key: 'value with \\n literal backslash-n and ''single quote''.'");
        System.out.println("Single-quoted: " + parsed1.getString("key"));

        // Test double-quoted string with escape sequences
        ReadOnlyAstObject parsed2 = Yaml.parseObject("key: \"value with \\n newline and \\u0041 unicode\"");
        System.out.println("Double-quoted: " + parsed2.getString("key"));

        // Test grave-accent string with escape sequences
        ReadOnlyAstObject parsed3 = Yaml.parseObject("key: `value with \\n newline and \\u0041 unicode`");
        System.out.println("Grave-accent: " + parsed3.getString("key"));

        // Test multi-line string with line continuation
        ReadOnlyAstObject parsed4 = Yaml.parseObject("key: \"first line \\\n  second line\"");
        System.out.println("Multi-line with continuation: " + parsed4.getString("key"));

        // Test block scalar literal style
        ReadOnlyAstObject parsed5 = Yaml.parseObject("key: |\n  first line\n  second line\n  third line");
        System.out.println("Block scalar literal: " + parsed5.getString("key"));

        // Test block scalar folded style
        ReadOnlyAstObject parsed6 = Yaml.parseObject("key: >\n  first line\n  second line\n  third line");
        System.out.println("Block scalar folded: " + parsed6.getString("key"));

        // Test block scalar with indentation indicator
        ReadOnlyAstObject parsed7 = Yaml.parseObject("key: |2\n    first line\n    second line\n    third line");
        System.out.println("Block scalar with indent indicator: " + parsed7.getString("key"));

        // Test block scalar with chomping indicator (strip)
        ReadOnlyAstObject parsed8 = Yaml.parseObject("key: |-\n  first line\n  second line\n  third line\n\n");
        System.out.println("Block scalar with strip chomping: " + parsed8.getString("key"));

        // Test block scalar with chomping indicator (keep)
        ReadOnlyAstObject parsed9 = Yaml.parseObject("key: |+\n  first line\n  second line\n  third line\n\n");
        System.out.println("Block scalar with keep chomping: " + parsed9.getString("key"));

        // Test folded scalar with empty lines
        ReadOnlyAstObject parsed10 = Yaml.parseObject("key: >\n  first line\n\n  second line\n  third line");
        System.out.println("Folded scalar with empty lines: " + parsed10.getString("key"));

        // Test folded scalar with more indented lines
        ReadOnlyAstObject parsed11 = Yaml.parseObject("key: >\n  first line\n    more indented\n  third line");
        System.out.println("Folded scalar with more indented lines: " + parsed11.getString("key"));

        // Test additional escape sequences in double-quoted strings
        ReadOnlyAstObject parsed12 = Yaml.parseObject("key: \"\\0 \\a \\b \\t \\n \\v \\f \\r \\e \\N \\_ \\L \\P \\x41 \\u0042 \\U00000043\"");
        System.out.println("Additional escape sequences: " + parsed12.getString("key"));
 */
    }

/*
    public static void main(String[] args) {
        YamlTests tests = new YamlTests();
        tests.test1();
        tests.testStringFormats();
    }
*/

}
