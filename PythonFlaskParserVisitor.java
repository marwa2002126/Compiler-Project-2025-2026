// Generated from PythonFlaskParser.g4 by ANTLR 4.13.2
package antlr;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PythonFlaskParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PythonFlaskParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PythonFlaskParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleStmt}
	 * labeled alternative in {@link PythonFlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStmt(PythonFlaskParser.SimpleStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundStmt}
	 * labeled alternative in {@link PythonFlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStmt(PythonFlaskParser.CompoundStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportStmt}
	 * labeled alternative in {@link PythonFlaskParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStmt(PythonFlaskParser.ImportStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link PythonFlaskParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(PythonFlaskParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link PythonFlaskParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(PythonFlaskParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PassStmt}
	 * labeled alternative in {@link PythonFlaskParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassStmt(PythonFlaskParser.PassStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PythonFlaskParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(PythonFlaskParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link PythonFlaskParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(PythonFlaskParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link PythonFlaskParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(PythonFlaskParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncDefStmt}
	 * labeled alternative in {@link PythonFlaskParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefStmt(PythonFlaskParser.FuncDefStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link PythonFlaskParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(PythonFlaskParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link PythonFlaskParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(PythonFlaskParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link PythonFlaskParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(PythonFlaskParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TryStmt}
	 * labeled alternative in {@link PythonFlaskParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStmt(PythonFlaskParser.TryStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PythonFlaskParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FromImport}
	 * labeled alternative in {@link PythonFlaskParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromImport(PythonFlaskParser.FromImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleImport}
	 * labeled alternative in {@link PythonFlaskParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleImport(PythonFlaskParser.SimpleImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiImport}
	 * labeled alternative in {@link PythonFlaskParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiImport(PythonFlaskParser.MultiImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#dotName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotName(PythonFlaskParser.DotNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportAll}
	 * labeled alternative in {@link PythonFlaskParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportAll(PythonFlaskParser.ImportAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportItems}
	 * labeled alternative in {@link PythonFlaskParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportItems(PythonFlaskParser.ImportItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#importItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportItem(PythonFlaskParser.ImportItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BasicAssign}
	 * labeled alternative in {@link PythonFlaskParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicAssign(PythonFlaskParser.BasicAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdTarget}
	 * labeled alternative in {@link PythonFlaskParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTarget(PythonFlaskParser.IdTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberTarget}
	 * labeled alternative in {@link PythonFlaskParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberTarget(PythonFlaskParser.MemberTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexTarget}
	 * labeled alternative in {@link PythonFlaskParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexTarget(PythonFlaskParser.IndexTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link PythonFlaskParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(PythonFlaskParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#passStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassStatement(PythonFlaskParser.PassStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(PythonFlaskParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(PythonFlaskParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(PythonFlaskParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(PythonFlaskParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(PythonFlaskParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(PythonFlaskParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PythonFlaskParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(PythonFlaskParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(PythonFlaskParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(PythonFlaskParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(PythonFlaskParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(PythonFlaskParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(PythonFlaskParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#mulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(PythonFlaskParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(PythonFlaskParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#powerExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpr(PythonFlaskParser.PowerExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#postfixExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(PythonFlaskParser.PostfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAccess}
	 * labeled alternative in {@link PythonFlaskParser#postfixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccess(PythonFlaskParser.MemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link PythonFlaskParser#postfixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(PythonFlaskParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexAccess}
	 * labeled alternative in {@link PythonFlaskParser#postfixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAccess(PythonFlaskParser.IndexAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdPrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdPrimary(PythonFlaskParser.IdPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumPrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumPrimary(PythonFlaskParser.NumPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrPrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrPrimary(PythonFlaskParser.StrPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TruePrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruePrimary(PythonFlaskParser.TruePrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalsePrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalsePrimary(PythonFlaskParser.FalsePrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NonePrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonePrimary(PythonFlaskParser.NonePrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenPrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenPrimary(PythonFlaskParser.ParenPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TuplePrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuplePrimary(PythonFlaskParser.TuplePrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GeneratorPrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorPrimary(PythonFlaskParser.GeneratorPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListPrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListPrimary(PythonFlaskParser.ListPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DictPrimary}
	 * labeled alternative in {@link PythonFlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictPrimary(PythonFlaskParser.DictPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#dictEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictEntry(PythonFlaskParser.DictEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(PythonFlaskParser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#dictLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictLiteral(PythonFlaskParser.DictLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(PythonFlaskParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(PythonFlaskParser.ArgumentContext ctx);
}