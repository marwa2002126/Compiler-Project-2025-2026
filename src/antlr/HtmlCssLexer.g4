lexer grammar HtmlCssLexer;

@header { package antlr; }

// DOCTYPE declaration
DOCTYPE_DECL : '<!DOCTYPE' [ \t]+ 'html' [ \t]* '>';

// Style block - handled as a special token
STYLE_OPEN : '<style' -> pushMode(STYLE_MODE);

// Standard HTML tag opening
TAG_OPEN : '<' -> pushMode(TAG_MODE);

// Jinja template delimiters
JINJA_BLOCK_OPEN : '{%' [ \t]* -> pushMode(JINJA_MODE);
JINJA_OPEN       : '{{' [ \t]* -> pushMode(JINJA_MODE);

// Regular HTML text
HTML_TEXT : ~[<{]+ ;

// Mode for HTML tags
mode TAG_MODE;

TAG_CLOSE       : '>' -> popMode;
TAG_SLASH_CLOSE : '/>' -> popMode;
TAG_SLASH       : '/';
TAG_EQUAL       : '=';
TAG_STRING      : ('"' (~["])* '"') | ('\'' (~['])* '\'');
TAG_NAME        : [a-zA-Z_][a-zA-Z0-9_-]*;
TAG_WS          : [ \t\r\n]+ -> skip;

// Mode for CSS style blocks
mode STYLE_MODE;

STYLE_CONTENT   : .*? '</style>' -> popMode;

// Mode for Jinja templates
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