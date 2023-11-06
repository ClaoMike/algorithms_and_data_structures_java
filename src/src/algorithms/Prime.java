public class Prime {
    
    public static boolean isPrime(long n) {
        if(n == 0 || n==1){
            return false;
        }
        
        for(long i=2; i<=Math.sqrt(n); i++)
            if(n%i==0)
                return false;

        return true;
    }

    public static long theNthPrimeNumber(long n) {
        long countPrimes = 0;
        long currentPrime = 0;
        long current = 0;

        while(countPrimes < n){
            if(isPrime(current)) {
                countPrimes++;
                currentPrime = current;
            }

            current++;
        }

        return currentPrime;
    }

}
