import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int a = 10_000_000;
        int b = 1_000_000_000;

        System.out.println("Ответ: " + getArithmeticProgressionSum(a, b));
    }

    public static long getArithmeticProgressionSum(int a, int b) {
        return IntStream.range(a, b).asLongStream().sum();
    }
}