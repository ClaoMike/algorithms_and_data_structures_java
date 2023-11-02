import java.util.ArrayList;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        
        for(int i = 0; i<array.length; i++) {
            arrayList.add(Integer.valueOf(array[i]));
        }

        for (int i=0; i<array.length; i++) {
            Integer smallestIndex = findSmallest(arrayList);
            newArrayList.add(arrayList.get(smallestIndex));
            arrayList.remove(smallestIndex.intValue());
          }

        return Helpers.convertArrayListToArrayOfInt(newArrayList);
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
