import java.util.Scanner;

public class Task4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String inputStr = sc.nextLine();
        System.out.println("Введите подстроку");
        String inputSubstr = sc.nextLine();
        int count = 0;

        int index;
        for(index = 0; (index = inputStr.indexOf(inputSubstr, index)) != -1; index += inputSubstr.length()) {
            ++count;
        }

        System.out.printf("Подстрока '%s' встречается %d раза", inputSubstr, count);
    }
}
