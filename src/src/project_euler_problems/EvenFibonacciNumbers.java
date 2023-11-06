public class EvenFibonacciNumbers {

    public static long sumEvenValuedTermsThatDoNotExceed(long n) {
        long temp;
        long sum = 2;

        long previousFibonacci = 1;
        long currentFibonacci = 2;

        while (currentFibonacci < n) {
            temp = currentFibonacci;
            currentFibonacci = currentFibonacci + previousFibonacci;
            previousFibonacci = temp;

            if(currentFibonacci%2==0){
                sum += currentFibonacci;
            }
        }

        return sum;
    }
}
