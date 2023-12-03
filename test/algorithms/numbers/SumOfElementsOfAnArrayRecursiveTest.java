import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SumOfElementsOfAnArrayRecursiveTest {
    
    @Test
    public void testGeneralArray(){
        int[] array = {1, 2, 3, 4, 5};
        int expectedResult = 15;

        assertEquals(expectedResult, SumElementsOfAnArrayRecursive.sum(array));
    }

    @Test
    public void testOneElementArray(){
        int[] array = {89};
        int expectedResult = 89;

        assertEquals(expectedResult, SumElementsOfAnArrayRecursive.sum(array));
    }

    @Test
    public void testEmptyArray(){
        int[] array = {};
        int expectedResult = 0;

        assertEquals(expectedResult, SumElementsOfAnArrayRecursive.sum(array));
    }

    @Test
    public void testNegativeArray(){
        int[] array = {-1, 2, 5};
        int expectedResult = 6;

        assertEquals(expectedResult, SumElementsOfAnArrayRecursive.sum(array));
    }

}
