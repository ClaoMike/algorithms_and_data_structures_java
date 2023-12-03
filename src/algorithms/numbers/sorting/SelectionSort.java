import java.util.ArrayList;

public class SelectionSort implements Sortable {
    
    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        ArrayList<Integer> newArrayList = new ArrayList<Integer>();

        for (int i=0; i<array.size(); i++) {
            Integer smallestIndex = findSmallest(array);
            newArrayList.add(array.get(smallestIndex));
            array.remove(smallestIndex.intValue());
          }

        return newArrayList;
    }

    private static Integer findSmallest(ArrayList<Integer> array){
        Integer smallest = array.get(0);
        Integer smallestIndex = 0;

        for(int i=1; i<array.size(); i++) {
            if(array.get(i) < smallest){
                smallest = array.get(i);
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    

}
