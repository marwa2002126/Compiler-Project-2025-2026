package ast;

public class StyleBlockNode extends Node {
    private String cssContent;

    public StyleBlockNode(String cssContent, int lineNumber) {
        super("StyleBlock", lineNumber);
        this.cssContent = cssContent;
    }

    @Override
    public void printNode(String indent) {
        System.out.println(indent + "Node Name: " + nodeName + " (Line: " + lineNumber + ")");
        // Display truncated CSS content if too long
        if (cssContent != null && !cssContent.trim().isEmpty()) {
            String displayContent = cssContent.length() > 100 
                ? cssContent.substring(0, 100) + "..." 
                : cssContent;
            System.out.println(indent + "  CSS Content: " + displayContent.replace("\n", " ").trim());
        }
    }
}
