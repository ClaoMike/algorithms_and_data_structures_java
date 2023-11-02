import java.lang.Integer;

public class BinarySearch {
    
    public static Integer find(int[] list, int item) {
        int low=0;
        int high=list.length-1;
        int mid, guess;

        while(low<=high) {
            mid=(low+high)/2;
            guess=list[mid];

            if(guess==item) {
                return mid;
            }
            else if(guess>item) {
                high=mid-1;
                
            }
            else {
                low=mid+1;
            }
        }

        return null;
    }

}

// {89, 11, 22, 33, 44, 55, 66, 77}