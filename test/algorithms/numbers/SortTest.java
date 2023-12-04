import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SortTest {

    public ArrayList<Integer> array;
    public ArrayList<Integer> expectedResult;

    @Before
    public void init() {
        array = new ArrayList<>();
        expectedResult = new ArrayList<>();
    }

    protected void setUpArray(ArrayList<Integer> arr, int... args) {
        arr = new ArrayList<>();
        
        for (int arg : args) {
            arr.add(arg);
        }
    }

    // An empty list
    @Test
    public void testSortingOnAEmptyList(){
        assertEquals(expectedResult, Sort.merge(array));
        assertEquals(expectedResult, Sort.quick(array));
        assertEquals(expectedResult, Sort.selelction(array));
    }

    // A single element list
    @Test
    public void testSortingOnAOneElementList(){
        setUpArray(array, 89);
        setUpArray(expectedResult, 89);

        assertEquals(expectedResult, Sort.merge(array));
        assertEquals(expectedResult, Sort.quick(array));
        assertEquals(expectedResult, Sort.selelction(array));
    }

    // A list with all zeros
    @Test
    public void testSortingOnAListFilledWithZeroes(){
        setUpArray(array, 0, 0, 0, 0, 0, 0);
        setUpArray(expectedResult, 0, 0, 0, 0, 0, 0);

       
        assertEquals(expectedResult, Sort.merge(array));
        assertEquals(expectedResult, Sort.quick(array));
        assertEquals(expectedResult, Sort.selelction(array));
    }

    // An ordered list
    @Test
    public void testSortingOnASortedList(){
        setUpArray(array, 1, 2 , 3, 4, 5);
        setUpArray(expectedResult, 1, 2 , 3, 4, 5);

        assertEquals(expectedResult, Sort.merge(array));
        assertEquals(expectedResult, Sort.quick(array));
        assertEquals(expectedResult, Sort.selelction(array));
    }

    // A reversed list
    @Test
    public void testSortingOnAReversedSortedList(){
        setUpArray(array, 5, 4, 3, 2, 1);
        setUpArray(expectedResult, 1, 2 , 3, 4, 5);

        assertEquals(expectedResult, Sort.merge(array));
        assertEquals(expectedResult, Sort.quick(array));
        assertEquals(expectedResult, Sort.selelction(array));
    }

    // A list of all the same elements
    @Test
    public void testSortingOnASameElementSortedList(){
        setUpArray(array, 5, 5, 5, 5, 5, 5);
        setUpArray(expectedResult, 5, 5, 5, 5, 5, 5);

        assertEquals(expectedResult, Sort.merge(array));
        assertEquals(expectedResult, Sort.quick(array));
        assertEquals(expectedResult, Sort.selelction(array));
    }

    // A very large list
    @Test
    public void testSortingOnAVeryLargeList(){
        int size = 30000;
        Generator g = new Generator();

        int[] list = g.generateArrayWithRandomIntegers(size);
        setUpArray(array, list);
        
        Arrays.sort(list);
        setUpArray(expectedResult, list);

        assertEquals(expectedResult, Sort.merge(array));
        assertEquals(expectedResult, Sort.quick(array));
        assertEquals(expectedResult, Sort.selelction(array));
    }
    
}
