import java.util.ArrayList;

public class Sort {
    
    static public ArrayList<Integer> merge(ArrayList<Integer> array){
        return new MergeSort().sort(array);
    }

    static public ArrayList<Integer> quick(ArrayList<Integer> array){
        return new QuickSort().sort(array);
    }

    static public ArrayList<Integer> selelction(ArrayList<Integer> array){
        return new SelectionSort().sort(array);
    }
}
