import hash_tables.HashTable;

public class App {
    public static void main(String[] args) throws Exception {
        Helpers.clearConsole();

        // Showcase.binarySearch();
        // Showcase.selectionSort();
        // Showcase.factorial();
        // Showcase.quickSort();
        // Showcase.mergeSort();
        // Showcase.countArrayRecursive();
        // Showcase.euclid();
        // Showcase.sumArrayRecursive();
        // Showcase.maxArrayRecursive();

        String path = "/Users/claomike/Desktop/Projects/algorithms_and_data_structures_java/src/resources/text_files/fruits.txt";
        TextFileReader reader = new TextFileReader(path);
        HashTable sut = new HashTable();
        int price = 5;

        for(String s: reader.getData()) {
            sut.insert(s, price++);
        }
        System.out.println("->>>>" + sut.getTableSize());
        System.out.println("->>>>>" + sut.getOccupiedSlots());

        for(String s: reader.getData()) {
            sut.delete(s);
        }
        System.out.println("->>>>" + sut.getTableSize());
        System.out.println("->>>>>" + sut.getOccupiedSlots());

        // sut.printAllPairs();clear
        // System.out.println(reader.getData().size());
    }
}
