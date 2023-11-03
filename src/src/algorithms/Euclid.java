import java.lang.Math;

public class Euclid {
    public static int iterative(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        int swap = 0;

        if(a<b){
            swap = a;
            a = b;
            b = swap;
        }

        while(b!=0) {
            swap = a % b;
            a= b;
            b = swap;
        }

        return a;
    }

    public static int recursive(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        if(b == 0){
            return a;
        }

        return recursive(b, a % b);
    }

}
