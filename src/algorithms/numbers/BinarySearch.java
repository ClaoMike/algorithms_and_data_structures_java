import java.lang.Integer;
import java.util.ArrayList;

public class BinarySearch {
    
    public static Integer find(ArrayList<Integer> list, Integer item) {
        Integer low = 0;
        Integer high = list.size() - 1;
        Integer mid, guess;

        while(low.intValue() <= high.intValue()) {
            mid = (low.intValue() + high.intValue()) / 2;
            guess = list.get(mid.intValue());

            if(guess.intValue() == item.intValue()) {
                return mid;
            }
            else if(guess.intValue() > item.intValue()) {
                high = mid.intValue() - 1;
                
            }
            else {
                low = mid.intValue() + 1;
            }
        }

        return null;
    }

}
