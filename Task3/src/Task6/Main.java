package Task6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя первого пользователя");
        String firstName = sc.nextLine();

        System.out.println("Введите возраст первого пользователя");
        Integer firstAge = Integer.parseInt(sc.nextLine());

        User user1 = new User(firstName, firstAge);

        System.out.println("Введите имя второго пользователя");
        String secondName = sc.nextLine();

        System.out.println("Введите возраст второго пользователя");
        Integer secondAge = Integer.parseInt(sc.nextLine());

        User user2 = new User(secondName, secondAge);

        if (firstAge < secondAge) {
            System.out.println(user1.toString());
        }
        else {
            System.out.println(user2.toString());
        }
    }
}