public class App {
    public static void main(String[] args) throws Exception {
        Helpers.clearConsole();

        /////////////////////////////////////////////////
        // Grokking Algorithms
        /////////////////////////////////////////////////
        // Showcase.binarySearch();
        // Showcase.selectionSort();
        // Showcase.factorial();
        // Showcase.quickSort();
        // Showcase.mergeSort();
        // Showcase.countArrayRecursive();
        // Showcase.euclid();
        // Showcase.sumArrayRecursive();
        // Showcase.maxArrayRecursive();
        // Showcase.hashTable();

        /////////////////////////////////////////////////
        // Project Euler
        /////////////////////////////////////////////////
        // ProjectEulerShowcase.multipliesOfThreeOrFiveBelowOneThousand();
        // ProjectEulerShowcase.sumOfEvenFibonacciElementsBelowFourMillion();
        // ProjectEulerShowcase.largestPrimeFactorOfThisNBelowInTheImplementation();
        // ProjectEulerShowcase.largestPalindromeProductOfThreeDigitsNumbers();
        // ProjectEulerShowcase.smallestMultipleOfYwenty();
        // ProjectEulerShowcase.sumSquareDifference();
        // ProjectEulerShowcase.the10001PrimeNumber();

        String source = "Chitila";
        String target = "Parcul Izvor";

        System.out.println("->> BFS");
        JSONDirectedGraphFileReader reader = new JSONDirectedGraphFileReader(Constants.directedGraphBucurestiJSONFilePath);

        // BreadthFirstSearch BFS = new BreadthFirstSearch(reader.getGraph());
        // System.out.println(BFS.isThereAPathBetween(source, target));
        // System.out.println(BFS.getPathBetween(source, target));
        // System.out.println(BFS.getAllPathsFrom(source));

        System.out.println("->> DFS");
        DepthFirstSearch DFS = new DepthFirstSearch(reader.getGraph());
        System.out.println(DFS.isThereAPathBetween(source, target));


    }
}
