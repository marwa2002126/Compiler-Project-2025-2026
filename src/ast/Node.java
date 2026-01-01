package ast;

import java.util.ArrayList;
import java.util.List;

/**
 * الكلاس الأساسي لجميع عقد الشجرة (AST)
 * يحقق متطلبات المشروع: OOP، الوراثة، اسم العقدة، ورقم السطر.
 */
public abstract class Node {
    protected String nodeName;
    protected int lineNumber;
    protected List<Node> children;

    public Node(String nodeName, int lineNumber) {
        this.nodeName = nodeName;
        this.lineNumber = lineNumber;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        if (child != null) {
            this.children.add(child);
        }
    }

    public String getNodeName() {
        return nodeName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public List<Node> getChildren() {
        return children;
    }

    public abstract void printNode(String indent);
}
