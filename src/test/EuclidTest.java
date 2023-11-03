import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EuclidTest {

    @Test
    public void testgeneralCaseIterative(){
        assertEquals(6, Euclid.iterative(270, 192)); 
    }

    @Test
    public void testgeneralCaseRecursive(){
        assertEquals(6, Euclid.recursive(270, 192)); 
    }

    @Test
    public void testFirstNumberIsZeroCaseIterative(){
        assertEquals(192, Euclid.iterative(0, 192)); 
    }

    @Test
    public void testSecondNumberIsZeroCaseIterative(){
        assertEquals(270, Euclid.iterative(270, 0)); 
    }

    @Test
    public void testFirstNumberIsZeroCaseRecursive(){
        assertEquals(192, Euclid.recursive(0, 192)); 
    }

    @Test
    public void testSecondNumberIsZeroCaseRecursive(){
        assertEquals(270, Euclid.recursive(270, 0)); 
    }

    @Test
    public void testBothNumbersAreZeroCaseIterative(){
        assertEquals(0, Euclid.iterative(0, 0)); 
    }

    @Test
    public void testBothNumbersAreZeroCaseRecursive(){
        assertEquals(0, Euclid.recursive(0, 0)); 
    }

    @Test
    public void testNegativeCaseIterative(){
         assertEquals(6, Euclid.iterative(-270, 192)); 
    }

    @Test
    public void testNegativeCaseRecursive(){
         assertEquals(6, Euclid.recursive(-270, 192)); 
    }

    @Test
    public void testBothNegativeCaseIterative(){
         assertEquals(6, Euclid.iterative(-270, -192)); 
    }

    @Test
    public void testBothNegativeCaseRecursive(){
         assertEquals(6, Euclid.recursive(-270, -192)); 
    }

    @Test
    public void testOneNegativeOneZeroCaseIterative(){
         assertEquals(270, Euclid.iterative(-270, 0)); 
    }

    @Test
    public void testOneNegativeOneZeroCaseRecursive(){
         assertEquals(192, Euclid.recursive(0, -192)); 
    }



}
