import java.lang.Math; 

public class LargestPrimeFactor {
    
    public static long largestPrimeFactorOf(long n) {
        long biggestFactor = 1;
        long biggestPrimeFactor = 1;

        while(biggestFactor <= Math.sqrt(n)){
            biggestFactor++;
            
            while(n % biggestFactor != 0){
                biggestFactor++;
            }

            if(isPrime(biggestFactor)){
                biggestPrimeFactor = biggestFactor;
                System.out.println(biggestPrimeFactor);
            }
        }

        return biggestPrimeFactor;
    }

    private static boolean isPrime(long n) {
        for(long i=2; i<=Math.sqrt(n); i++)
            if(n%i==0)
                return false;

        return true;
    }
}
