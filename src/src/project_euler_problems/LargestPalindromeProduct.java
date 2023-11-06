import java.lang.Math;

public class LargestPalindromeProduct {

    public static int largestPalindromeMadeFromTheProductOfTwoNDigitNumbers(int n) {
        int largestPalindrom = 0;

        int  upperBound = (int) Math.pow(10, n);
        int  lowerBound = (int) Math.pow(10, n-1);

        for(int i = lowerBound; i<upperBound;i++){
            for(int j = lowerBound; j<upperBound; j++){
                int product = i * j;
                
                if(isPalindrome(product) && product > largestPalindrom){
                    largestPalindrom = product;
                }
            }
        }

        return largestPalindrom;
    }

    public static boolean isPalindrome(int n) {
        int originalN = n;
        int reversedN = 0;
        int remainder;

        while(n!=0) {
            remainder = n%10;
            reversedN = reversedN *10 + remainder;
            n/=10;
        }

        if(originalN == reversedN) {
            return true;
        }

        return false;
    }
}
