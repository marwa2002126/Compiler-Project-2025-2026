package ast;


public class ProgramNode extends Node {

    public ProgramNode(int lineNumber) {
        super("Program", lineNumber);
    }

    @Override
    public void printNode(String indent) {
        System.out.println(indent + "Node Name: " + nodeName + " (Line: " + lineNumber + ")");
        for (Node child : children) {
            child.printNode(indent + "  ");
        }
    }
}
