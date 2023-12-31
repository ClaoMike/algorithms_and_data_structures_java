import java.util.ArrayList;

public class QuickSort implements SortableInterface {
    
    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        if(array.size() < 2) {
            return array;
        }
        
        Integer pivot = array.get(0);

        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for(int i=1; i< array.size(); i++){
            if(array.get(i) <= pivot) {
                less.add(array.get(i));
            }
            else {
                greater.add(array.get(i));
            }
        }

        ArrayList<Integer> combined = new ArrayList<>();
        combined.addAll(sort(less));
        combined.add(pivot);
        combined.addAll(sort(greater));

        return combined; 
    }
    
}
