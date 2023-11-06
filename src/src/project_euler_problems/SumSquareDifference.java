import java.lang.Math;

public class SumSquareDifference {
    
    public static long sumOfSquaresOfTheFirstNNaturalNumbers(long n) {
        return (n * (n + 1) * (2 * n + 1)) / 6;
    }

    public static long squareOfTheSumOfTheFirstNNaturalNumbers(long n){
        long sum = n*(n+1)/2;
        return (long) Math.pow(sum, 2);
    }

    public static long differenceBetweenTheSumOfTheSquaresAndTheSquareOfTheSumOfFirstNNaturalNumbers(long n) {
        return squareOfTheSumOfTheFirstNNaturalNumbers(n) - sumOfSquaresOfTheFirstNNaturalNumbers(n);
    }
}
