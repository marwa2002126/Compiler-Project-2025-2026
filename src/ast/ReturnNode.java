package ast;

public class ReturnNode extends StatementNode {
    private String expression;

    public ReturnNode(String expression, int lineNumber) {
        super("ReturnStatement", lineNumber);
        this.expression = expression;
    }

    @Override
    public void printNode(String indent) {
        System.out.println(indent + "Node Name: " + nodeName + " (Return: " + 
            (expression != null && !expression.isEmpty() ? expression : "None") + 
            ") (Line: " + lineNumber + ")");
    }
}
