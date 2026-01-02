import antlr.HtmlCssParser;
import antlr.HtmlCssParserBaseVisitor;
import ast.*;

/**
 * WebVisitor - Visits HTML/CSS/Jinja parse tree and builds AST nodes.
 * This visitor is aligned with the generated HtmlCssParser context classes.
 */
public class WebVisitor extends HtmlCssParserBaseVisitor<Node> {

    @Override
    public Node visitDocument(HtmlCssParser.DocumentContext ctx) {
        ProgramNode program = new ProgramNode(ctx.getStart().getLine());
        if (ctx.htmlDocument() != null) {
            for (HtmlCssParser.HtmlContentContext contentCtx : ctx.htmlDocument().htmlContent()) {
                Node child = visit(contentCtx);
                if (child != null)
                    program.addChild(child);
            }
        }
        return program;
    }

    @Override
    public Node visitRegularElement(HtmlCssParser.RegularElementContext ctx) {
        String tagName = ctx.TAG_NAME(0).getText();
        ElementNode node = new ElementNode(tagName, ctx.getStart().getLine());

        if (ctx.attribute() != null) {
            for (HtmlCssParser.AttributeContext attrCtx : ctx.attribute()) {
                node.addAttribute(attrCtx.getText());
            }
        }

        if (ctx.htmlContent() != null) {
            for (HtmlCssParser.HtmlContentContext contentCtx : ctx.htmlContent()) {
                Node child = visit(contentCtx);
                if (child != null)
                    node.addChild(child);
            }
        }
        return node;
    }

    @Override
    public Node visitSelfClosingElement(HtmlCssParser.SelfClosingElementContext ctx) {
        String tagName = ctx.TAG_NAME().getText();
        SelfClosingTagNode node = new SelfClosingTagNode(tagName, ctx.getStart().getLine());

        if (ctx.attribute() != null) {
            for (HtmlCssParser.AttributeContext attrCtx : ctx.attribute()) {
                node.addAttribute(attrCtx.getText());
            }
        }
        return node;
    }

    @Override
    public Node visitVoidElement(HtmlCssParser.VoidElementContext ctx) {
        String tagName = ctx.TAG_NAME().getText();
        SelfClosingTagNode node = new SelfClosingTagNode(tagName, ctx.getStart().getLine());

        if (ctx.attribute() != null) {
            for (HtmlCssParser.AttributeContext attrCtx : ctx.attribute()) {
                node.addAttribute(attrCtx.getText());
            }
        }
        return node;
    }

    @Override
    public Node visitTextContent(HtmlCssParser.TextContentContext ctx) {
        String text = ctx.getText().trim();
        return new TextNode(text, ctx.getStart().getLine());
    }

    @Override
    public Node visitStyleContent(HtmlCssParser.StyleContentContext ctx) {
        String content = ctx.STYLE_BLOCK() != null ? ctx.STYLE_BLOCK().getText() : "";
        return new StyleBlockNode(content, ctx.getStart().getLine());
    }

    @Override
    public Node visitJinjaExprNode(HtmlCssParser.JinjaExprNodeContext ctx) {
        // Jinja expression like {{ variable }}
        if (ctx.jinjaVariable() != null) {
            String varName = ctx.jinjaVariable().getText();
            return new JinjaNode("JinjaVariable", varName, ctx.getStart().getLine());
        }
        return null;
    }

    @Override
    public Node visitJinjaVarNode(HtmlCssParser.JinjaVarNodeContext ctx) {
        // Jinja variable identifier like user.name
        StringBuilder varName = new StringBuilder();
        for (int i = 0; i < ctx.JINJA_IDENTIFIER().size(); i++) {
            if (i > 0)
                varName.append(".");
            varName.append(ctx.JINJA_IDENTIFIER(i).getText());
        }
        return new JinjaNode("JinjaVariable", varName.toString(), ctx.getStart().getLine());
    }

    @Override
    public Node visitForLoop(HtmlCssParser.ForLoopContext ctx) {
        String item = ctx.JINJA_IDENTIFIER(0).getText();
        String list = ctx.JINJA_IDENTIFIER(1).getText();
        String loopExpr = item + " in " + list;

        JinjaNode forNode = new JinjaNode("JinjaForLoop", loopExpr, ctx.getStart().getLine());

        if (ctx.htmlContent() != null) {
            for (HtmlCssParser.HtmlContentContext contentCtx : ctx.htmlContent()) {
                Node child = visit(contentCtx);
                if (child != null)
                    forNode.addChild(child);
            }
        }
        return forNode;
    }

    @Override
    public Node visitIfBlock(HtmlCssParser.IfBlockContext ctx) {
        // Extract condition from the JINJA_IDENTIFIER
        String condition = ctx.JINJA_IDENTIFIER() != null ? ctx.JINJA_IDENTIFIER().getText() : "unknown";

        JinjaIfNode ifNode = new JinjaIfNode(condition, ctx.getStart().getLine());

        if (ctx.htmlContent() != null) {
            for (HtmlCssParser.HtmlContentContext contentCtx : ctx.htmlContent()) {
                Node child = visit(contentCtx);
                if (child != null)
                    ifNode.addChild(child);
            }
        }
        return ifNode;
    }
}