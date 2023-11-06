package project_euler_problems;

public class SmallestMultiple {
    
    public static void upTo(int n) {
        int[] previousList = new int[n];
        int[] newList;

        for(int i = 0; i<n; i++){
            initialList[i] = i+1;
        }

        for(int i = 1; i<=n; i++){
            newList = new int[n-i];
            for(int j = 0; j<previousList.length-1; j++) {
                // TODO
            }
        }

        System.out.println();
    }
}
