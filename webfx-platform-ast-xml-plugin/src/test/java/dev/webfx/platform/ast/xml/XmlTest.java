package dev.webfx.platform.ast.xml;

/**
 * @author Bruno Salmon
 */
public class XmlTest {

    /*@Test
    public void testSimpleXmlParsing() {
        // Test parsing a simple XML element
        String xml = "<person name=\"Alice\" age=\"30\"/>";

        try {
            // Direct use of the parser and lexer
            java.io.StringReader reader = new java.io.StringReader(xml);
            dev.webfx.platform.ast.xml.parser.jflex.XmlLexer lexer = new dev.webfx.platform.ast.xml.parser.jflex.XmlLexer(reader);
            dev.webfx.platform.ast.xml.parser.javacup.JavaCupXmlParser parser = new dev.webfx.platform.ast.xml.parser.javacup.JavaCupXmlParser(lexer);

            // Parse the XML
            java_cup.runtime.Symbol parseResult = parser.parse();

            // Check the result
            Assert.assertNotNull("Parse result should not be null", parseResult);
            Assert.assertNotNull("Parse result value should not be null", parseResult.value);

            // Convert to AstObject
            ReadOnlyAstObject parsedObject = (ReadOnlyAstObject) parseResult.value;

            // Verify the parsed object structure
            Assert.assertNotNull(parsedObject);
            ReadOnlyAstObject person = parsedObject.getObject("person");
            Assert.assertNotNull(person);
            Assert.assertEquals("Alice", person.getString("name"));
            Assert.assertEquals("30", person.getString("age"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception during parsing: " + e.getMessage());
        }
    }

    @Test
    public void testXmlWithAttributes() {
        // Test parsing XML with attributes
        String xml = "<person id=\"123\" active=\"true\"><name>Bob</name><age>25</age></person>";
        ReadOnlyAstObject parsedObject = Xml.parseObject(xml);

        // Verify the parsed object structure
        Assert.assertNotNull(parsedObject);
        ReadOnlyAstObject person = parsedObject.getObject("person");
        Assert.assertNotNull(person);
        Assert.assertEquals("123", person.getString("id"));
        Assert.assertEquals(true, person.getBoolean("active"));
        Assert.assertEquals("Bob", person.getString("name"));
        Assert.assertEquals(25, person.getInteger("age").intValue());
    }

    @Test
    public void testNestedXml() {
        // Test parsing nested XML elements
        String xml = "<person><name>Charlie</name><age>35</age><address><street>123 Main St</street><city>Anytown</city></address></person>";
        ReadOnlyAstObject parsedObject = Xml.parseObject(xml);

        // Verify the parsed object structure
        Assert.assertNotNull(parsedObject);
        ReadOnlyAstObject person = parsedObject.getObject("person");
        Assert.assertNotNull(person);
        Assert.assertEquals("Charlie", person.getString("name"));
        Assert.assertEquals(35, person.getInteger("age").intValue());

        ReadOnlyAstObject address = person.getObject("address");
        Assert.assertNotNull(address);
        Assert.assertEquals("123 Main St", address.getString("street"));
        Assert.assertEquals("Anytown", address.getString("city"));
    }

    @Test
    public void testXmlFormatting() {
        // Create an AST object
        AstObject person = AST.createObject()
                .set("name", "Alice")
                .set("age", 30);

        AstObject root = AST.createObject()
                .set("person", person);

        // Format the object to XML
        String xml = Xml.formatObject(root);

        // Parse the formatted XML back to an object
        ReadOnlyAstObject parsedObject = Xml.parseObject(xml);

        // Verify the round-trip conversion
        Assert.assertNotNull(parsedObject);
        ReadOnlyAstObject parsedPerson = parsedObject.getObject("person");
        Assert.assertNotNull(parsedPerson);
        Assert.assertEquals("Alice", parsedPerson.getString("name"));
        Assert.assertEquals(30, parsedPerson.getInteger("age").intValue());
    }

    @Test
    public void testXmlWithSpecialCharacters() {
        // Test handling of special characters in XML
        String xml = "<message><text>This is a &lt;special&gt; message with &amp; and &quot;quotes&quot;</text></message>";
        ReadOnlyAstObject parsedObject = Xml.parseObject(xml);

        // Verify the parsed object structure
        Assert.assertNotNull(parsedObject);
        ReadOnlyAstObject message = parsedObject.getObject("message");
        Assert.assertNotNull(message);
        Assert.assertEquals("This is a <special> message with & and \"quotes\"", message.getString("text"));
    }

    @Test
    public void testJsonToXmlConversion() {
        // Create an object that represents the JSON example from the issue description
        AstObject name = AST.createObject().set("value", "Alice");
        AstObject age = AST.createObject().set("value", 30);

        AstObject person = AST.createObject()
                .set("name", name)
                .set("age", age);

        AstObject root = AST.createObject()
                .set("person", person);

        // Format the object to XML
        String xml = Xml.formatObject(root);

        // The expected XML should be similar to:
        // <person>
        //   <name>Alice</name>
        //   <age>30</age>
        // </person>

        // Parse the formatted XML back to an object
        ReadOnlyAstObject parsedObject = Xml.parseObject(xml);

        // Verify the structure matches the original
        Assert.assertNotNull(parsedObject);
        ReadOnlyAstObject parsedPerson = parsedObject.getObject("person");
        Assert.assertNotNull(parsedPerson);
        Assert.assertEquals("Alice", parsedPerson.getString("name"));
        Assert.assertEquals(30, parsedPerson.getInteger("age").intValue());
    }*/
}
