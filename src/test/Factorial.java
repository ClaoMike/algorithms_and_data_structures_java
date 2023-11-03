public class Factorial {
    public static Integer factorial(int x) {
        if(x<0){
            return null;
        }
        
        if(x == 0){
            return 1;
        }

        if(x==1) {
            return 1;
        }
        else {
            return x * factorial(x-1);
        }

    }
    
}
