package ast;

import java.util.ArrayList;
import java.util.List;

public class ImportNode extends StatementNode {
    private String moduleName;
    private List<String> importItems;

    public ImportNode(String moduleName, int lineNumber) {
        super("Import", lineNumber);
        this.moduleName = moduleName;
        this.importItems = new ArrayList<>();
    }

    public void addImportItem(String item) {
        this.importItems.add(item);
    }

    @Override
    public void printNode(String indent) {
        System.out.println(indent + "Node Name: " + nodeName + " [from " + moduleName + "] (Line: " + lineNumber + ")");
        if (!importItems.isEmpty()) {
            System.out.println(indent + "  Imports: " + importItems);
        }
    }
}