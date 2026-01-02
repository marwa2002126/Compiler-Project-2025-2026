lexer grammar HtmlCssLexer;

@header { package antlr; }

DOCTYPE_DECL : '<!DOCTYPE' [ \t]+ 'html' [ \t]* '>';

STYLE_OPEN : '<style' -> pushMode(STYLE_MODE);

TAG_OPEN : '<' -> pushMode(TAG_MODE);

JINJA_BLOCK_OPEN : '{%' [ \t]* -> pushMode(JINJA_MODE);
JINJA_OPEN       : '{{' [ \t]* -> pushMode(JINJA_MODE);

HTML_TEXT : ~[<{]+ ;

mode TAG_MODE;

TAG_CLOSE       : '>' -> popMode;
TAG_SLASH_CLOSE : '/>' -> popMode;
TAG_SLASH       : '/';
TAG_EQUAL       : '=';
TAG_STRING      : ('"' (~["])* '"') | ('\'' (~['])* '\'');
TAG_NAME        : [a-zA-Z_][a-zA-Z0-9_-]*;
TAG_WS          : [ \t\r\n]+ -> skip;

mode STYLE_MODE;

STYLE_CONTENT   : .*? '</style>' -> popMode;

mode JINJA_MODE;

JINJA_BLOCK_CLOSE : [ \t]* '%}' -> popMode;
JINJA_CLOSE       : [ \t]* '}}' -> popMode;
JINJA_FOR         : 'for';
JINJA_IN          : 'in';
JINJA_ENDFOR      : 'endfor';
JINJA_IF          : 'if';
JINJA_ELSE        : 'else';
JINJA_ELIF        : 'elif';
JINJA_ENDIF       : 'endif';
JINJA_DOT         : '.';
JINJA_LPAREN      : '(';
JINJA_RPAREN      : ')';
JINJA_COMMA       : ',';
JINJA_PLUS        : '+';
JINJA_STRING      : ('"' (~["])* '"') | ('\'' (~['])* '\'');
JINJA_IDENTIFIER  : [a-zA-Z_][a-zA-Z0-9_]*;
JINJA_EQUAL       : '=';
JINJA_WS          : [ \t]+ -> skip;