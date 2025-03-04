import java.util.Scanner;

public class Task4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String date = sc.nextLine();
        String[] dates = date.split("\\.");
        String day = dates[0];
        String month = dates[1];
        String year = dates[2];
        String output = String.join("-", year, month, day);
        System.out.println(output);
    }
}
