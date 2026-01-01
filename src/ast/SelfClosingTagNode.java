package ast;

import java.util.ArrayList;
import java.util.List;

public class SelfClosingTagNode extends Node {
    private String tagName;
    private List<String> attributes;

    public SelfClosingTagNode(String tagName, int lineNumber) {
        super("SelfClosingTag", lineNumber);
        this.tagName = tagName;
        this.attributes = new ArrayList<>();
    }

    public void addAttribute(String attr) {
        this.attributes.add(attr);
    }

    @Override
    public void printNode(String indent) {
        System.out.println(indent + "Node Name: " + nodeName + " [" + tagName + "] (Line: " + lineNumber + ")");
        if (!attributes.isEmpty()) {
            System.out.println(indent + "  Attributes: " + attributes);
        }
    }
}
