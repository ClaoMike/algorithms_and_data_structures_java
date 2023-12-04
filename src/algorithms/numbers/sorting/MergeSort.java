import java.util.ArrayList;
import java.util.Stack;

public class MergeSort implements SortableInterface {
    
    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        if(array.size() <= 1) {
            return array;
        }

        ArrayList<Integer> half1 = new ArrayList<>();
        ArrayList<Integer> half2 = new ArrayList<>();

        half1.addAll(array.subList(0, array.size()/2));
        half2.addAll(array.subList(array.size()/2, array.size()));

        half1 = sort(half1);
        half2 = sort(half2);

        return merge(half1, half2);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        Stack<Integer> merged = new Stack<>();

        while(array2.size() > 0 && array1.size() > 0) {
            if(array1.get(0) > array2.get(0)) {
                merged.push(array2.get(0));
                array2.remove(0);
            }
            else {
                merged.push(array1.get(0));
                array1.remove(0);
            }
        }

        while(array1.size() > 0) {
            merged.push(array1.get(0));
            array1.remove(0);
        }

        while(array2.size() > 0) {
            merged.push(array2.get(0));
            array2.remove(0);
        }

        return new ArrayList<Integer>(merged);
    }
}
