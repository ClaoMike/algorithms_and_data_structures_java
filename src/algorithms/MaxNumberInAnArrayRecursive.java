import java.util.ArrayList;

public class MaxNumberInAnArrayRecursive {

    public static Integer max(int[] array) {
        if(array.length == 0) {
            return null;
        }

        if(array.length == 1) {
            return Integer.valueOf(array[0]);
        }

        ArrayList<Integer> arrayList = Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(array);

        if(arrayList.get(0) > arrayList.get(1)) {
            arrayList.remove(1);
        }
        else {
            arrayList.remove(0);
        }

        return max(Helpers.convertArrayListToArrayOfInt(arrayList));
    }
    
}
