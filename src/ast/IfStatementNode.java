package ast;

public class IfStatementNode extends StatementNode {
    private String condition;

    public IfStatementNode(String condition, int lineNumber) {
        super("IfStatement", lineNumber);
        this.condition = condition;
    }

    @Override
    public void printNode(String indent) {
        System.out.println(indent + "Node Name: " + nodeName + " (Condition: " + condition + ") (Line: " + lineNumber + ")");
        for (Node child : children) {
            child.printNode(indent + "  ");
        }
    }
}
