import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Как тебя зовут?");
        Scanner sc = new Scanner(System.in);
        String inputName = sc.nextLine();
        System.out.printf("Привет, %s!", inputName);
    }
}
