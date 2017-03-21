package patterns.visitor.structure;

import patterns.visitor.structure.tools.ExpressionVisitor;

/**
 * Created by hadar on 21/03/2017.
 */
public class AddExp extends Expression {
      public Expression e1,e2;

    protected void accept(ExpressionVisitor v) {
        v.visitAddExpression(this);
    }
}
