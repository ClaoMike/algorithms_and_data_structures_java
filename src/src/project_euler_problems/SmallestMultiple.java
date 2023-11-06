public class SmallestMultiple {
    
    public static long upTo(int n) {
        long[] initialList = new long[n];
        long[] newList;

        for(int i = 0; i<n; i++){
            initialList[i] = i+1;
        }

        for(int i = 0; i<n-1; i++){
            newList = new long[n-i-1];

            for(int j = 0; j<initialList.length-1; j++) {
                long GCD = Euclid.recursive(initialList[j], initialList[j+1]);
                long LCM = (initialList[j]*initialList[j+1])/GCD;
                newList[j] = LCM;
            }
            initialList = newList;
        }

        return initialList[0];
    }
}
