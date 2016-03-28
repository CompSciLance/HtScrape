package wci.intermediate;

import wci.frontend.*;
import wci.intermediate.*;
import wci.intermediate.symtabimpl.*;

public class TypeSetterVisitor extends HtScrapeVisitorAdapter
{
    private void setType(SimpleNode node)
    {
        int count = node.jjtGetNumChildren();
        TypeSpec type = Predefined.integerType;
        
        for (int i = 0; (i < count) && (type == Predefined.integerType); ++i) {
            SimpleNode child = (SimpleNode) node.jjtGetChild(i);
            TypeSpec childType = child.getTypeSpec();
            
            if (childType == Predefined.realType) {
                type = Predefined.realType;
            }
            else if (childType == Predefined.booleanType) {
                type = Predefined.booleanType;
            }
            else if (childType == Predefined.charType) {
                type = Predefined.charType;
            }
            else if (childType == Predefined.colorType) {
                type = Predefined.colorType;
            }
            else if (childType == Predefined.fileType) {
                type = Predefined.fileType;
            }
            else if (childType == Predefined.stringType) {
                type = Predefined.stringType;
            }
            else if (childType == Predefined.tableDataType) {
                type = Predefined.tableDataType;
            }
            else if (childType == Predefined.tableType) {
                type = Predefined.tableType;
            }
        }
        
        node.setTypeSpec(type);
    }
    
    public Object visit(ASTIntDeclaration node, Object data)
    {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
    }

    public Object visit(ASTStringDeclaration node, Object data)
    {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
    }
    
    public Object visit(ASTSimpleAssignment node, Object data)
    {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
    }
    
	public Object visit(ASTProgram node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}


	public Object visit(ASTStatement node, Object data) {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	public Object visit(ASTvariable node, Object data) 
	{
		return data;
	}


	public Object visit(ASTnewVariable node, Object data) 
	{
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	public Object visit(ASTComplexAssignment node, Object data) 
	{
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	public Object visit(ASTFileDeclaration node, Object data) 
	{
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
	}

	public Object visit(ASTLoadStatement node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTTableDeclaration node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTGetTableStatement node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTTableDataDeclaration node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTGetTableDataStatement node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTColorDeclaration node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTGetColorStatement node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTMultipleParams node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTPrintStatement node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTCloseStatement node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTIfStatement node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTExpression node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTOperator node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTOperand node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}

	public Object visit(ASTexpr_operator node, Object data) 
	{
	       Object obj = super.visit(node, data);
	        setType(node);
	        return obj;
	}
    
	public Object visit(ASTintegerConstant node, Object data)
	{
		return data;
	}

	public Object visit(ASTstringConstant node, Object data) 
	{
		return data;
	}
}
