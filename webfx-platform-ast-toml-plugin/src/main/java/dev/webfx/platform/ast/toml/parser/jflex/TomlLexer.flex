/* --------------------------Usercode Section------------------------ */

package dev.webfx.platform.ast.toml.parser.jflex;

import java_cup.runtime.*;
import        dev.webfx.platform.ast.toml.parser.javacup.TomlSymbols;
import static dev.webfx.platform.ast.toml.parser.javacup.TomlSymbols.*;
import        dev.webfx.platform.util.Numbers;

%%

/* -----------------Options and Declarations Section----------------- */

%public
%class TomlLexer
%line
%column
%cupsym TomlSymbols
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
Identifier     = [A-Za-z_][A-Za-z_0-9\-]*
Comment        = "#" {InputCharacter}* {LineTerminator}?

// Numbers
Integer        = [0-9]+ | 0x[0-9A-Fa-f]+ | 0o[0-7]+ | 0b[01]+
Float          = {Integer}\.{Integer} | {Integer}\.{Integer}[eE][+-]?{Integer} | {Integer}[eE][+-]?{Integer}

// Strings
BasicString    = \"([^\"\\\n\r]|\\[^\n\r])*\"
LiteralString  = \'[^\']*\'
MultilineBasicString    = \"\"\"([^\"]|\"[^\"]|\"\"[^\"])*\"\"\"
MultilineLiteralString  = \'\'\'([^\']|\'[^\']|\'\'[^\'])*\'\'\'

// Date and Time
FullDate       = [0-9]{4}-[0-9]{2}-[0-9]{2}
FullTime       = [0-9]{2}:[0-9]{2}:[0-9]{2}(\.[0-9]+)?
OffsetDateTime = {FullDate}T{FullTime}(Z|[+-][0-9]{2}:[0-9]{2})
LocalDateTime  = {FullDate}T{FullTime}
LocalDate      = {FullDate}
LocalTime      = {FullTime}

%%
/* ------------------------Lexical Rules Section---------------------- */


<YYINITIAL> {

  /* keywords */
  "true"                         { return symbol(BOOLEAN, Boolean.TRUE); }
  "false"                        { return symbol(BOOLEAN, Boolean.FALSE); }
  "null"                         { return symbol(NULL); }

  /* separators */
  "["                            { return symbol(LBRACK); }
  "]"                            { return symbol(RBRACK); }
  "."                            { return symbol(DOT); }
  ","                            { return symbol(COMMA); }
  "="                            { return symbol(EQUALS); }

  /* numbers */
  {Integer}                      { return symbol(INTEGER, Numbers.parseShortestNumber(yytext())); }
  {Float}                        { return symbol(FLOAT, Double.valueOf(yytext())); }

  /* strings */
  {BasicString}                  { 
                                   String text = yytext();
                                   return symbol(STRING, text.substring(1, text.length() - 1)); 
                                 }
  {LiteralString}                { 
                                   String text = yytext();
                                   return symbol(STRING, text.substring(1, text.length() - 1)); 
                                 }
  {MultilineBasicString}         { 
                                   String text = yytext();
                                   return symbol(STRING, text.substring(3, text.length() - 3)); 
                                 }
  {MultilineLiteralString}       { 
                                   String text = yytext();
                                   return symbol(STRING, text.substring(3, text.length() - 3)); 
                                 }

  /* date and time */
  {OffsetDateTime}               { return symbol(DATETIME, yytext()); }
  {LocalDateTime}                { return symbol(DATETIME, yytext()); }
  {LocalDate}                    { return symbol(DATE, yytext()); }
  {LocalTime}                    { return symbol(TIME, yytext()); }

  /* identifiers */
  {Identifier}                   { return symbol(IDENTIFIER, yytext()); }

  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
}

/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
