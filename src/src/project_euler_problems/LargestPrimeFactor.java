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

            if(Prime.isPrime(biggestFactor)){
                biggestPrimeFactor = biggestFactor;
                System.out.println(biggestPrimeFactor);
            }
        }

        return biggestPrimeFactor;
    }

}
