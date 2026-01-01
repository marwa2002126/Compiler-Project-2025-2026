package ast;

public abstract class StatementNode extends Node {
    public StatementNode(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }
}
