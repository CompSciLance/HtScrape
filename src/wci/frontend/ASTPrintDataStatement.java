/* Generated By:JJTree: Do not edit this line. ASTPrintDataStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wci.frontend;

public
class ASTPrintDataStatement extends SimpleNode {
  public ASTPrintDataStatement(int id) {
    super(id);
  }

  public ASTPrintDataStatement(HtScrape p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(HtScrapeVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=be89a8753a7a0ac0113bbdfb8d126fdb (do not edit this line) */
