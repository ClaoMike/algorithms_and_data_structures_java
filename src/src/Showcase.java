import java.lang.Integer;

public class Showcase {
    public static void binarySearch() {
        Generator g = new Generator();

        int size = 20;
        int[] arrayWithRandomIntegers = g.generateArrayWithRandomIntegers(size);
        int[] sortedArrayWithRandomIntegers = g.generateSortedArrayWithRandomIntegers(size);
        
        Helpers.printArray(arrayWithRandomIntegers);
        Helpers.printArray(sortedArrayWithRandomIntegers);

        int item = Helpers.pickRandomElementFromArray(sortedArrayWithRandomIntegers);
        
        System.out.println("Number to search: ");
        System.out.println(item);
        
        int itemPosition = BinarySearch.find(sortedArrayWithRandomIntegers, item);

        System.out.println("Number's position: ");
        System.out.println(itemPosition);

        int randomItem = g.generateRandomInteger();

        System.out.println("Random number to search: ");
        System.out.println(randomItem);

        Integer randomItemPosition = BinarySearch.find(sortedArrayWithRandomIntegers, randomItem);

        System.out.println("Random number's position: ");
        System.out.println(randomItemPosition);
    }
}
