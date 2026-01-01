parser grammar PythonFlaskParser;

options {
    tokenVocab = PythonFlaskLexer;
}

@header {
package antlr;
}

program
    : NEWLINE_TOKEN* (statement | NEWLINE_TOKEN)* EOF
    ;

statement
    : simpleStatement NEWLINE_TOKEN+      #SimpleStmt
    | compoundStatement NEWLINE_TOKEN* #CompoundStmt
    ;

simpleStatement
    : importStatement          #ImportStmt
    | assignmentStatement      #AssignStmt
    | returnStatement          #ReturnStmt
    | passStatement            #PassStmt
    | breakStatement           #BreakStmt
    | continueStatement        #ContinueStmt
    | expressionStatement      #ExprStmt
    ;

compoundStatement
    : decorator* DEF IDENTIFIER parameters COLON block    #FuncDefStmt
    | IF expression COLON block (ELIF expression COLON block)* (ELSE COLON block)? #IfStmt
    | FOR IDENTIFIER IN expression COLON block (ELSE COLON block)?  #ForStmt
    | WHILE expression COLON block (ELSE COLON block)?    #WhileStmt
    | TRY COLON block (EXCEPT (IDENTIFIER (AS IDENTIFIER)?)? COLON block)* (FINALLY COLON block)?  #TryStmt
    ;

block
    : NEWLINE_TOKEN+ INDENT statement+ DEDENT
    ;

importStatement
    : FROM dotName IMPORT importList             #FromImport
    | IMPORT dotName (AS IDENTIFIER)?            #SimpleImport
    | IMPORT dotName (COMMA dotName)*            #MultiImport
    ;

dotName : IDENTIFIER (DOT IDENTIFIER)* ;

importList
    : STAR                                        #ImportAll
    | importItem (COMMA importItem)* #ImportItems
    ;

importItem : IDENTIFIER (AS IDENTIFIER)? ;

assignmentStatement
    : target EQUAL expression    #BasicAssign
    ;

target
    : IDENTIFIER                                  #IdTarget
    | postfixExpr DOT IDENTIFIER                  #MemberTarget
    | postfixExpr LBRACKET expression RBRACKET    #IndexTarget
    ;

returnStatement : RETURN expression?  #Return ;
passStatement   : PASS;
breakStatement  : BREAK;
continueStatement : CONTINUE;
expressionStatement : expression ;

decorator
    : AT dotName (LPAREN arguments? RPAREN)? NEWLINE_TOKEN+
    ;

// Fixed: parameters now properly wrapped in parentheses and optional
parameters
    : LPAREN (parameter (COMMA parameter)*)? RPAREN
    ;

parameter
    : IDENTIFIER (EQUAL expression)?
    ;

expression
    : orExpr
    ;

orExpr : andExpr (OR andExpr)* ;
andExpr : notExpr (AND notExpr)* ;
notExpr : NOT notExpr | comparison ;
comparison : addExpr (compOp addExpr)* ;
compOp : LT | GT | LTE | GTE | DOUBLE_EQUAL | NOT_EQUAL | IN | IS | NOT IN | IS NOT ;
addExpr : mulExpr ((PLUS | MINUS) mulExpr)* ;
mulExpr : unaryExpr ((STAR | SLASH | DOUBLE_SLASH | PERCENT) unaryExpr)* ;
unaryExpr : (PLUS | MINUS | TILDE) unaryExpr | powerExpr ;
powerExpr : postfixExpr (DOUBLE_STAR unaryExpr)? ;

postfixExpr
    : primary postfixOp*
    ;

postfixOp
    : DOT IDENTIFIER                              #MemberAccess
    | LPAREN arguments? RPAREN                    #FunctionCall
    | LBRACKET expression RBRACKET                #IndexAccess
    ;

primary
    : IDENTIFIER                                  #IdPrimary
    | NUMBER                                      #NumPrimary
    | STRING+                                     #StrPrimary
    | TRUE                                        #TruePrimary
    | FALSE                                       #FalsePrimary
    | NONE                                        #NonePrimary
    | LPAREN expression RPAREN                    #ParenPrimary
    | LPAREN expression (COMMA expression)+ RPAREN  #TuplePrimary
    | LPAREN expression FOR IDENTIFIER IN expression (IF expression)? RPAREN  #GeneratorPrimary
    | LBRACKET (expression (COMMA expression)*)? RBRACKET  #ListPrimary
    | LBRACE (dictEntry (COMMA dictEntry)*)? RBRACE  #DictPrimary
    ;

dictEntry : expression COLON expression ;

listLiteral : LBRACKET (expression (COMMA expression)*)? RBRACKET ;
dictLiteral : LBRACE (dictEntry (COMMA dictEntry)*)? RBRACE ;

arguments : argument (COMMA argument)* ;
argument : (IDENTIFIER EQUAL)? expression ;