package ast;

public class AssignmentNode extends StatementNode {
    private String target;
    private String expression;

    public AssignmentNode(String target, String expression, int lineNumber) {
        super("Assignment", lineNumber);
        this.target = target;
        this.expression = expression;
    }

    @Override
    public void printNode(String indent) {
        System.out.println(indent + "Node Name: " + nodeName + " [" + target + " = " + expression + "] (Line: " + lineNumber + ")");
    }
}
