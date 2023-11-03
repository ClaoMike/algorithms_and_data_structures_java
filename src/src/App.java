import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Helpers.clearConsole();

        // Showcase.binarySearch();
        // Showcase.selectionSort();
        // Showcase.factorial();
        
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(5);
        test.add(4);
        test.add(6);
        test.add(9);
        test.add(2);
        test.add(89);
        test.add(-2);
        test.add(-70);

        ArrayList<Integer> result = MergeSort.mergeSort(test);
        System.out.println(result);
    }
}
