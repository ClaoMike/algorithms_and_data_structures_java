import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

public class QuickSortTest {
    
    // An empty list
    @Test
    public void testSortingOnAEmptyList(){
        int[] emptyList = {};

        int[] expectedResult = emptyList;
        int[] actualResult = Helpers.convertArrayListToArrayOfInt(QuickSort.quickSort(Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(emptyList)));
    
        assertArrayEquals(expectedResult, actualResult);
    }

    // A single element list
    @Test
    public void testSortingOnAOneElementList(){
        int[] list = {89};

        int[] expectedResult = list;
        int[] actualResult = Helpers.convertArrayListToArrayOfInt(QuickSort.quickSort(Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(list)));
    
        assertArrayEquals(expectedResult, actualResult);
    }

    // A list with all zeros
    @Test
    public void testSortingOnAListFilledWithZeroes(){
        int[] list = {0, 0, 0, 0, 0, 0};

        int[] expectedResult = list;
        int[] actualResult = Helpers.convertArrayListToArrayOfInt(QuickSort.quickSort(Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(list)));
    
        assertArrayEquals(expectedResult, actualResult);
    }

    // An ordered list
    @Test
    public void testSortingOnASortedList(){
        int[] list = {1, 2 , 3, 4, 5};

        int[] expectedResult = list;
        int[] actualResult = Helpers.convertArrayListToArrayOfInt(QuickSort.quickSort(Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(list)));
    
        assertArrayEquals(expectedResult, actualResult);
    }

    // A reversed list
    @Test
    public void testSortingOnAReversedSortedList(){
        int[] list = {5, 4, 3, 2, 1};

        int[] expectedResult = {1, 2 , 3, 4, 5};
        int[] actualResult = Helpers.convertArrayListToArrayOfInt(QuickSort.quickSort(Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(list)));
    
        assertArrayEquals(expectedResult, actualResult);
    }

    // A list of all the same elements
    @Test
    public void testSortingOnASameElementSortedList(){
        int[] list = {5, 5, 5, 5, 5, 5};

        int[] expectedResult = list;
        int[] actualResult = Helpers.convertArrayListToArrayOfInt(QuickSort.quickSort(Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(list)));
    
        assertArrayEquals(expectedResult, actualResult);
    }

    // A very large list
    @Test
    public void testSortingOnAVeryLargeList(){
        int size = 30000;
        Generator g = new Generator();

        int[] list = g.generateArrayWithRandomIntegers(size);

        int[] expectedResult = Arrays.copyOf(list, list.length);
        Arrays.sort(expectedResult);

        int[] actualResult = Helpers.convertArrayListToArrayOfInt(QuickSort.quickSort(Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(list)));
    
        assertArrayEquals(expectedResult, actualResult);
    }

}
