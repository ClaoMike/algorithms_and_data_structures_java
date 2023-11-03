import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CountElementsOfAnArrayRecursiveTest {
    
    @Test
    public void testGeneralArray(){
        int[] array = {1, 2, 3, 4, 5};
        int expectedResult = 5;

        assertEquals(expectedResult, CountElementsOfAnArrayRecursive.count(array));
    }

    @Test
    public void testOneElementArray(){
        int[] array = {5};
        int expectedResult = 1;

        assertEquals(expectedResult, CountElementsOfAnArrayRecursive.count(array));
    }

    @Test
    public void testEmptyArray(){
        int[] array = {};
        int expectedResult = 0;

        assertEquals(expectedResult, CountElementsOfAnArrayRecursive.count(array));
    }

}
