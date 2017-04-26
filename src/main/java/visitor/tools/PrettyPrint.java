package visitor.tools;

import visitor.structure.AddExp;
import visitor.structure.IntExp;

public class PrettyPrint extends ExpressionVisitor {
    public void visitIntExpression(IntExp e) {
        System.out.print(e.value);
    }

    public void visitAddExpression(AddExp e) {
        System.out.print("(");
        e.left.accept(this);
        System.out.print("+");
        e.right.accept(this);
        System.out.print(")");
    }
}
