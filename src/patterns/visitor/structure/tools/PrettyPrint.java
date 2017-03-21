package patterns.visitor.structure.tools;

import patterns.visitor.structure.AddExp;
import patterns.visitor.structure.IntExp;

/**
 * Created by hadar on 21/03/2017.
 */
public class PrettyPrint extends ExpressionVisitor {
    public void visitIntExpression(IntExp e) {
        System.out.print(e.value);
    }

    public void visitAddExpression(AddExp e) {
            e.e1.accept(this);
            System.out.print(" + ");
            e.e2.accept(this);
    }
}
