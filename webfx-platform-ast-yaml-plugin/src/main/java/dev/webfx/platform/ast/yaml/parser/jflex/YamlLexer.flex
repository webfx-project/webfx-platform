
/* --------------------------Usercode Section------------------------ */

package dev.webfx.platform.ast.yaml.parser.jflex;

import        dev.webfx.platform.ast.yaml.parser.javacup.YamlSymbols;
import static dev.webfx.platform.ast.yaml.parser.javacup.YamlSymbols.*;
import        dev.webfx.platform.ast.yaml.parser.javacup.MultipleSymbol;
import        dev.webfx.platform.util.Numbers;
import java_cup.runtime.*;
import java.util.List;

%%

/* -----------------Options and Declarations Section----------------- */

%public
%class YamlLexer
%line
%column
%cupsym YamlSymbols
%cup

/*
  Declarations
*/
%{   
    private StringBuilder sb = new StringBuilder();
    public IndentCounter indentCounter = new IndentCounter();
    private int lastUnquotedKeyLine = -1;

    private Symbol symbol(int type) {
        return symbol(type, null);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

%}

/* May help to uncomment for DEBUG
%eofval{
  return symbol(EOF);
%eofval}
*/

/*
  Macro Declarations
*/

LineTerminator = \R
InputCharacter = [^\r\n]
WhiteSpace     = [ ]
EmptyLine      = {WhiteSpace}* {LineTerminator}
WhiteSpaceOrLF = {WhiteSpace} | {LineTerminator}
DocumentStart = "---"
DocumentEnd = "..."
EndOfLineComment = "#" {InputCharacter}* {LineTerminator}?
LineComment = {WhiteSpace}* {EndOfLineComment}
IndentPlusChar = {WhiteSpace}* {InputCharacter}
UnquotedKeyCharacter = [^\r\n\"`\\:{},\[\]|]
UnquotedKeyFirstCharacter = [^\r\n\"`\\:{},\[\]|-]
UnquotedStringFirstCharacter = [^\r\n\"`\\:{},\[\]|#]
UnquotedJsonStringInvalidCharacter = [:,\]#]
UnquotedJsonStringCharacter = [^\r\n\:,\]#]
UnquotedStringCharacterButNotDigit = [^0-9]
SingleQuoteStringCharacter = [^\r\n'\\]
DoubleQuoteStringCharacter = [^\r\n\"\\]
GraveAccentStringCharacter = [^\r\n`\\]
LongLiteral = 0 | [1-9][0-9]*
DoubleLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?
FLit1    = [0-9]+ \. [0-9]*
FLit2    = \. [0-9]+
FLit3    = [0-9]+
Exponent = [eE] [+-]? [0-9]+
NumberLiteral = {LongLiteral} | {DoubleLiteral}
True = "y" | "Y" | "yes" | "Yes" | "YES" | "true" | "True" | "TRUE" | "on" | "On" | "ON"
False = "n" | "N" | "no" | "No" | "NO" | "false" | "False" | "FALSE" | "off" | "Off" | "OFF"
Null = "null" | "~"
Boolean = {True} | {False}
%state YYFINAL, AFTER_INDENT, SINGLE_QUOTE_STRING, DOUBLE_QUOTE_STRING, GRAVE_ACCENT_STRING, UNQUOTED_INDENT_STRING, UNQUOTED_JSON_STRING

%%
/* ------------------------Lexical Rules Section---------------------- */

/* Initial state = start of a new Yaml line */

<YYINITIAL> {

    /* Ignoring empty lines and comment lines */
    {EmptyLine}                     |
    {LineComment}                   { }

    /* Document start & end */
    {DocumentStart}                 |
    {DocumentEnd}                   {
                                        // Checking if it's an actual document start/end
                                        if (!yyatEOF() && !Character.isWhitespace(yycharat(3))) { // => It's a string starting with same characters!
                                            yypushback(3);
                                            yybegin(AFTER_INDENT);
                                        } else { // Yes, actual document start/end
                                            Symbol symbol = symbol(yycharat(1) == '-' ? DOCSTART : DOCEND);
                                            int openIndentCount = indentCounter.openIndentCount();
                                            if (openIndentCount == 0) // No open indent to close => we return DOCSTART/DOCEND
                                                return symbol;
                                            // At this point, we have reached the end of the first document we are scanning
                                            yyclose();
                                            indentCounter.clear();
                                            return MultipleSymbol.repeatedSymbolThenSymbol(openIndentCount, INDENT_CLOSE, symbol);
                                        }
                                    }

    /* Other line with possible indent */
    {IndentPlusChar}                {
                                        // The last character needs to be put back so it will be process by AFTER_INDENT
                                        yypushback(1);
                                        yybegin(AFTER_INDENT);
                                        // Ignoring indents symbols in Json sequences => We go straightway to AFTER_INDENT
                                        if (!indentCounter.isInsideJsonSequence()) {
                                            // How is this new indent compared to the previous one?
                                            int indentSymbol = indentCounter.indentSymbolOnNewLine(yylength());
                                            // If same (INDENT_SAME) or higher (INDENT_OPEN), we return that single symbol
                                            if (indentSymbol != INDENT_CLOSE) {
                                                return symbol(indentSymbol, indentCounter.currentIndent()); // INDENT_SAME or INDENT_OPEN
                                            } else { // INDENT_CLOSE may eventually be followed by other INDENT_EVENTS
                                                List<Symbol> symbols = indentCounter.closingAndFurtherIndentsForNewLine();
                                                return MultipleSymbol.ofList(symbols);
                                            }
                                         }
                                     }

    <<EOF>> {
        yybegin(YYFINAL);
        int indentSymbol = indentCounter.indentSymbolOnNewLine(-1);
        if (indentSymbol == INDENT_CLOSE) {
            List<Symbol> symbols = indentCounter.closingAndFurtherIndentsForNewLine();
            return MultipleSymbol.ofList(symbols);
        }
    }

}

<YYFINAL> {
    . { yyclose(); }
}

<AFTER_INDENT> {

    /* Subsequent whitespace */
    {WhiteSpace}                    { /* ignore */ }


    /* End of line -> Going back to initial state */
    {EndOfLineComment}              |
    {LineTerminator}                { yybegin(YYINITIAL); }

    /* Dash array entry */
    "-" {WhiteSpace}* {LineTerminator} { yybegin(YYINITIAL);  return symbol(DASH_ARRAY); }
    "-" {WhiteSpace}+               {
                                        // The only difference between this 2 cases is the next state: YYINITIAL with LF, AFTER_INDENT otherwise
                                        yybegin(yycharat(yylength() -1) == '\n' ? YYINITIAL : AFTER_INDENT);
                                        int indentSymbol = indentCounter.indentSymbolOnNewLine(indentCounter.currentIndent() + yylength());
                                        if (indentSymbol != INDENT_CLOSE) // INDENT_SAME or INDENT_OPEN
                                            return new MultipleSymbol(symbol(DASH_ARRAY), symbol(indentSymbol));
                                        // At least 1 - maybe several - INDENT_CLOSE possibly followed by INDENT_SAME
                                        List<Symbol> symbols = indentCounter.closingAndFurtherIndentsForNewLine();
                                        // The DASH_ARRAY happens before
                                        symbols.add(0, symbol(DASH_ARRAY));
                                        return MultipleSymbol.ofList(symbols);
                                    }

    /* Not number but string starting with digits! */
    /*
    {NumberLiteral} {UnquotedStringCharacterButNotDigit} { yypushback(yylength()); sb.setLength(0); yybegin(UNQUOTED_INDENT_STRING); }
    */

    /* Actual number */
    {NumberLiteral}                 |
    "-"{NumberLiteral}              { return symbol(NUMBER, Numbers.parseShortestNumber(yytext())); }

    /* Not boolean but string starting with boolean! */
    /*
    {Boolean} {UnquotedStringCharacterButNotDigit} { yypushback(yylength()); sb.setLength(0); yybegin(UNQUOTED_INDENT_STRING); }
    */

    /* Actual boolean */
    {True}                          { return symbol(BOOLEAN, Boolean.TRUE); }
    {False}                         { return symbol(BOOLEAN, Boolean.FALSE); }

    /* Not null but string starting with null! */
    /*
    {Null} {UnquotedStringCharacterButNotDigit} { yypushback(yylength()); sb.setLength(0); yybegin(UNQUOTED_INDENT_STRING); }
    */

    /* Actual null */
    {Null}                         { return symbol(NULL); }

    {UnquotedKeyFirstCharacter} {UnquotedKeyCharacter}* {WhiteSpace}* ":" {
                                      if (yyline == lastUnquotedKeyLine && !indentCounter.isInsideJsonSequence()) {
                                          yypushback(yylength());
                                          sb.setLength(0);
                                          yybegin(UNQUOTED_INDENT_STRING);
                                      } else {
                                          lastUnquotedKeyLine = yyline;
                                          yypushback(1); // COLON needs to be emitted after that key
                                          return symbol(UNQUOTED_KEY, yytext().substring(0, yylength()).trim());
                                      }
                                   }

    /* Json */
    "{"                            { indentCounter.incJsonOpenCurlyBracketCount(); return symbol(LCURLY); }
    "}"                            { indentCounter.decJsonOpenCurlyBracketCount(); return symbol(RCURLY); }
    "["                            { indentCounter.incJsonOpenCurlyBracketCount(); return symbol(LBRACK); }
    "]"                            { indentCounter.decJsonOpenCurlyBracketCount(); return symbol(RBRACK); }


    /* separators */
    ","                            { return symbol(COMMA); }
    ":"                            { return symbol(COLON); }
    "|"                            {
                                        sb.setLength(0);
                                        yybegin(UNQUOTED_INDENT_STRING);
                                        return symbol(PIPE);
                                   }
    ">"                            {
                                        sb.setLength(0);
                                        yybegin(UNQUOTED_INDENT_STRING);
                                        return symbol(GREATER_THAN);
                                   }

  /* string literal */
    "'"                            { sb.setLength(0); yybegin(SINGLE_QUOTE_STRING); }
    \"                             { sb.setLength(0); yybegin(DOUBLE_QUOTE_STRING); }
    "`"                            { sb.setLength(0); yybegin(GRAVE_ACCENT_STRING); }
    {UnquotedStringFirstCharacter} {
                                      yypushback(1);
                                      sb.setLength(0);
                                      if (indentCounter.isInsideJsonSequence())
                                          yybegin(UNQUOTED_JSON_STRING);
                                      else
                                          yybegin(UNQUOTED_INDENT_STRING);
                                    }

}


<SINGLE_QUOTE_STRING> {
  "''"                           { sb.append( '\'' ); }

  "'"                            { yybegin(AFTER_INDENT); return symbol(QUOTED_STRING, sb.toString()); }

  {SingleQuoteStringCharacter}+  { sb.append( yytext() ); }

  /* In single-quoted strings, backslashes are treated as literal characters */
  "\\"                           { sb.append( '\\' ); }

  /* line continuation */
  "\\" {LineTerminator}          { /* ignore the line break */ }

  /* error cases */
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

<DOUBLE_QUOTE_STRING> {
  \"                             { yybegin(AFTER_INDENT); return symbol(QUOTED_STRING, sb.toString()); }

  {DoubleQuoteStringCharacter}+  { sb.append( yytext() ); }

  /* escape sequences */
  "\\0"                          { sb.append( '\u0000' ); }
  "\\a"                          { sb.append( '\u0007' ); }
  "\\b"                          { sb.append( '\b' ); }
  "\\t"                          { sb.append( '\t' ); }
  "\\n"                          { sb.append( '\n' ); }
  "\\v"                          { sb.append( '\u000B' ); }
  "\\f"                          { sb.append( '\f' ); }
  "\\r"                          { sb.append( '\r' ); }
  "\\e"                          { sb.append( '\u001B' ); }
  "\\\""                         { sb.append( '\"' ); }
  "\\\\"                         { sb.append( '\\' ); }
  "\\/"                          { sb.append( '/' ); }
  "\\N"                          { sb.append( '\u0085' ); }  /* Unicode next line character */
  "\\_"                          { sb.append( '\u00A0' ); }  /* Unicode non-breaking space */
  "\\L"                          { sb.append( '\u2028' ); }  /* Unicode line separator */
  "\\P"                          { sb.append( '\u2029' ); }  /* Unicode paragraph separator */
  "\\x"[0-9A-Fa-f]{2}            { 
                                   String hex = yytext().substring(2); 
                                   int code = Integer.parseInt(hex, 16);
                                   sb.append((char) code);
                                 }
  "\\u"[0-9A-Fa-f]{4}            { 
                                   String hex = yytext().substring(2); 
                                   int code = Integer.parseInt(hex, 16);
                                   sb.append((char) code);
                                 }
  "\\U"[0-9A-Fa-f]{8}            { 
                                   String hex = yytext().substring(2); 
                                   int code = Integer.parseInt(hex, 16);
                                   sb.append(Character.toChars(code));
                                 }
  \\.                            { sb.append( yytext().substring(1) ); }

  /* line continuation */
  "\\" {LineTerminator}          { /* ignore the line break */ }

  /* error cases */
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

<GRAVE_ACCENT_STRING> {
  "`"                            { yybegin(AFTER_INDENT); return symbol(QUOTED_STRING, sb.toString()); }

  {GraveAccentStringCharacter}+  { sb.append( yytext() ); }

  /* escape sequences */
  "\\0"                          { sb.append( '\u0000' ); }
  "\\a"                          { sb.append( '\u0007' ); }
  "\\b"                          { sb.append( '\b' ); }
  "\\t"                          { sb.append( '\t' ); }
  "\\n"                          { sb.append( '\n' ); }
  "\\v"                          { sb.append( '\u000B' ); }
  "\\f"                          { sb.append( '\f' ); }
  "\\r"                          { sb.append( '\r' ); }
  "\\e"                          { sb.append( '\u001B' ); }
  "\\\""                         { sb.append( '\"' ); }
  "\\`"                          { sb.append( '`' ); }
  "\\\\"                         { sb.append( '\\' ); }
  "\\/"                          { sb.append( '/' ); }
  "\\N"                          { sb.append( '\u0085' ); }  /* Unicode next line character */
  "\\_"                          { sb.append( '\u00A0' ); }  /* Unicode non-breaking space */
  "\\L"                          { sb.append( '\u2028' ); }  /* Unicode line separator */
  "\\P"                          { sb.append( '\u2029' ); }  /* Unicode paragraph separator */
  "\\x"[0-9A-Fa-f]{2}            { 
                                   String hex = yytext().substring(2); 
                                   int code = Integer.parseInt(hex, 16);
                                   sb.append((char) code);
                                 }
  "\\u"[0-9A-Fa-f]{4}            { 
                                   String hex = yytext().substring(2); 
                                   int code = Integer.parseInt(hex, 16);
                                   sb.append((char) code);
                                 }
  "\\U"[0-9A-Fa-f]{8}            { 
                                   String hex = yytext().substring(2); 
                                   int code = Integer.parseInt(hex, 16);
                                   sb.append(Character.toChars(code));
                                 }
  \\.                            { sb.append( yytext().substring(1) ); }

  /* line continuation */
  "\\" {LineTerminator}          { /* ignore the line break */ }

  /* error cases */
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

<UNQUOTED_JSON_STRING> {
  {UnquotedJsonStringCharacter}* {LineTerminator} { sb.append(yytext()); }

  {UnquotedJsonStringCharacter}* {UnquotedJsonStringInvalidCharacter} {
                                    if (sb.length() == 0)
                                        throw new Error("Illegal character '" + yycharat(yylength() - 1) +"' in unquoted Json string <"+yytext()+">");
                                    yypushback(yylength());
                                    yybegin(YYINITIAL);
                                    return symbol(UNQUOTED_STRING, sb.toString());
                                 }
}

<UNQUOTED_INDENT_STRING> {
  {InputCharacter}* {LineTerminator} {
                                    if (sb.length() == 0 || indentCounter.isSubsequentUnquotedStringLine(yytext())) {
                                        sb.append(yytext());
                                    } else {
                                        yypushback(yylength());
                                        yybegin(YYINITIAL);
                                        return symbol(UNQUOTED_STRING, sb.toString());
                                     }
                                 }
   <<EOF>> {
        yybegin(YYFINAL);
        Symbol symbol = symbol(UNQUOTED_STRING, sb.toString());
        int indentSymbol = indentCounter.indentSymbolOnNewLine(-1);
        if (indentSymbol != INDENT_CLOSE)
            return symbol;
        List<Symbol> symbols = indentCounter.closingAndFurtherIndentsForNewLine();
        symbols.add(0, symbol);
        return MultipleSymbol.ofList(symbols);
   }
}

/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
