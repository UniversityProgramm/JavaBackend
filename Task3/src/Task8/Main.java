package Task8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, List<User>> usersMap = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите имя пользователя " + i);
            String name = sc.nextLine();
            System.out.println("Введите возраст пользователя " + i);
            Integer age = Integer.parseInt(sc.nextLine());

            if (usersMap.containsKey(age)) {
                usersMap.get(age).add(new User(name, age));
            }
            else {
                usersMap.put(age, new ArrayList<>());
                usersMap.get(age).add(new User(name, age));
            }
        }

        System.out.println("Введите требуемый возраст");
        Integer ageKey = Integer.parseInt(sc.nextLine());
        if (usersMap.containsKey(ageKey)) {
            List<User> users = usersMap.get(ageKey);
            users.sort(Comparator.comparing(User::getName));
            for (User user: usersMap.get(ageKey)) {
                System.out.println(user.toString());
            }
        }
        else {
            System.out.println("Пользователь с возрастом '" + ageKey + "' не найден");
        }
    }
}