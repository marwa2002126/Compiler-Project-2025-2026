import antlr.PythonFlaskParser;
import antlr.PythonFlaskParserBaseVisitor;
import ast.*;
import symboltable.SymbolTable;

public class PythonVisitor extends PythonFlaskParserBaseVisitor<Node> {
    private SymbolTable symbolTable = new SymbolTable();

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    @Override
    public Node visitProgram(PythonFlaskParser.ProgramContext ctx) {
        ProgramNode program = new ProgramNode(ctx.getStart().getLine());
        if (ctx.statement() != null) {
            for (PythonFlaskParser.StatementContext stmtCtx : ctx.statement()) {
                Node child = visit(stmtCtx);
                if (child != null)
                    program.addChild(child);
            }
        }
        return program;
    }

    @Override
    public Node visitFuncDefStmt(PythonFlaskParser.FuncDefStmtContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        symbolTable.addSymbol(funcName, "Function/Route");

        FunctionDefNode funcNode = new FunctionDefNode(funcName, ctx.getStart().getLine());

        if (ctx.decorator() != null) {
            for (PythonFlaskParser.DecoratorContext decCtx : ctx.decorator()) {
                funcNode.addDecorator(decCtx.getText().trim());
            }
        }

        if (ctx.parameters() != null && ctx.parameters().parameter() != null) {
            for (PythonFlaskParser.ParameterContext paramCtx : ctx.parameters().parameter()) {
                if (paramCtx.IDENTIFIER() != null) {
                    String paramName = paramCtx.IDENTIFIER().getText();
                    funcNode.addParameter(paramName);
                    symbolTable.addSymbol(paramName, "Parameter");
                }
            }
        }

        if (ctx.block() != null && ctx.block().statement() != null) {
            for (PythonFlaskParser.StatementContext stmtCtx : ctx.block().statement()) {
                Node child = visit(stmtCtx);
                if (child != null)
                    funcNode.addChild(child);
            }
        }
        return funcNode;
    }

    @Override
    public Node visitBasicAssign(PythonFlaskParser.BasicAssignContext ctx) {
        String target = ctx.target().getText();
        String expression = ctx.expression().getText();
        symbolTable.addSymbol(target, "Variable");
        return new AssignmentNode(target, expression, ctx.getStart().getLine());
    }

    @Override
    public Node visitIfStmt(PythonFlaskParser.IfStmtContext ctx) {
        String condition = ctx.expression(0).getText();
        IfStatementNode ifNode = new IfStatementNode(condition, ctx.getStart().getLine());

        if (ctx.block(0) != null && ctx.block(0).statement() != null) {
            for (PythonFlaskParser.StatementContext stmtCtx : ctx.block(0).statement()) {
                Node child = visit(stmtCtx);
                if (child != null)
                    ifNode.addChild(child);
            }
        }
        return ifNode;
    }

    @Override
    public Node visitFromImport(PythonFlaskParser.FromImportContext ctx) {
        String fromModule = ctx.dotName().getText();
        ImportNode importNode = new ImportNode(fromModule, ctx.getStart().getLine());

        if (ctx.importList() != null) {
            String importItems = ctx.importList().getText();
            importNode.addImportItem(importItems);
            symbolTable.addSymbol(importItems, "Imported Module/Item");
        }

        return importNode;
    }

    @Override
    public Node visitSimpleImport(PythonFlaskParser.SimpleImportContext ctx) {
        String moduleName = ctx.dotName().getText();
        ImportNode importNode = new ImportNode(moduleName, ctx.getStart().getLine());
        importNode.addImportItem(moduleName);
        symbolTable.addSymbol(moduleName, "Imported Module");
        return importNode;
    }

    @Override
    public Node visitMultiImport(PythonFlaskParser.MultiImportContext ctx) {
        // Use first module as the main module name
        String firstModule = ctx.dotName(0).getText();
        ImportNode importNode = new ImportNode(firstModule, ctx.getStart().getLine());

        for (PythonFlaskParser.DotNameContext dotNameCtx : ctx.dotName()) {
            String moduleName = dotNameCtx.getText();
            importNode.addImportItem(moduleName);
            symbolTable.addSymbol(moduleName, "Imported Module");
        }

        return importNode;
    }

    @Override
    public Node visitReturn(PythonFlaskParser.ReturnContext ctx) {
        String expression = "";
        if (ctx.expression() != null) {
            expression = ctx.expression().getText();
        }
        return new ReturnNode(expression, ctx.getStart().getLine());
    }
}