package wci.intermediate;
import wci.frontend.*;

public class HtScrapeVisitorAdapter implements HtScrapeVisitor{

	@Override
	public Object visit(SimpleNode node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTProgram node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTvariable node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTnewVariable node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTIntDeclaration node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTSimpleAssignment node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTComplexAssignment node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTStringDeclaration node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTMultipleParams node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTPrintStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTIfStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTExpression node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTOperator node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTOperand node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTexpr_operator node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTintegerConstant node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTstringConstant node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTNumberDeclaration node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTnumberConstant node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTArithmeticStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTlookahead node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTlookahead2 node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTPrintFullTableStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTPrintDataStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTWhileStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTarith_operator node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTElseStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTGetDataStatement node, Object data) {
		return node.childrenAccept(this, data);
	}
    
}
