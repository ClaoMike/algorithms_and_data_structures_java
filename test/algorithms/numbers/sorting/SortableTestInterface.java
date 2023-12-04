import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public interface SortableTestInterface {
    
    @Before
    public void init();

    // An empty list
    @Test
    public void testSortingOnAEmptyList();

    // A single element list
    @Test
    public void testSortingOnAOneElementList();

    // A list with all zeros
    @Test
    public void testSortingOnAListFilledWithZeroes();

    // An ordered list
    @Test
    public void testSortingOnASortedList();

    // A reversed list
    @Test
    public void testSortingOnAReversedSortedList();

    // A list of all the same elements
    @Test
    public void testSortingOnASameElementSortedList();

    // A very large list
    @Test
    public void testSortingOnAVeryLargeList();
}
