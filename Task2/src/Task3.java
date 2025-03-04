import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[20];

        for(int i = 0; i < 20; ++i) {
            numbers[i] = rand.nextInt(15) + 1;
        }

        System.out.println(Arrays.toString(numbers));
        ArrayList<Integer> repeatDigits = new ArrayList();

        for(int i = 0; i < numbers.length; ++i) {
            int countOfRepeat = 1;
            if (!repeatDigits.contains(numbers[i])) {
                for(int j = 0; j < numbers.length; ++j) {
                    if (i != j && numbers[i] == numbers[j]) {
                        ++countOfRepeat;
                        repeatDigits.add(numbers[i]);
                    }
                }

                if (countOfRepeat > 1) {
                    System.out.printf("Число '%d' встречается %d раза\n", numbers[i], countOfRepeat);
                }
            }
        }

    }
}
