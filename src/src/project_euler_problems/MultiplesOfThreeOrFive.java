package project_euler_problems;
public class MultiplesOfThreeOrFive {
    
    public static int sumOfAllMultipliesBelow(int n) {
        int sum = 0;

        for(int i=0; i<n; i++) {
            if(i%3==0 || i%5 == 0){
                sum += i;
            }
        }

        return sum;
    }

}
