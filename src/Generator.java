import java.util.Random;
import java.util.Arrays;

public class Generator {
    private Random random;

    public Generator(){
        random = new Random();
    }

    public int[] generateArrayWithRandomIntegers(int size) {
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

    public int generateRandomIntegerInRange(int min, int max) {
		return random .ints(min, (max + 1)).findFirst().getAsInt();
    }

    public int[] generateRandomArrayInRange(int min, int max, int size) {
        int[] array = new int[size];

        for(int i=0; i<array.length; i++){
            array[i] = generateRandomIntegerInRange(min, max);
        }

        return array;
    }

    public int[] generateRandomSortedArrayInRange(int min, int max, int size) {
        int[] array = generateRandomArrayInRange(min, max, size);
        Arrays.sort(array);

        return array;
    }

}
