import java.util.ArrayList;

public class CountElementsOfAnArrayRecursive {
    
    public static int count(int[] array) {
        ArrayList<Integer> arrayList = Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(array);

        if(array.length == 0) {
            return 0;
        }

        return 1 + count(Helpers.convertArrayListToArrayOfInt(arrayList));
    }

}
