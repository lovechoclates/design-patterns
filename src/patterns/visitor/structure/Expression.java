package patterns.visitor.structure;

import patterns.visitor.structure.tools.ExpressionVisitor;

/**
 * Created by hadar on 21/03/2017.
 */
public abstract class Expression {
    public abstract void accept(ExpressionVisitor v);
}
