package Task7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите имя пользователя " + i);
            String name = sc.nextLine();
            System.out.println("Введите возраст пользователя " + i);
            Integer age = Integer.parseInt(sc.nextLine());

            users.add(new User(name, age));
        }

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getAge().compareTo(user2.getAge());
            }
        });

        for (User user : users) {
            System.out.println(user);
        }
    }
}