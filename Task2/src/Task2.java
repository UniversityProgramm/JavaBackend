import java.io.PrintStream;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 3 числа");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        boolean flag = false;
        if (a % 5 == 0) {
            System.out.printf("a=%d ", a);
            flag = true;
        }

        if (b % 5 == 0) {
            System.out.printf("b=%d ", b);
            flag = true;
        }

        if (c % 5 == 0) {
            System.out.printf("c=%d ", c);
            flag = true;
        }

        if (!flag) {
            System.out.println("нет значений, кратных 5");
        }
        else System.out.println();

        System.out.println("Результат целочисленного деления a на b: " + a / b);
        System.out.println("Результат деления a на b: " + (double)a / (double)b);
        PrintStream var10000 = System.out;
        double var10001 = Math.ceil((double)a / (double)b);
        var10000.println("Результат деления a на b с округлением в большую сторону: " + var10001);
        var10000 = System.out;
        var10001 = Math.floor((double)a / (double)b);
        var10000.println("Результат деления a на b с округлением в меньшую сторону: " + var10001);
        var10000 = System.out;
        long var11 = Math.round((double)a / (double)b);
        var10000.println("Результат деления a на b с математическим округлением: " + var11);
        System.out.println("Остаток от деления b на c: " + b % c);
        var10000 = System.out;
        int var12 = Math.min(a, b);
        var10000.println("Наименьшее значение из a и b: " + var12);
        var10000 = System.out;
        var12 = Math.max(a, b);
        var10000.println("Наибольшее значение из a и b: " + var12);
    }
}
