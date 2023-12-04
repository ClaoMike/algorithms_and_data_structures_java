import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class CountElementsOfAnArrayRecursiveTest {

    protected void setUpArray(ArrayList<Integer> arr, int... args) {        
        for (int arg : args) {
            arr.add(arg);
        }
    }
    
    @Test
    public void testGeneralArray(){
        ArrayList<Integer> array = new ArrayList<>();
        setUpArray(array, 1, 2, 3, 4, 5);

        int expectedResult = 5;
        System.out.println(array);

        assertEquals(expectedResult, CountElementsOfAnArrayRecursive.count(array));
    }

    @Test
    public void testOneElementArray(){
        ArrayList<Integer> array = new ArrayList<>();
        setUpArray(array, 5);

        int expectedResult = 1;

        assertEquals(expectedResult, CountElementsOfAnArrayRecursive.count(array));
    }

    @Test
    public void testEmptyArray(){
        ArrayList<Integer> array = new ArrayList<>();

        int expectedResult = 0;

        assertEquals(expectedResult, CountElementsOfAnArrayRecursive.count(array));
    }

}
