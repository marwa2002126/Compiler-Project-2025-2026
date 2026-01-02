// Generated from C:/Users/ebi/IdeaProjects/pythontest/src/HtmlCssParser.g4 by ANTLR 4.13.2
 package antlr; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HtmlCssParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HtmlCssParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HtmlCssParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(HtmlCssParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlCssParser#htmlDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlDocument(HtmlCssParser.HtmlDocumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementContent}
	 * labeled alternative in {@link HtmlCssParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementContent(HtmlCssParser.ElementContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextContent}
	 * labeled alternative in {@link HtmlCssParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextContent(HtmlCssParser.TextContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StyleContent}
	 * labeled alternative in {@link HtmlCssParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleContent(HtmlCssParser.StyleContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaExprContent}
	 * labeled alternative in {@link HtmlCssParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExprContent(HtmlCssParser.JinjaExprContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaBlockContent}
	 * labeled alternative in {@link HtmlCssParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlockContent(HtmlCssParser.JinjaBlockContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RegularElement}
	 * labeled alternative in {@link HtmlCssParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularElement(HtmlCssParser.RegularElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelfClosingElement}
	 * labeled alternative in {@link HtmlCssParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingElement(HtmlCssParser.SelfClosingElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidElement}
	 * labeled alternative in {@link HtmlCssParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidElement(HtmlCssParser.VoidElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrNode}
	 * labeled alternative in {@link HtmlCssParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrNode(HtmlCssParser.AttrNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaExprNode}
	 * labeled alternative in {@link HtmlCssParser#jinjaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExprNode(HtmlCssParser.JinjaExprNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaVarNode}
	 * labeled alternative in {@link HtmlCssParser#jinjaVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaVarNode(HtmlCssParser.JinjaVarNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaForLoopBlock}
	 * labeled alternative in {@link HtmlCssParser#jinjaBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForLoopBlock(HtmlCssParser.JinjaForLoopBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaIfBlockBlock}
	 * labeled alternative in {@link HtmlCssParser#jinjaBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIfBlockBlock(HtmlCssParser.JinjaIfBlockBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link HtmlCssParser#jinjaForLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(HtmlCssParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfBlock}
	 * labeled alternative in {@link HtmlCssParser#jinjaIfBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(HtmlCssParser.IfBlockContext ctx);
}