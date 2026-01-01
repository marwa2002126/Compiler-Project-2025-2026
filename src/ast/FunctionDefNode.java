package ast;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefNode extends StatementNode {
    private String functionName;
    private List<String> parameters;
    private List<String> decorators;

    public FunctionDefNode(String functionName, int lineNumber) {
        super("FunctionDefinition", lineNumber);
        this.functionName = functionName;
        this.parameters = new ArrayList<>();
        this.decorators = new ArrayList<>();
    }

    public void addParameter(String param) {
        this.parameters.add(param);
    }

    public void addDecorator(String decorator) {
        this.decorators.add(decorator);
    }

    @Override
    public void printNode(String indent) {
        for (String dec : decorators) {
            System.out.println(indent + "Decorator: " + dec);
        }
        System.out.println(indent + "Node Name: " + nodeName + " [" + functionName + "] (Line: " + lineNumber + ")");
        if (!parameters.isEmpty()) {
            System.out.println(indent + "  Parameters: " + parameters);
        }
        for (Node child : children) {
            child.printNode(indent + "    ");
        }
    }
}
