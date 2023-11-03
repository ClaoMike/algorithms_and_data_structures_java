import java.util.ArrayList;

public class SumElementsOfAnArrayRecursive {
    
    public static int sum(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for(int i = 0; i<array.length; i++) {
            arrayList.add(Integer.valueOf(array[i]));
        }

        if(array.length == 0) {
            return 0;
        }

        if(array.length == 1){
            return array[0];
        }

        return arrayList.remove(0) + sum(Helpers.convertArrayListToArrayOfInt(arrayList));
    }
}
