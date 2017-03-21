package patterns.visitor.structure;

import patterns.visitor.structure.tools.ExpressionVisitor;

/**
 * Created by hadar on 21/03/2017.
 */
public class IntExp extends Expression {
    public int value;

    protected void accept(ExpressionVisitor v) {
        v.visitIntExpression(this);
    }
}
