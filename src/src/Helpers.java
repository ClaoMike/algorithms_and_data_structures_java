import java.util.Random;
import java.util.ArrayList;

public class Helpers {

    public static void printArray(int[] array) {
        System.out.println();
        System.out.print("Array >> ");
        for(int i=0; i<array.length-1; i++){
            System.out.print(array[i]);
            System.out.print(", ");
        }
        System.out.print(array[array.length-1]);
        System.out.println(" <<");
    }

    public static void printArray(long[] array) {
        System.out.println();
        System.out.print("Array >> ");
        for(int i=0; i<array.length-1; i++){
            System.out.print(array[i]);
            System.out.print(", ");
        }
        System.out.print(array[array.length-1]);
        System.out.println(" <<");
    }

    public static int pickRandomElementFromArray(int[] array) {
        int random = new Random().nextInt(array.length);

        return array[random];
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int[] convertArrayListToArrayOfInt(ArrayList<Integer> array) { 
        int[] converted = new int[array.size()];

        for (int i=0; i < converted.length; i++) {
            converted[i] = array.get(i).intValue();
        }

        return converted;
    }

    public static ArrayList<Integer> convertArrayOfPrimitiveIntToArrayListOfIntegers(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for(int i = 0; i<array.length; i++) {
            arrayList.add(Integer.valueOf(array[i]));
        }

        return arrayList;
    }
    
}
