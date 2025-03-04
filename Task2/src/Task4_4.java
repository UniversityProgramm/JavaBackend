import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task4_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String date = sc.nextLine();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date parsingDate = ft.parse(date);
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = outputFormat.format(parsingDate);
            System.out.println(formattedDate);
        } catch (ParseException var7) {
            System.out.println("Нераспаршена с помощью " + ft);
        }

    }
}
