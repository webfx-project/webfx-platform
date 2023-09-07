
/* --------------------------Usercode Section------------------------ */

package dev.webfx.platform.ast.yaml.parser.jflex;

import java_cup.runtime.*;
import        dev.webfx.platform.ast.yaml.parser.javacup.YamlSymbols;
import static dev.webfx.platform.ast.yaml.parser.javacup.YamlSymbols.*;
import        dev.webfx.platform.util.Numbers;

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
    StringBuilder sb = new StringBuilder();
    IndentCounter indentCounter = new IndentCounter();
    int lastUnquotedKeyLine = -1;
    int minusArrayPostIndent;
    int minusArrayPostNextState;

    private Symbol symbol(int type) {
        return symbol(type, null);
    }
    
    private Symbol symbol(int type, Object value) {
        // uncomment the following line for debugging:
        System.out.println("-".repeat(indentCounter.openIndentCount()) +  "> Symbol " + YamlSymbols.terminalNames[type] + (value == null ? "" : "(" + value + ")"));
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
%state SUBSEQUENT_CLOSING_INDENT, DOCUMENT_CLOSING_INDENT, AFTER_INDENT, DASH_ARRAY_POST_INDENT, SINGLE_QUOTE_STRING, DOUBLE_QUOTE_STRING, GRAVE_ACCENT_STRING, UNQUOTED_STRING, UNQUOTED_JSON_STRING

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
                                        if (!yyatEOF() && !Character.isWhitespace(yycharat(3))) { // No: probably a string starting with same characters
                                            yypushback(3);
                                            yybegin(AFTER_INDENT);
                                        } else { // Yes, actual document start/end
                                            int openIndentCount = indentCounter.openIndentCount();
                                            if (openIndentCount == 0) // No open indent to close => we return DOCSTART/DOCEND
                                                return symbol(yycharat(1) == '-' ? DOCSTART : DOCEND);
                                            if (openIndentCount > 1) {
                                                String s = "X".repeat(openIndentCount - 1);
                                                yyreset(new java.io.StringReader(s));
                                                yybegin(DOCUMENT_CLOSING_INDENT);
                                            }
                                            // Note: DOCSTART or DOCEND won't be emitted in that case, but doesn't really matter
                                            return symbol(INDENT_CLOSE);
                                        }
                                    }

    /* Other line with possible indent */
    {IndentPlusChar}                {
                                        // The last character needs to be put back for AFTER_INDENT
                                        yypushback(1);
                                        if (indentCounter.isInsideJsonSequence()) {
                                            yybegin(AFTER_INDENT);
                                        } else {
                                            // How is this new indent compared to the previous one?
                                            int indentSymbol = indentCounter.indentSymbolOnNewLine(yylength());
                                            // If same (INDENT_SAME) or higher (INDENT_OPEN), we move to AFTER_INDENT
                                            if (indentSymbol != INDENT_CLOSE) {
                                                yybegin(AFTER_INDENT);
                                                return symbol(indentSymbol, yylength()); // INDENT_SAME or INDENT_OPEN
                                            } else {
                                                if (yylength() > 0) {
                                                   yypushback(1);
                                                   yybegin(SUBSEQUENT_CLOSING_INDENT);
                                                } else {
                                                   yybegin(YYINITIAL);
                                                }
                                                return symbol(indentSymbol);
                                            }
                                         }
                                     }

    <<EOF>> {
        int count = indentCounter.openIndentCount();
        if (count > 0) {
            String s = "X".repeat(count);
            yyreset(new java.io.StringReader(s));
            yybegin(DOCUMENT_CLOSING_INDENT);
        }
    }

}

<DOCUMENT_CLOSING_INDENT> {
    .                               { return symbol(INDENT_CLOSE); }
}

<SUBSEQUENT_CLOSING_INDENT> {
    .                               {
                                        int indentSymbol = indentCounter.nextIndentSymbolAfterClose();
                                        if (indentSymbol != INDENT_CLOSE)
                                            yybegin(AFTER_INDENT);
                                        else {
                                            yypushback(1);
                                        }
                                        return symbol(indentSymbol);
                                    }
}

<AFTER_INDENT> {

    /* Subsequent whitespace */
    {WhiteSpace}                    { /* ignore */ }


    /* End of line -> Going back to initial state */
    {EndOfLineComment}              |
    {LineTerminator}                { yybegin(YYINITIAL); }

    /* Dash array entry */
    "-" {WhiteSpace}* {LineTerminator} {
                                        minusArrayPostIndent = indentCounter.currentIndent() + yylength();
                                        minusArrayPostNextState = YYINITIAL;
                                        yypushback(1);
                                        yybegin(DASH_ARRAY_POST_INDENT);
                                        return symbol(DASH_ARRAY);
                                    }

    "-" {WhiteSpace}+               {
                                        minusArrayPostIndent = indentCounter.currentIndent() + yylength();
                                        minusArrayPostNextState = AFTER_INDENT;
                                        yypushback(1);
                                        yybegin(DASH_ARRAY_POST_INDENT);
                                        return symbol(DASH_ARRAY);
                                    }

    /* Not number but string starting with digits! */
    /*
    {NumberLiteral} {UnquotedStringCharacterButNotDigit} { yypushback(yylength()); sb.setLength(0); yybegin(UNQUOTED_STRING); }
    */

    /* Actual number */
    {NumberLiteral}                 |
    "-"{NumberLiteral}              { return symbol(NUMBER, Numbers.parseShortestNumber(yytext())); }

    /* Not boolean but string starting with boolean! */
    /*
    {Boolean} {UnquotedStringCharacterButNotDigit} { yypushback(yylength()); sb.setLength(0); yybegin(UNQUOTED_STRING); }
    */

    /* Actual boolean */
    {True}                          { return symbol(BOOLEAN, Boolean.TRUE); }
    {False}                         { return symbol(BOOLEAN, Boolean.FALSE); }

    /* Not null but string starting with null! */
    /*
    {Null} {UnquotedStringCharacterButNotDigit} { yypushback(yylength()); sb.setLength(0); yybegin(UNQUOTED_STRING); }
    */

    /* Actual null */
    {Null}                         { return symbol(NULL); }

    {UnquotedKeyFirstCharacter} {UnquotedKeyCharacter}* {WhiteSpace}* ":" {
                                      if (yyline == lastUnquotedKeyLine && !indentCounter.isInsideJsonSequence()) {
                                          yypushback(yylength());
                                          sb.setLength(0);
                                          yybegin(UNQUOTED_STRING);
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
                                        yybegin(UNQUOTED_STRING);
                                        return symbol(PIPE);
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
                                          yybegin(UNQUOTED_STRING);
                                    }

}

<DASH_ARRAY_POST_INDENT> {
    . | {LineTerminator}           {
                                        int indentSymbol = indentCounter.indentSymbolOnNewLine(minusArrayPostIndent);
                                        if (indentSymbol != INDENT_CLOSE)
                                            yybegin(minusArrayPostNextState);
                                        else {
                                            yypushback(1);
                                            yybegin(SUBSEQUENT_CLOSING_INDENT);
                                        }
                                        return symbol(indentSymbol, minusArrayPostIndent);
                                    }
}


<SINGLE_QUOTE_STRING> {
  "'"                            { yybegin(AFTER_INDENT); return symbol(QUOTED_STRING, sb.toString()); }

  {SingleQuoteStringCharacter}+  { sb.append( yytext() ); }

  /* escape sequences */
  "\\b"                          { sb.append( '\b' ); }
  "\\t"                          { sb.append( '\t' ); }
  "\\n"                          { sb.append( '\n' ); }
  "\\f"                          { sb.append( '\f' ); }
  "\\r"                          { sb.append( '\r' ); }
  "\\\""                         { sb.append( '\"' ); }
  "\\\\"                         { sb.append( '\\' ); }
  \\.                            { sb.append( yytext() ); }

  /* error cases */
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

<DOUBLE_QUOTE_STRING> {
  \"                             { yybegin(AFTER_INDENT); return symbol(QUOTED_STRING, sb.toString()); }

  {DoubleQuoteStringCharacter}+  { sb.append( yytext() ); }

  /* escape sequences */
  "\\b"                          { sb.append( '\b' ); }
  "\\t"                          { sb.append( '\t' ); }
  "\\n"                          { sb.append( '\n' ); }
  "\\f"                          { sb.append( '\f' ); }
  "\\r"                          { sb.append( '\r' ); }
  "\\\""                         { sb.append( '\"' ); }
  "\\\\"                         { sb.append( '\\' ); }
  \\.                            { sb.append( yytext() ); }

  /* error cases */
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

<GRAVE_ACCENT_STRING> {
  "`"                            { yybegin(AFTER_INDENT); return symbol(QUOTED_STRING, sb.toString()); }

  {GraveAccentStringCharacter}+  { sb.append( yytext() ); }

  /* escape sequences */
  "\\b"                          { sb.append( '\b' ); }
  "\\t"                          { sb.append( '\t' ); }
  "\\n"                          { sb.append( '\n' ); }
  "\\f"                          { sb.append( '\f' ); }
  "\\r"                          { sb.append( '\r' ); }
  "\\\""                         { sb.append( '\"' ); }
  "\\\\"                         { sb.append( '\\' ); }
  \\.                            { sb.append( yytext() ); }

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

<UNQUOTED_STRING> {
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
        yybegin(YYINITIAL);
        return symbol(UNQUOTED_STRING, sb.toString());
   }
}

/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
