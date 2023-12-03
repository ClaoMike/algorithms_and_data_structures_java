import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class FactorialTest {

    @Test
    public void testFactorialForARandomValue(){
        int expectedValue = 120;
    
        assertEquals(expectedValue, Factorial.factorial(5).intValue());
    }

    @Test
    public void testFactorialForZero(){
        int expectedValue = 1;
    
        assertEquals(expectedValue, Factorial.factorial(0).intValue());
    }

    @Test
    public void testFactorialForNegativeValues(){
        assertNull(Factorial.factorial(-10));
    }

}
