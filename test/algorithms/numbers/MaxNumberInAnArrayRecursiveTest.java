import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MaxNumberInAnArrayRecursiveTest {
    
    @Test
    public void testGeneralArray(){
        int[] array = {1, 3, 2, 5, 4};
        int expectedResult = 5;

        assertEquals(expectedResult, MaxNumberInAnArrayRecursive.max(array).intValue());
    }

    @Test
    public void testOneElementArray(){
        int[] array = {89};
        int expectedResult = 89;

        assertEquals(expectedResult, MaxNumberInAnArrayRecursive.max(array).intValue());
    }

    @Test
    public void testEmptyArray(){
        int[] array = {};

        assertNull(MaxNumberInAnArrayRecursive.max(array));
    }

}
