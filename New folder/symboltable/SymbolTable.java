package symboltable;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Enhanced Symbol Table with scope management
 * Supports nested scopes for functions, blocks, etc.
 */
public class SymbolTable {
    private Stack<Map<String, SymbolInfo>> scopes;
    private int currentLevel;

    public SymbolTable() {
        this.scopes = new Stack<>();
        this.currentLevel = 0;
        // Create global scope
        enterScope();
    }

    /**
     * Enter a new scope (e.g., when entering a function)
     */
    public void enterScope() {
        scopes.push(new HashMap<>());
        if (scopes.size() > 1) {
            currentLevel++;
        }
    }

    /**
     * Exit the current scope (e.g., when leaving a function)
     */
    public void exitScope() {
        if (scopes.size() > 1) {
            scopes.pop();
            currentLevel--;
        }
    }

    /**
     * Add a symbol to the current scope
     */
    public void addSymbol(String name, String type) {
        if (!scopes.isEmpty()) {
            scopes.peek().put(name, new SymbolInfo(name, type, currentLevel));
        }
    }

    /**
     * Add a symbol with line number information
     */
    public void addSymbol(String name, String type, int lineNumber) {
        if (!scopes.isEmpty()) {
            scopes.peek().put(name, new SymbolInfo(name, type, currentLevel, lineNumber));
        }
    }

    /**
     * Check if a symbol exists in any scope
     */
    public boolean containsSymbol(String name) {
        return lookupSymbol(name) != null;
    }

    /**
     * Look up a symbol in current and parent scopes
     */
    public SymbolInfo lookupSymbol(String name) {
        // Search from current scope up to global scope
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Map<String, SymbolInfo> scope = scopes.get(i);
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        return null;
    }

    /**
     * Get symbol from current scope only
     */
    public SymbolInfo getSymbol(String name) {
        if (!scopes.isEmpty() && scopes.peek().containsKey(name)) {
            return scopes.peek().get(name);
        }
        return null;
    }

    /**
     * Update an existing symbol's type
     */
    public void updateSymbol(String name, String newType) {
        SymbolInfo info = lookupSymbol(name);
        if (info != null) {
            info.setType(newType);
        }
    }

    /**
     * Get current scope level
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Print the symbol table with scope organization
     */
    public void printTable() {
        System.out.println("\n=====================================");
        System.out.println("   SYMBOL TABLE (جدول الرموز)       ");
        System.out.println("=====================================");

        if (scopes.isEmpty() || (scopes.size() == 1 && scopes.peek().isEmpty())) {
            System.out.println("الجدول فارغ!");
        } else {
            System.out.printf("%-30s | %-25s | %-15s%n", "Name (الاسم)", "Type (النوع)", "Scope (المجال)");
            System.out.println("--------------------------------------------------------------------------");

            // Collect all symbols and organize by scope level
            Map<Integer, java.util.List<SymbolInfo>> symbolsByLevel = new java.util.TreeMap<>();
            for (Map<String, SymbolInfo> scope : scopes) {
                for (SymbolInfo info : scope.values()) {
                    int level = info.getScopeLevel();
                    if (!symbolsByLevel.containsKey(level)) {
                        symbolsByLevel.put(level, new java.util.ArrayList<>());
                    }
                    symbolsByLevel.get(level).add(info);
                }
            }

            // Print symbols organized by scope level
            for (Map.Entry<Integer, java.util.List<SymbolInfo>> entry : symbolsByLevel.entrySet()) {
                int level = entry.getKey();
                String scopeName = (level == 0) ? "Global (عام)" : "Local Level " + level + " (محلي)";
                System.out.println("\n  [" + scopeName + "]");

                for (SymbolInfo info : entry.getValue()) {
                    System.out.printf("  %-30s | %-25s | %-15s%n",
                            info.getName(),
                            info.getType(),
                            "Level " + info.getScopeLevel());
                }
            }
        }
        System.out.println("=====================================\n");
    }
}
