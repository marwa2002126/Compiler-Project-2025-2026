lexer grammar PythonFlaskLexer;

@header {
package antlr;
import java.util.*;
import org.antlr.v4.runtime.misc.Pair;
}

@members {
    private Deque<Integer> indentStack = new ArrayDeque<>();
    private Deque<Token> pendingTokens = new ArrayDeque<>();
    private int bracketDepth = 0;

    {
        indentStack.push(0);
    }

    @Override
    public Token nextToken() {
        if (!pendingTokens.isEmpty()) {
            return pendingTokens.poll();
        }

        Token next = super.nextToken();

        // Skip WS tokens - they are on hidden channel and should not reach parser
        if (next.getType() == WS) {
            return nextToken();
        }

        if (next.getType() == LPAREN || next.getType() == LBRACKET || next.getType() == LBRACE) {
            bracketDepth++;
            return next;
        }
        if (next.getType() == RPAREN || next.getType() == RBRACKET || next.getType() == RBRACE) {
            if (bracketDepth > 0) bracketDepth--;
            return next;
        }

        if (next.getType() == NEWLINE_TOKEN && bracketDepth > 0) {
            return nextToken();
        }

        if (next.getType() == NEWLINE_TOKEN) {
            return handleNewline(next);
        }

        if (next.getType() == EOF) {
            return handleEOF(next);
        }

        return next;
    }

    private Token handleNewline(Token newlineToken) {
        // Calculate indent from trailing whitespace in the NEWLINE_TOKEN itself
        int indent = calculateIndent(newlineToken.getText());
        Token peek = super.nextToken();

        // Skip any separate WS tokens (shouldn't exist but just in case)
        while (peek.getType() == WS) {
            String ws = peek.getText();
            for (char c : ws.toCharArray()) {
                if (c == ' ') indent++;
                else if (c == '\t') indent += 4;
            }
            peek = super.nextToken();
        }

        // Skip consecutive newlines, taking indent from the last one
        while (peek.getType() == NEWLINE_TOKEN) {
            pendingTokens.add(newlineToken);
            newlineToken = peek;
            indent = calculateIndent(newlineToken.getText()); // Reset indent from new token
            peek = super.nextToken();

            // Consume WS after consecutive newline
            while (peek.getType() == WS) {
                String ws = peek.getText();
                for (char c : ws.toCharArray()) {
                    if (c == ' ') indent++;
                    else if (c == '\t') indent += 4;
                }
                peek = super.nextToken();
            }
        }

        if (peek.getType() == EOF) {
            pendingTokens.add(newlineToken);
            while (indentStack.size() > 1) {
                indentStack.pop();
                pendingTokens.add(createToken(DEDENT, "<DEDENT>", newlineToken));
            }
            pendingTokens.add(peek);
            return pendingTokens.poll();
        }

        // Handle top-level definitions - close all indents when returning to column 0
        if (peek.getType() == AT || peek.getType() == DEF || peek.getType() == CLASS ||
            peek.getType() == IF || peek.getType() == FOR || peek.getType() == WHILE ||
            peek.getType() == TRY || peek.getType() == IDENTIFIER) {

            if (indent == 0 && indentStack.size() > 1) {
                pendingTokens.add(newlineToken);
                while (indentStack.size() > 1) {
                    indentStack.pop();
                    pendingTokens.add(createToken(DEDENT, "<DEDENT>", newlineToken));
                }
                pendingTokens.add(peek);
                return pendingTokens.poll();
            }
        }

        int currentIndent = indentStack.peek();

        pendingTokens.add(newlineToken);

        if (indent > currentIndent) {
            indentStack.push(indent);
            pendingTokens.add(createToken(INDENT, "<INDENT>", newlineToken));
        } else if (indent < currentIndent) {
            while (!indentStack.isEmpty() && indentStack.peek() > indent) {
                indentStack.pop();
                pendingTokens.add(createToken(DEDENT, "<DEDENT>", newlineToken));
            }
        }

        pendingTokens.add(peek);
        return pendingTokens.poll();
    }

    private int calculateIndent(String text) {
        int indent = 0;
        // Find the last newline character and count spaces/tabs after it
        int lastNewline = Math.max(text.lastIndexOf('\n'), text.lastIndexOf('\r'));
        if (lastNewline >= 0) {
            for (int i = lastNewline + 1; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c == ' ') indent++;
                else if (c == '\t') indent += 4;
            }
        }
        return indent;
    }

    private Token handleEOF(Token eofToken) {
        // Add a synthetic NEWLINE_TOKEN before DEDENTs if we need to close indent levels
        if (indentStack.size() > 1) {
            pendingTokens.add(createToken(NEWLINE_TOKEN, "\n", eofToken));
        }
        while (indentStack.size() > 1) {
            indentStack.pop();
            pendingTokens.add(createToken(DEDENT, "<DEDENT>", eofToken));
        }
        pendingTokens.add(eofToken);
        return pendingTokens.poll();
    }

    private Token createToken(int type, String text, Token ref) {
        CommonToken token = new CommonToken(
            new Pair<TokenSource, CharStream>(this, this.getInputStream()),
            type,
            DEFAULT_TOKEN_CHANNEL,
            ref.getStartIndex(),
            ref.getStopIndex()
        );
        token.setText(text);
        token.setLine(ref.getLine());
        token.setCharPositionInLine(ref.getCharPositionInLine());
        return token;
    }
}

INDENT :  'INDENT_NEVER_MATCH' {false}?  ;
DEDENT : 'DEDENT_NEVER_MATCH' {false}? ;

FROM            : 'from';
IMPORT          : 'import';
AS              : 'as';
DEF             : 'def';
CLASS           : 'class';
IF              : 'if';
ELIF            : 'elif';
ELSE            : 'else';
FOR             : 'for';
WHILE           : 'while';
IN              : 'in';
RETURN          : 'return';
AND             : 'and';
OR              : 'or';
NOT             : 'not';
TRUE            : 'True';
FALSE           : 'False';
NONE            : 'None';
PASS            : 'pass';
BREAK           : 'break';
CONTINUE        : 'continue';
LAMBDA          : 'lambda';
TRY             : 'try';
EXCEPT          : 'except';
FINALLY         : 'finally';
RAISE           : 'raise';
WITH            : 'with';
GLOBAL          : 'global';
IS              : 'is';

//  Operators
PLUS            : '+';
MINUS           : '-';
STAR            : '*';
DOUBLE_STAR     : '**';
SLASH           : '/';
DOUBLE_SLASH    : '//';
PERCENT         : '%';
AT              : '@';
AMPERSAND       : '&';
PIPE            : '|';
CARET           : '^';
TILDE           : '~';
LT              : '<';
GT              : '>';
LTE             : '<=';
GTE             : '>=';
EQUAL           : '=';
DOUBLE_EQUAL    : '==';
NOT_EQUAL       : '!=';
PLUS_EQUAL      : '+=';
MINUS_EQUAL     : '-=';
STAR_EQUAL      : '*=';
SLASH_EQUAL     : '/=';
ARROW           : '->';
LEFT_SHIFT      : '<<';
RIGHT_SHIFT     : '>>';

LPAREN          : '(';
RPAREN          : ')';
LBRACKET        : '[';
RBRACKET        : ']';
LBRACE          : '{';
RBRACE          : '}';
COMMA           : ',';
COLON           : ':';
SEMICOLON       : ';';
DOT             : '.';


STRING
    : '"' (~["\\\r\n] | '\\' .)* '"'
    | '\'' (~['\\\r\n] | '\\' .)* '\''
    | '"""' .*? '"""'
    | '\'\'\'' .*? '\'\'\''
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)?
    | '.' [0-9]+
    ;


IDENTIFIER
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;


NEWLINE_TOKEN
    : ('\r'? '\n' | '\r')
    ;


WS
    : [ 	]+ -> channel(HIDDEN)
    ;

COMMENT
    : '#' ~[\r\n]* -> skip
    ;


LINE_CONTINUATION
    : '\\' '\r'? '\n' -> skip
    ;