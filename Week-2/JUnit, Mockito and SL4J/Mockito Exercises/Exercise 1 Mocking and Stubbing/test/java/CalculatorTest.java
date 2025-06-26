import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator initialized");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator cleaned up");
    }

    @Test
    public void testAddition() {

        int a = 2, b = 3;


        int result = calculator.add(a, b);


        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {

        int a = 5, b = 3;

        int result = calculator.subtract(a, b);

        assertEquals(2, result);
    }
}
