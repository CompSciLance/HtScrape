/* Generated By:JJTree: Do not edit this line. ASTUnaryExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wci.frontend;

public
class ASTUnaryExpression extends SimpleNode {
  public ASTUnaryExpression(int id) {
    super(id);
  }

  public ASTUnaryExpression(HtScrape p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(HtScrapeVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=fd6bfe73c6590892be4661fbd0b4e5fa (do not edit this line) */
