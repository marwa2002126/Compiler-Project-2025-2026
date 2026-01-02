parser grammar HtmlCssParser;

options { tokenVocab = HtmlCssLexer; }

@header { package antlr; }

document
    : htmlDocument EOF
    ;

htmlDocument
    : DOCTYPE_DECL?  htmlContent*
    ;

htmlContent
    : element
    | HTML_TEXT
    | STYLE_BLOCK
    | jinjaExpression
    | jinjaBlock
    ;

element
    : TAG_OPEN TAG_NAME attribute* TAG_CLOSE htmlContent* TAG_OPEN TAG_SLASH TAG_NAME TAG_CLOSE   #RegularElement
    | TAG_OPEN TAG_NAME attribute* TAG_SLASH_CLOSE                                                #SelfClosingElement
    | TAG_OPEN TAG_NAME attribute* TAG_CLOSE                                                      #VoidElement
    ;

attribute
    : TAG_NAME (TAG_EQUAL TAG_STRING)?
    ;

jinjaExpression
    : JINJA_OPEN jinjaVariable JINJA_CLOSE
    ;

jinjaVariable
    :  JINJA_IDENTIFIER (JINJA_DOT JINJA_IDENTIFIER)*
    ;

jinjaBlock
    : jinjaForLoop
    | jinjaIfBlock
    ;

jinjaForLoop
    :  JINJA_BLOCK_OPEN JINJA_FOR JINJA_IDENTIFIER JINJA_IN JINJA_IDENTIFIER JINJA_BLOCK_CLOSE
      htmlContent*
      JINJA_BLOCK_OPEN JINJA_ENDFOR JINJA_BLOCK_CLOSE
    ;

jinjaIfBlock
    : JINJA_BLOCK_OPEN JINJA_IF JINJA_IDENTIFIER JINJA_BLOCK_CLOSE
      htmlContent*
      JINJA_BLOCK_OPEN JINJA_ENDIF JINJA_BLOCK_CLOSE
    ;