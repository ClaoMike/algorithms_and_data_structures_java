import java.util.ArrayList;

public class SumElementsOfAnArrayRecursive {
    
    public static int sum(int[] array) {
        ArrayList<Integer> arrayList = Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(array);

        if(array.length == 0) {
            return 0;
        }

        return arrayList.remove(0) + sum(Helpers.convertArrayListToArrayOfInt(arrayList));
    }

}
