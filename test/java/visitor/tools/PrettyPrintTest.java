package visitor.tools;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import visitor.structure.AddExp;
import visitor.structure.IntExp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


/**
 * Created by hadar on 28/03/2017.
 */
public class PrettyPrintTest {

    private final ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(systemOutContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
    @Test
    public void visitIntExpression() throws Exception {
        //prep
        PrettyPrint prettyPrinter = new PrettyPrint();
        IntExp intExp = new IntExp();
        intExp.value = 5;

        // test
        String expected = "5";
        prettyPrinter.visitIntExpression(intExp);
        String actual = systemOutContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void visitAddExpression() throws Exception {

        //prep
        PrettyPrint prettyPrinter = new PrettyPrint();
        AddExp addExp = new AddExp();
        IntExp left = new IntExp();
        IntExp right = new IntExp();

        left.value = 1;
        right.value = 2;

        addExp.left = left;
        addExp.right = right;

        // test
        String expected = "(1+2)";
        prettyPrinter.visitAddExpression(addExp);
        String actual = systemOutContent.toString();

        assertEquals(expected, actual);

    }

    @Test
    public void visitComplexAddExpressionRight() throws Exception {

        //prep
        PrettyPrint prettyPrinter = new PrettyPrint();
        AddExp addExp = new AddExp();
        IntExp left = new IntExp();
        AddExp subAddExpRight = new AddExp();
        IntExp subAddExpRight_Left = new IntExp();
        IntExp subAddExpRight_Right = new IntExp();

        left.value = 1;
        subAddExpRight_Left.value = 3;
        subAddExpRight_Right.value = 4;

        addExp.left = left; // 1
        subAddExpRight.left = subAddExpRight_Left; // 3
        subAddExpRight.right = subAddExpRight_Right; // 4
        addExp.right = subAddExpRight; // 3+4


        // test
        String expected = "(1+(3+4))";
        prettyPrinter.visitAddExpression(addExp);
        String actual = systemOutContent.toString();

        assertEquals(expected, actual);

    }

    @Test
    public void visitComplexAddExpressionLeft() throws Exception {

        //prep
        PrettyPrint prettyPrinter = new PrettyPrint();
        AddExp addExp = new AddExp();
        IntExp right = new IntExp();
        AddExp subAddExpLeft = new AddExp();
        IntExp subAddExpLeft_Left = new IntExp();
        IntExp subAddExpLeft_Right = new IntExp();

        right.value = 1;
        subAddExpLeft_Left.value = 3;
        subAddExpLeft_Right.value = 4;

        addExp.right = right; // 1
        subAddExpLeft.left = subAddExpLeft_Left; // 3
        subAddExpLeft.right = subAddExpLeft_Right; // 4
        addExp.left = subAddExpLeft; // 3+4


        // test
        String expected = "((3+4)+1)";
        prettyPrinter.visitAddExpression(addExp);
        String actual = systemOutContent.toString();

        assertEquals(expected, actual);

    }

    @Test
    public void visitComplexAddExpression() throws Exception {

        //prep
        PrettyPrint prettyPrinter = new PrettyPrint();
        AddExp addExp = new AddExp();

        // Prep left side
        AddExp subAddExpLeft = new AddExp();
        IntExp subAddExpLeft_Left = new IntExp();
        IntExp subAddExpLeft_Right = new IntExp();

        subAddExpLeft_Left.value = 3;
        subAddExpLeft_Right.value = 4;

        subAddExpLeft.left = subAddExpLeft_Left; // 3
        subAddExpLeft.right = subAddExpLeft_Right; // 4
        addExp.left = subAddExpLeft; // 3+4


        // prep right side
        AddExp subAddExpRight = new AddExp();
        IntExp subAddExpRight_Left = new IntExp();
        IntExp subAddExpRight_Right = new IntExp();

        subAddExpRight_Left.value = 1;
        subAddExpRight_Right.value = 2;

        subAddExpRight.left = subAddExpRight_Left; // 1
        subAddExpRight.right = subAddExpRight_Right; // 2
        addExp.right = subAddExpRight; // 1+2


        // test
        String expected = "((3+4)+(1+2))";
        prettyPrinter.visitAddExpression(addExp);
        String actual = systemOutContent.toString();

        assertEquals(expected, actual);

    }

}