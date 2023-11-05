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

        // for(String s: reader.getData()) {
        //     sut.insert(s, price++);
        // }

        for(int i=0; i < 10; i++) {
            sut.insert(reader.getData().get(i), price++);
        }

        // sut.printAllPairs();

        for(int i=10; i < 20; i++) {
            sut.insert(reader.getData().get(i), price++);
        }

        // sut.printAllPairs();

        for(int i=20; i < 30; i++) {
            sut.insert(reader.getData().get(i), price++);
        }

        // sut.printAllPairs();

        for(int i=30; i < 40; i++) {
            sut.insert(reader.getData().get(i), price++);
        }

        // sut.printAllPairs();

        for(int i=40; i < 50; i++) {
            sut.insert(reader.getData().get(i), price++);
        }

        sut.printAllPairs();

        System.out.println(sut.search("Apple").getKey());

        System.out.println(sut.delete("Apple"));

        System.out.println(sut.delete("Apple"));

        sut.printAllPairs();

        System.out.println(sut.delete("Black sapote"));

        sut.printAllPairs();

        System.out.println(sut.delete("Goji berry"));

        sut.printAllPairs();

    }
}
