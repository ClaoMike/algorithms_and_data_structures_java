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
        // Showcase.BFS();
        // Showcase.DFS();

        JSONDirectedGraphFileReader reader = new JSONDirectedGraphFileReader(Constants.directedGraphTasksJSONFilePath);
        TopologySort ts = new TopologySort(reader.getGraph());
        System.out.println(ts.getTopologicalSort());

        /////////////////////////////////////////////////
        // Project Euler - first 100 problems are allowed to be on a public repo
        /////////////////////////////////////////////////
        // ProjectEulerShowcase.multipliesOfThreeOrFiveBelowOneThousand();
        // ProjectEulerShowcase.sumOfEvenFibonacciElementsBelowFourMillion();
        // ProjectEulerShowcase.largestPrimeFactorOfThisNBelowInTheImplementation();
        // ProjectEulerShowcase.largestPalindromeProductOfThreeDigitsNumbers();
        // ProjectEulerShowcase.smallestMultipleOfYwenty();
        // ProjectEulerShowcase.sumSquareDifference();
        // ProjectEulerShowcase.the10001PrimeNumber();
    }
}
