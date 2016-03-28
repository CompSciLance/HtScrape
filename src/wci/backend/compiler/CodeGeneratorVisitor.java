package wci.backend.compiler;

import java.util.ArrayList;
import java.util.HashMap;

import wci.frontend.*;
import wci.intermediate.*;
import wci.intermediate.symtabimpl.Predefined;
import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;

public class CodeGeneratorVisitor
    extends HtScrapeVisitorAdapter
    implements HtScrapeTreeConstants
{
	private final String RTLPrintFullPath = "wci/backend/JSOUP/printFullTable(Ljava/lang/String;I)V";
	private final String RTLPrintDataPath = "wci/backend/JSOUP/printData(Ljava/lang/String;III)V";
	private final String RTLGetDataPath = "wci/backend/JSOUP/getData(Ljava/lang/String;III)Ljava/lang/String;";
	private int label = 1;
	
    public Object visit(ASTSimpleAssignment node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode variableNode   = (SimpleNode) node.jjtGetChild(0);
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(1);
        
        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);
        TypeSpec expressionType = expressionNode.getTypeSpec();

        // Get the assignment target type.
        TypeSpec targetType = node.getTypeSpec();

        // Convert an integer value to float if necessary.
        if ((targetType == Predefined.realType) &&
            (expressionType == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        if(type == Predefined.stringType)
        {
        	CodeGenerator.objectFile.println("    astore " + (id.getIndex()+1));
        }
        else
        {
        	String typeCode = type == Predefined.integerType ? "I" : "F";
        	// Emit the appropriate store instruction.
        	CodeGenerator.objectFile.println("    putstatic " + programName +
        		                         "/" + fieldName + " " + typeCode);
        }
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTComplexAssignment node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode variableNode   = (SimpleNode) node.jjtGetChild(0);
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(1);

        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);
        TypeSpec expressionType = expressionNode.getTypeSpec();

        // Get the assignment target type.
        TypeSpec targetType = node.getTypeSpec();

        // Convert an integer value to float if necessary.
        if ((targetType == Predefined.realType) &&
            (expressionType == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        if(type == Predefined.stringType)
        {
        	CodeGenerator.objectFile.println("    astore " + (id.getIndex()+1));
        }
        else
        {
        	String typeCode = type == Predefined.integerType ? "I" : "F";
        	// Emit the appropriate store instruction.
        	CodeGenerator.objectFile.println("    putstatic " + programName +
        		                         "/" + fieldName + " " + typeCode);
        }
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTIntDeclaration node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode variableNode   = (SimpleNode) node.jjtGetChild(0);
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(1);

        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);

        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
        String fieldName = id.getName();
        String typeCode = "I";

        // Emit the appropriate store instruction.
        CodeGenerator.objectFile.println("    putstatic " + programName +
        		                         "/" + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTNumberDeclaration node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode variableNode   = (SimpleNode) node.jjtGetChild(0);
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(1);

        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);
        TypeSpec expressionType = expressionNode.getTypeSpec();

        // Get the assignment target type.
        TypeSpec targetType = node.getTypeSpec();

        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        String typeCode = "F";

        // Emit the appropriate store instruction.
        CodeGenerator.objectFile.println("    putstatic " + programName +
        		                         "/" + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTStringDeclaration node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode variableNode   = (SimpleNode) node.jjtGetChild(0);
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(1);

        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);
        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);

        // Emit the appropriate store instruction.
        CodeGenerator.objectFile.println("    astore " + (id.getIndex()+1));
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTvariable node, Object data)
    {
    	String programName = (String) data;
        SymTabEntry id = (SymTabEntry) node.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        String typeCode;
        if(type == Predefined.integerType)
        	typeCode =  "I";
        else if(type == Predefined.realType)
        	typeCode = "F";
        else if(type == Predefined.stringType)
        	typeCode = "";
        else
        	typeCode = "";
        if(type==Predefined.stringType)
        	CodeGenerator.objectFile.println("    aload "+(id.getIndex()+1));
        // Emit the appropriate load instruction.
        else
        	CodeGenerator.objectFile.println("    getstatic " + programName +
                "/" + fieldName + " " + typeCode);
        
        
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTintegerConstant node, Object data)
    {
        int value = (int) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTnumberConstant node, Object data)
    {
        float value = (float) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTstringConstant node, Object data)
    {
        String value = (String) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTPrintStatement node, Object data)
    {
        String value = (String) node.getAttribute(VALUE);
        SimpleNode variableNode   = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
        TypeSpec type = id.getTypeSpec();
        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    getstatic     java/lang/System/out Ljava/io/PrintStream;");
        //emit call to load parameter
        variableNode.jjtAccept(this, data);
        //if the parameter type is and int or float, call String.ValueOf to convert to string
        if(type==Predefined.integerType)
        	CodeGenerator.objectFile.println("    invokestatic     java/lang/String.valueOf(I)Ljava/lang/String;");
        else if (type==Predefined.realType)
        	CodeGenerator.objectFile.println("    invokestatic     java/lang/String.valueOf(F)Ljava/lang/String;");
        //emit call to println
        CodeGenerator.objectFile.println("    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V");
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTPrintFullTableStatement node, Object data)
    {
        SimpleNode variable1Node   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(0);
        SimpleNode variable2Node   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(1);
        
        // Express the parameters.
        variable1Node.jjtAccept(this, data);
        variable2Node.jjtAccept(this, data);
        //emit call to RTL
        CodeGenerator.objectFile.println("    invokestatic "+RTLPrintFullPath);
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTPrintDataStatement node, Object data)
    {
        SimpleNode variable1Node   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(0);
        SimpleNode variable2Node   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(1);
        SimpleNode variable3Node   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(2);
        SimpleNode variable4Node   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(3);
        
        variable1Node.jjtAccept(this, data);
        variable2Node.jjtAccept(this, data);
        variable3Node.jjtAccept(this, data);
        variable4Node.jjtAccept(this, data);
        
        CodeGenerator.objectFile.println("    invokestatic "+RTLPrintDataPath);
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTGetDataStatement node, Object data)
    {
    	SimpleNode storageNode   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(0);
    	SimpleNode variable1Node   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(1);
        SimpleNode variable2Node   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(2);
        SimpleNode variable3Node   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(3);
        SimpleNode variable4Node   = (SimpleNode) node.jjtGetChild(0).jjtGetChild(4);
        
        variable1Node.jjtAccept(this, data);
        variable2Node.jjtAccept(this, data);
        variable3Node.jjtAccept(this, data);
        variable4Node.jjtAccept(this, data);
        
        CodeGenerator.objectFile.println("    invokestatic "+RTLGetDataPath);
        
        SymTabEntry id = (SymTabEntry) storageNode.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        if(type == Predefined.stringType)
        {
        	CodeGenerator.objectFile.println("    astore " + (id.getIndex()+1));
        }
        
        CodeGenerator.objectFile.flush();

        return data;
    }
    
    public Object visit(ASTWhileStatement node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(0);
        SimpleNode statementNode = (SimpleNode) node.jjtGetChild(1);
        int startLabel = label++;
        CodeGenerator.objectFile.println("L"+startLabel+":");
        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);

        //emit goto code
        CodeGenerator.objectFile.println("    goto  L" + (label+1));
        CodeGenerator.objectFile.println("L"+(label++)+":");
        //emit the statement
        statementNode.jjtAccept(this, data);
        CodeGenerator.objectFile.println("    goto  L" + startLabel);
        CodeGenerator.objectFile.println("L"+(label)+":");
        
        return data;
    }
    
    public Object visit(ASTIfStatement node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(0);
        SimpleNode statementNode = (SimpleNode) node.jjtGetChild(1);
        SimpleNode elseNode = (SimpleNode) node.jjtGetChild(node.jjtGetNumChildren()-1);
        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);
        //emit goto code
        CodeGenerator.objectFile.println("    iconst_0");
        CodeGenerator.objectFile.println("    goto  L" + (label+1));
        CodeGenerator.objectFile.println("L"+(label++)+":");
        CodeGenerator.objectFile.println("    iconst_1");
        CodeGenerator.objectFile.println("L"+label+":");
        CodeGenerator.objectFile.println("    ifeq   L"+(++label));
        //emit the statement
        statementNode.jjtAccept(this, data);
        CodeGenerator.objectFile.println("    goto  L" + (label+1));
        CodeGenerator.objectFile.println("L"+(label++)+":");
      //check for and handle ELSE statement
        if(elseNode.getClass().equals(ASTElseStatement.class))
        	elseNode.jjtAccept(this, data);
        CodeGenerator.objectFile.println("L"+(label++)+":");
        return data;
    }
    
    public Object visit(ASTExpression node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode operatorNode = (SimpleNode) node.jjtGetChild(0);

        // Emit code for the operator.
        operatorNode.jjtAccept(this, data);

        return data;
    }
    
    public Object visit(ASTOperator node, Object data)
    {
    	SimpleNode operatorNode = (SimpleNode) node.jjtGetChild(1);
    	if(operatorNode.getClass().equals(ASTexpr_operator.class))
    		handleIfStatement(node, data);
    	else if(operatorNode.getClass().equals(ASTarith_operator.class))
    		handleArithmeticStatement(node, data);

        return data;
    }
    
    public Object handleIfStatement(ASTOperator node, Object data)
    {
    	String programName        = (String) data;
        SimpleNode operandNode = (SimpleNode) node.jjtGetChild(0);
        SimpleNode operand1Node = (SimpleNode) operandNode.jjtGetChild(0);
        SimpleNode operatorNode = (SimpleNode) node.jjtGetChild(1);
        SimpleNode operand2Node = (SimpleNode) node.jjtGetChild(2);
        SimpleNode elseNode = (SimpleNode) node.jjtGetChild(node.jjtGetNumChildren()-1);
        //emit operand1 code
        operand1Node.jjtAccept(this, data);
      //emit operand2 code
        operand2Node.jjtAccept(this, data);
        //get variable information
        SymTabEntry id = (SymTabEntry) operand1Node.getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        String typeCode = type == Predefined.integerType ? "i" : "f";
        
        //if code  
        String opName = String.valueOf(operatorNode.getAttribute(ID));
        String operatorCode = "";
        if(opName.equals("<"))
        	operatorCode = "cmplt";
        else if(opName.equals(">"))
        	operatorCode = "cmpgt";
        else if(opName.equals("=="))
        	operatorCode = "cmpeq";
        else if(opName.equals(">="))
        	operatorCode = "cmpge";
        else if(opName.equals("<="))
        	operatorCode = "cmple";
        else if(opName.equals("!="))
        	operatorCode = "cmpne";
     // Emit the appropriate load instruction.
        CodeGenerator.objectFile.println("    if_" + typeCode + operatorCode+"    L"+label);       
        CodeGenerator.objectFile.flush();
    	
    	return data;
    }
    
    public Object handleArithmeticStatement(ASTOperator node, Object data)
    {
    	int kids = node.jjtGetNumChildren();
    	String programName        = (String) data;
        SimpleNode operand1Node = (SimpleNode) node.jjtGetChild(0).jjtGetChild(0);
        SimpleNode operatorNode = (SimpleNode) node.jjtGetChild(1);
        SimpleNode operand2Node = (SimpleNode) node.jjtGetChild(2).jjtGetChild(0);
        //emit operand1 code
        operand1Node.jjtAccept(this, data);
      //emit operand2 code
        operand2Node.jjtAccept(this, data);
        TypeSpec type = operand1Node.getTypeSpec();
        TypeSpec type1 = operand2Node.getTypeSpec();

        String typeCode = type == Predefined.integerType ? "i" : "f";
        String opName = String.valueOf(operatorNode.getAttribute(ID));
        String operatorCode = "";
        if(opName.equals("*"))
        	operatorCode = "mul";
        else if(opName.equals("/"))
        	operatorCode = "div";
        else if(opName.equals("+"))
        	operatorCode = "add";
        else if(opName.equals("-"))
        	operatorCode = "sub";
        CodeGenerator.objectFile.println("    "+typeCode+operatorCode);
        
    	for(int i=3;i<kids;i+=2)
    	{
            operatorNode = (SimpleNode) node.jjtGetChild(i);
            operand2Node = (SimpleNode) node.jjtGetChild(i+1);
          //emit operand2 code
            operand2Node.jjtAccept(this, data);
            type = operand2Node.getTypeSpec();
            typeCode = type == Predefined.integerType ? "i" : "f";
            opName = String.valueOf(operatorNode.getAttribute(ID));
            operatorCode = "";
            if(opName.equals("*"))
            	operatorCode = "mul";
            else if(opName.equals("/"))
            	operatorCode = "div";
            else if(opName.equals("+"))
            	operatorCode = "add";
            else if(opName.equals("-"))
            	operatorCode = "sub";
            CodeGenerator.objectFile.println("    "+typeCode+operatorCode);
    	}
    	return data;
    }
}
