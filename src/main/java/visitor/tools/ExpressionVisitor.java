package visitor.tools;

import visitor.structure.AddExp;
import visitor.structure.IntExp;

/**
 * This class represent an abstraction of all classes which would like to manipulate the expressions of Type Expression
 */
public abstract class ExpressionVisitor {
         // The disadvantage of this pattern is that each visitor implementation
         // is coupled with the data structure and obligated to follow it's changes.
        public abstract void visitIntExpression(IntExp e);
        public abstract void visitAddExpression(AddExp e);
}
