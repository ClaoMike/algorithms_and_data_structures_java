import java.util.Random;
import java.util.Arrays;

public class Generator {

    public int[] generateArrayWithRandomIntegers(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for(int i=0; i<array.length; i++){
            array[i] = random.nextInt();
        }

        return array;
    }

    public int[] generateSortedArrayWithRandomIntegers(int size) {
        int[] array = generateArrayWithRandomIntegers(size);
        Arrays.sort(array);

        return array;
    }

    public int generateRandomInteger() {
        return new Random().nextInt();
    }

}
