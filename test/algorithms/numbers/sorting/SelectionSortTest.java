import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;

import org.junit.Test;

public class SelectionSortTest {

    // An empty list
    @Test
    public void testSortingOnAEmptyList(){
        int[] emptyList = {};
    
        assertArrayEquals(emptyList, SelectionSort.selectionSort(emptyList));
    }

    // A single element list
    @Test
    public void testSortingOnAOneElementList(){
        int[] list = {1};
    
        assertArrayEquals(list, SelectionSort.selectionSort(list));
    }

    // A list with all zeros
    @Test
    public void testSortingOnAListFilledWithZeroes(){
        int[] list = {0, 0, 0, 0, 0};
    
        assertArrayEquals(list, SelectionSort.selectionSort(list));
    }

    // An ordered list
    @Test
    public void testSortingOnASortedList(){
        int[] list = {1, 2 , 3, 4, 5};
    
        assertArrayEquals(list, SelectionSort.selectionSort(list));
    }

    // A reversed list
    @Test
    public void testSortingOnAReversedSortedList(){
        int[] list = {5, 4, 3, 2, 1};
        int[] expectedList = {1, 2 , 3, 4, 5};
    
        assertArrayEquals(expectedList, SelectionSort.selectionSort(list));
    }

    // A list of all the same elements
    @Test
    public void testSortingOnASameElementSortedList(){
        int[] list = {5, 5, 5, 5, 5, 5};
    
        assertArrayEquals(list, SelectionSort.selectionSort(list));
    }

    // A very large list
    @Test
    public void testSortingOnAVeryLargeList(){
        int size = 30000;
        Generator g = new Generator();

        int[] list = g.generateArrayWithRandomIntegers(size);

        int[] expectedList = Arrays.copyOf(list, list.length);
        Arrays.sort(expectedList);
    
        assertArrayEquals(expectedList, SelectionSort.selectionSort(list));
    }

}
