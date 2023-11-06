import java.lang.Integer;
import java.util.ArrayList;

public class Showcase {
    private static int size = 89;
    private static int min = -100;
    private static int max = 100;
    private static Generator g = new Generator();

    private static int[] generateRandomArray(){
        return g.generateRandomArrayInRange(min, max, size);
    }

    private static int[] generateRandomSortedArray(){
        return g.generateRandomSortedArrayInRange(min, max, size);
    }

    private static int generateRandomInteger(){
        return g.generateRandomIntegerInRange(min, max);
    }

    public static void binarySearch() {
        int[] sorted = generateRandomSortedArray();
        
        Helpers.printArray(sorted);

        int item = Helpers.pickRandomElementFromArray(sorted);
        
        System.out.println("Number to search: ");
        System.out.println(item);
        
        int itemPosition = BinarySearch.find(sorted, item);

        System.out.println("Number's position: ");
        System.out.println(itemPosition);

        int randomItem = generateRandomInteger();

        System.out.println("Random number to search: ");
        System.out.println(randomItem);

        Integer randomItemPosition = BinarySearch.find(sorted, randomItem);

        System.out.println("Random number's position: ");
        System.out.println(randomItemPosition);
    }

    public static void selectionSort() {
        int[] array = generateRandomArray();

        int[] sortedArray = SelectionSort.selectionSort(array);

        Helpers.printArray(array);
        Helpers.printArray(sortedArray);
    }

    public static void factorial() {
        int n = 5;

        System.out.print("Parameter: ");
        System.out.println(n);
        System.out.print(n);
        System.out.print("! = ");
        System.out.println(Factorial.factorial(n));
    }

    public static void quickSort() {
        ArrayList<Integer> test = Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(generateRandomArray());
        ArrayList<Integer> result = QuickSort.quickSort(test);
       
        System.out.println("Initial array: ");
        System.out.println(test);
        System.out.println("Sorted array: ");
        System.out.println(result);
    }

    public static void mergeSort() {
        ArrayList<Integer> test = Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(generateRandomArray());
        ArrayList<Integer> result = MergeSort.mergeSort(test);

        System.out.println("Initial array: ");
        System.out.println(test);
        System.out.println("Sorted array: ");
        System.out.println(result);
    }

    public static void countArrayRecursive() {
        int[] array = generateRandomArray();
        int count = CountElementsOfAnArrayRecursive.count(array);
        ArrayList<Integer> arrayList = Helpers.convertArrayOfPrimitiveIntToArrayListOfIntegers(array);
        
        System.out.println("Array: ");
        System.out.println(arrayList);
        System.out.print("has ");
        System.out.print(count);
        System.out.println(" elements.");
    }

    public static void euclid() {
        int a = 270;
        int b = 192;

        euclidMessage("iterative", a, b);
        System.out.println(Euclid.iterative(a, b));
        euclidMessage("recursive", a, b);
        System.out.println(Euclid.recursive(a, b));
    }

    private static void euclidMessage(String type, int a, int b) {
        System.out.print("Applying the Euclid's algorithm in its " + type + " implementation for numbers ");
        System.out.print(a);
        System.out.print(" and ");
        System.out.print(b);
        System.out.print(", we get the GREATEST COMMON DIVISOR that is equal to ");
    }

    public static void sumArrayRecursive() {
        int[] array = generateRandomArray();

        System.out.println("The sum of the elements in ");
        Helpers.printArray(array);
        System.out.print("is ");
        System.out.println(SumElementsOfAnArrayRecursive.sum(array));
    }

    public static void maxArrayRecursive() {
        int[] array = generateRandomArray();

        System.out.println("The greatest element in ");
        Helpers.printArray(array);
        System.out.print("is ");
        System.out.println(MaxNumberInAnArrayRecursive.max(array));
    }

    public static void hashTable() {
        TextFileReader reader = new TextFileReader(Constants.fruitsFilePath);
        ArrayList<String> fruits = reader.getData();
        HashTable table = new HashTable();
        int price = 5;
        String fruit = "Papaya";
        String fakeFruit = "This is not a fruit";
        HashTable.KVP item;

        System.out.println("--> Populating the hash table");
        for(String s: fruits) {
            table.insert(s, price++);
        }

        table.printAllPairs(false);
        
        System.out.println("--> Search for " + fruit);
        item = table.search(fruit);
        System.out.println("Key: " + item.getKey() + ", value: " + item.getValue());

        System.out.println("--> Search for " + fakeFruit);
        item = table.search(fakeFruit);
        System.out.println(item);

        System.out.println("--> Delete " + fruit);
        table.delete(fruit);
        table.printAllPairs(false);

        System.out.println("--> Delete " + fakeFruit);
        System.out.println("Found: " + table.delete(fakeFruit));

        System.out.println("--> Insert " + fruit + " again");
        System.out.println(table.insert(fruit, 89));
        table.printAllPairs(false);

        System.out.println("--> Try to insert " + fruit + " again, as a duplicate");
        System.out.println(table.insert(fruit, 89));
        table.printAllPairs(false);

        System.out.println("--> Depopulate half of the table ");
        for(int i=0 ;i < fruits.size()/2; i++) {
            table.delete(fruits.get(i));
        }
        table.printAllPairs(true);

        System.out.println("--> Empty the hash table");

        for(String s:fruits) {
            table.delete(s);
        }

        table.printAllPairs(true);
    }

}
