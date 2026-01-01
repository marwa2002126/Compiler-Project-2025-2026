package ast;

public class DoctypeNode extends Node {

    public DoctypeNode(int lineNumber) {
        super("DOCTYPE", lineNumber);
    }

    @Override
    public void printNode(String indent) {
        System.out.println(indent + "Node Name: " + nodeName + " [HTML5] (Line: " + lineNumber + ")");
    }
}
