import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BinarySearchTest {

    // null if array is empty
    @Test
    public void returnNullIfArrayIsEmpty(){
        int[] emptyArray = {};
        assertNull(BinarySearch.find(emptyArray, 89));
    }

    // null if not found in array with even length
    @Test
    public void returnNullIfNotFoundInArrayWithEvenLength(){
        int[] array = {11, 22, 33, 44, 55, 66};
        assertNull(BinarySearch.find(array, 89));
    }

    // null if not found in array with odd length
    @Test
    public void returnNullIfNotFoundInArrayWithOddLength(){
        int[] array = {11, 22, 33, 44, 55, 66, 77};
        assertNull(BinarySearch.find(array, 89));
    }

    // 0 if found in array at position 0
    @Test
    public void returnZeroIfFoundInArrayAtPositionZero(){
        int[] array = {89, 91, 93, 95, 97, 99, 101};
        assertEquals(Integer.valueOf(0), BinarySearch.find(array, 89));
    }

    // array's length - 1 if found in array at the last position
    @Test
    public void returnArrayLengthMinusOneIfFoundInArrayAtTheLastPosition(){
        int[] array = {11, 22, 33, 44, 55, 66, 77, 89};
        assertEquals(Integer.valueOf(7), BinarySearch.find(array, 89));
    }

    // middle if found in the middle of the array
    @Test
    public void returnTheMiddleIndexIfFoundInTheMiddleOfTheArray(){
        int[] array = {83, 85, 87, 89, 91, 93, 95};
        assertEquals(Integer.valueOf(3), BinarySearch.find(array, 89));
    }

    // x if found in array at position x
    @Test
    public void returnXIfFoundInArrayAtPositionX(){
        int[] array = {79, 81, 83, 85, 87, 89, 91, 93};
        assertEquals(Integer.valueOf(5), BinarySearch.find(array, 89));
    }

}
