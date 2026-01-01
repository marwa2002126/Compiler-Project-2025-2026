package ast;

public class TextNode extends Node {
    private String text;

    public TextNode(String text, int lineNumber) {
        super("Text", lineNumber);
        this.text = text;
    }

    @Override
    public void printNode(String indent) {
        if (text != null && !text.trim().isEmpty()) {
            String displayText = text.trim();
            // Truncate very long text for readability
            if (displayText.length() > 80) {
                displayText = displayText.substring(0, 80) + "...";
            }
            System.out.println(
                    indent + "Node Name: " + nodeName + " [\"" + displayText + "\"] (Line: " + lineNumber + ")");
        }
    }
}