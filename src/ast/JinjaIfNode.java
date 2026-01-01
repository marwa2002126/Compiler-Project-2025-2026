package ast;

public class JinjaIfNode extends Node {
    private String condition;

    public JinjaIfNode(String condition, int lineNumber) {
        super("JinjaIfStatement", lineNumber);
        this.condition = condition;
    }

    @Override
    public void printNode(String indent) {
        System.out.println(
                indent + "Node Name: " + nodeName + " (Condition: " + condition + ") (Line: " + lineNumber + ")");
        for (Node child : children) {
            child.printNode(indent + "  ");
        }
    }
}
