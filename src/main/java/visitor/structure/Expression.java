package visitor.structure;

import visitor.tools.ExpressionVisitor;

/**
 * Defines any kind of expression in our data structure
 */
public abstract class Expression {
    public abstract void accept(ExpressionVisitor v);
}
