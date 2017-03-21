package patterns.visitor.structure.tools;

import patterns.visitor.structure.AddExp;
import patterns.visitor.structure.IntExp;

/**
 * This class represent an abstraction of all classes which would like to manipulate the expressions of Type Expression
 */
public abstract class ExpressionVisitor {
        public abstract void visitIntExpression(IntExp e);
        public abstract void visitAddExpression(AddExp e);
}
