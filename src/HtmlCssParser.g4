parser grammar HtmlCssParser;

options { tokenVocab = HtmlCssLexer; }

@header { package antlr; }

document
    : (DOCTYPE_DECL)? htmlContent* EOF
    ;

htmlContent
    : TAG_OPEN TAG_NAME attribute* TAG_CLOSE htmlContent* TAG_OPEN TAG_SLASH TAG_NAME TAG_CLOSE #RegularElement
    | TAG_OPEN TAG_NAME attribute* TAG_SLASH_CLOSE #SelfClosingElement
    | STYLE_OPEN STYLE_CONTENT #StyleBlock
    | JINJA_BLOCK_OPEN JINJA_FOR jinjaIdentifier JINJA_IN jinjaIdentifier JINJA_BLOCK_CLOSE htmlContent* JINJA_BLOCK_OPEN JINJA_ENDFOR JINJA_BLOCK_CLOSE #ForLoop
    | JINJA_BLOCK_OPEN JINJA_IF jinjaExpression JINJA_BLOCK_CLOSE htmlContent* (JINJA_BLOCK_OPEN JINJA_ELSE JINJA_BLOCK_CLOSE htmlContent*)? JINJA_BLOCK_OPEN JINJA_ENDIF JINJA_BLOCK_CLOSE #IfStatement
    | JINJA_OPEN jinjaExpression JINJA_CLOSE #JinjaVariable
    | HTML_TEXT #TextContent
    | DOCTYPE_DECL #DoctypeDecl
    ;

attribute
    : TAG_NAME (TAG_EQUAL TAG_STRING)? #AttrNode
    ;

jinjaIdentifier
    : JINJA_IDENTIFIER (JINJA_DOT JINJA_IDENTIFIER)*
    ;

jinjaExpression
    : jinjaIdentifier #JinjaIdExpr
    | jinjaIdentifier JINJA_LPAREN jinjaArguments? JINJA_RPAREN #JinjaFunctionCall
    | JINJA_STRING #JinjaStringExpr
    | jinjaExpression JINJA_PLUS jinjaExpression #JinjaPlusExpr
    ;

jinjaArguments
    : jinjaArgument (JINJA_COMMA jinjaArgument)*
    ;

jinjaArgument
    : JINJA_IDENTIFIER JINJA_EQUAL jinjaExpression  #JinjaNamedArg
    | jinjaExpression #JinjaPositionalArg
    ;