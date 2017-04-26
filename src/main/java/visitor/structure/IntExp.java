package visitor.structure;

import visitor.tools.ExpressionVisitor;

/**
 * Integer expression representation
 */
public class IntExp extends Expression {
    public int value;

    public void accept(ExpressionVisitor v) {
        v.visitIntExpression(this);
    }
}
