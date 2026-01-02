package symboltable;

public class SymbolInfo {
    private String name;
    private String type;
    private int scopeLevel;
    private int lineNumber;

    public SymbolInfo(String name, String type, int scopeLevel, int lineNumber) {
        this.name = name;
        this.type = type;
        this.scopeLevel = scopeLevel;
        this.lineNumber = lineNumber;
    }

    public SymbolInfo(String name, String type, int scopeLevel) {
        this(name, type, scopeLevel, -1);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getScopeLevel() {
        return scopeLevel;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setType(String type) {
        this.type = type;
    }
}
