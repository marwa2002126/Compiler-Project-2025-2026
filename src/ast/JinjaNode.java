package ast;

public class JinjaNode extends Node {
    private String expression;

    public JinjaNode(String type, String expression, int lineNumber) {
        super(type, lineNumber); // النوع قد يكون "JinjaVariable" أو "JinjaFor"
        this.expression = expression;
    }

    @Override
    public void printNode(String indent) {
        System.out.println(indent + "Node Name: " + nodeName + " (" + expression + ") (Line: " + lineNumber + ")");
        for (Node child : children) {
            child.printNode(indent + "  ");
        }
    }
}
