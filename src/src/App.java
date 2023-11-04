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

        // String path = "/Users/claomike/Desktop/Projects/algorithms_and_data_structures_java/src/resources/text_files/fruits.txt";
        // TextFileReader reader = new TextFileReader(path);
        // // reader.printDataRowByRow();

        // for(String s: reader.getData()){
        //     System.out.println(s + " -> " + String.valueOf(HashFunctions.divisionMethod(HashFunctions.polynomialRolling(s), 5)) + ";");
        // }

        // int[] test = {};
        // System.out.println(test[0]);

        HashTable table = new HashTable();
        table.insert("a", 100);
        System.out.println("Table size: " + table.getTableSize());

        table.insert("b", 101);
        table.insert("c", 102);
        table.insert("d", 103);
        table.insert("e", 104);
        table.insert("f", 105);
        table.insert("g", 106);
        table.insert("h", 107);
        table.insert("i", 108);
        table.insert("j", 109);
        System.out.println("Table size: " + table.getTableSize());

        HashTable.KVP pair;

        pair = table.search("a");
        System.out.println(pair.getKey() + " -> " + pair.getValue());

        pair = table.search("xxx");
        if(pair == null) {
            System.out.println("Not found!");
        } else {
            System.out.println(pair.getKey() + " -> " + pair.getValue());
        }

        boolean response = table.delete("g");
        if(response) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }

        response = table.delete("g");
        if(response) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }

        response = table.delete("a");
        if(response) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }

        response = table.delete("b");
        if(response) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }

        response = table.delete("c");
        if(response) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }

        response = table.delete("d");
        if(response) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }

        response = table.delete("e");
        if(response) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }

        response = table.delete("f");
        if(response) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }
        
        System.out.println("Table size: " + table.getTableSize());
        System.out.println("Number of occupied slots: " + table.getOccupiedSlots());
    }
}
