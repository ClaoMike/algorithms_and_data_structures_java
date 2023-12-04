import java.util.ArrayList;

public class CountElementsOfAnArrayRecursive {
    
    public static int count(ArrayList<Integer> array) {
        if(array.size() == 0) {
            return 0;
        }

        array.remove(0);

        return 1 + count(array);
    }

}
