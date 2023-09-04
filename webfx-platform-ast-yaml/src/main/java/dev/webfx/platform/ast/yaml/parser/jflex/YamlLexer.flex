
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
    StringBuilder string = new StringBuilder();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
   

/*
  Macro Declarations
*/
   
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]
Identifier = [A-Za-z_][A-Za-z_0-9]*
StringNoQuoteInvalidCharacter = [\r\n'\"`\\:{},&*#-<>=!%@]
StringNoQuoteCharacter = [^\r\n'\"`\\:{},&*#-<>=!%@]
StringSingleQuoteCharacter = [^\r\n'\\]
StringDoubleQuoteCharacter = [^\r\n\"\\]
StringGraveAccentCharacter = [^\r\n`\\]
Comment = {EndOfLineComment}
EndOfLineComment = "#" {InputCharacter}* {LineTerminator}?
StringNoQuote = {StringNoQuoteCharacter}+
LongLiteral = 0 | [1-9][0-9]*
DoubleLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?
FLit1    = [0-9]+ \. [0-9]*
FLit2    = \. [0-9]+
FLit3    = [0-9]+
Exponent = [eE] [+-]? [0-9]+
True = "y" | "Y" | "yes" | "Yes" | "YES" | "true" | "True" | "TRUE" | "on" | "On" | "ON"
False = "n" | "N" | "no" | "No" | "NO" | "false" | "False" | "FALSE" | "off" | "Off" | "OFF"
EndOfIdentifierCharacter = {StringNoQuoteInvalidCharacter}
%state STRING_SINGLE_QUOTE, STRING_DOUBLE_QUOTE, STRING_GRAVE_ACCENT, STRING_NO_QUOTE_OR_IDENTIFIER, STRING_NO_QUOTE

%%
/* ------------------------Lexical Rules Section---------------------- */
   

<YYINITIAL> {

  /* comments */
    {Comment}                      { /* ignore */ }

  /* separators */
    "{"                            { return symbol(LCURLY); }
    "}"                            { return symbol(RCURLY); }
    "["                            { return symbol(LBRACK); }
    "]"                            { return symbol(RBRACK); }
    ","                            { return symbol(COMMA); }
    ":"                            { return symbol(COLON); }

  /* operators */
    "-"                            { return symbol(MINUS); }

  /* keywords */

  /* internal usage parser tokens */

    {LongLiteral} {EndOfIdentifierCharacter}   { yypushback(1); return symbol(NUMBER, Numbers.parseShortestNumber(yytext())); }
    {DoubleLiteral} {EndOfIdentifierCharacter} { yypushback(1); return symbol(NUMBER, Double.valueOf(yytext())); }

  /* boolean literals */
    {True} {EndOfIdentifierCharacter}  { yypushback(1); return symbol(BOOLEAN, Boolean.TRUE); }
    {False} {EndOfIdentifierCharacter} { yypushback(1); return symbol(BOOLEAN, Boolean.FALSE); }

  /* null literal */
    "null" {EndOfIdentifierCharacter}  { yypushback(1); return symbol(NULL); }

  /* Identifier */
    {Identifier} {EndOfIdentifierCharacter}  { yypushback(1); return symbol(IDENTIFIER, yytext()); }

  /* whitespace */
    {WhiteSpace}                   { /* ignore */ }

  /* string literal */
    "'"                            { yybegin(STRING_SINGLE_QUOTE); string.setLength(0); }
    \"                             { yybegin(STRING_DOUBLE_QUOTE); string.setLength(0); }
    "`"                            { yybegin(STRING_GRAVE_ACCENT); string.setLength(0); }
    {StringNoQuoteCharacter}       { yypushback(1); yybegin(STRING_NO_QUOTE); string.setLength(0); }

}

<STRING_SINGLE_QUOTE> {
  "'"                            { yybegin(YYINITIAL); return symbol(STRING, string.toString()); }

  {StringSingleQuoteCharacter}+  { string.append( yytext() ); }

  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\\\"                         { string.append( '\\' ); }
  \\.                            { string.append( yytext() ); }

  /* error cases */
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

<STRING_DOUBLE_QUOTE> {
  \"                             { yybegin(YYINITIAL); return symbol(STRING, string.toString()); }

  {StringDoubleQuoteCharacter}+  { string.append( yytext() ); }

  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\\\"                         { string.append( '\\' ); }
  \\.                            { string.append( yytext() ); }

  /* error cases */
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

<STRING_GRAVE_ACCENT> {
  "`"                            { yybegin(YYINITIAL); return symbol(STRING, string.toString()); }

  {StringGraveAccentCharacter}+  { string.append( yytext() ); }

  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\\\"                         { string.append( '\\' ); }
  \\.                            { string.append( yytext() ); }

  /* error cases */
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

<STRING_NO_QUOTE> {
  {StringNoQuoteInvalidCharacter} { yypushback(1); yybegin(YYINITIAL); return symbol(STRING, string.toString()); }

  {StringNoQuoteCharacter}        { string.append( yytext() ); }
  {WhiteSpace}                    { string.append( yytext() ); }

  /* error cases */
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
