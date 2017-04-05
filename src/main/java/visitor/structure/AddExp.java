package visitor.structure;


import visitor.tools.ExpressionVisitor;

/**
 * Defines expressions of Adding type, i.e. "2+3"
 */
public class AddExp extends Expression {
        public Expression e1,e2; // "2","3"
        public void accept(ExpressionVisitor v) {
         v.visitAddExpression(this);
    }
}
