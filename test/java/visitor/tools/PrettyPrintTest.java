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
        IntExp e1 = new IntExp();
        IntExp e2 = new IntExp();

        e1.value = 1;
        e2.value = 2;

        addExp.e1 = e1;
        addExp.e2 = e2;

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
        IntExp e1 = new IntExp();
        AddExp subAddExp = new AddExp();
        IntExp subAddExpE1 = new IntExp();
        IntExp subAddExpE2 = new IntExp();

        e1.value = 1;
        subAddExpE1.value = 3;
        subAddExpE2.value = 4;

        addExp.e1 = e1; // 1
        subAddExp.e1 = subAddExpE1; // 3
        subAddExp.e2 = subAddExpE2; // 4
        addExp.e2 = subAddExp; // 3+4


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
        IntExp e1 = new IntExp();
        AddExp subAddExp = new AddExp();
        IntExp subAddExpE1 = new IntExp();
        IntExp subAddExpE2 = new IntExp();

        e1.value = 1;
        subAddExpE1.value = 3;
        subAddExpE2.value = 4;

        addExp.e2 = e1; // 1
        subAddExp.e1 = subAddExpE1; // 3
        subAddExp.e2 = subAddExpE2; // 4
        addExp.e1 = subAddExp; // 3+4


        // test
        String expected = "((3+4)+1)";
        prettyPrinter.visitAddExpression(addExp);
        String actual = systemOutContent.toString();

        assertEquals(expected, actual);

    }

}