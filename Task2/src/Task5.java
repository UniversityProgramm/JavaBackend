import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату в формате dd.MM.yyyy:");
        String date = sc.nextLine();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date parsingDate = ft.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parsingDate);
            calendar.add(6, 45);
            PrintStream var10000 = System.out;
            String var10001 = ft.format(calendar.getTime());
            var10000.println("Дата после увеличения на 45 дней: " + var10001);
            calendar.setTime(parsingDate);
            calendar.set(6, 1);
            var10000 = System.out;
            var10001 = ft.format(calendar.getTime());
            var10000.println("Дата после сдвига на начало года: " + var10001);
            calendar.setTime(parsingDate);
            int workingDaysAdded = 0;

            while(workingDaysAdded < 10) {
                calendar.add(5, 1);
                int dayOfWeek = calendar.get(7);
                if (dayOfWeek != 7 && dayOfWeek != 1) {
                    ++workingDaysAdded;
                }
            }

            var10000 = System.out;
            var10001 = ft.format(calendar.getTime());
            var10000.println("Дата после увеличения на 10 рабочих дней: " + var10001);
            System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
            String inputDate2 = sc.nextLine();
            Date inputDate = ft.parse(inputDate2);
            Date startDate = parsingDate.before(inputDate) ? parsingDate : inputDate;
            Date endDate = parsingDate.before(inputDate) ? inputDate : parsingDate;
            calendar.setTime(startDate);
            long diffInMilliseconds = Math.abs(endDate.getTime() - startDate.getTime());
            int diffInDays = (int)(diffInMilliseconds / 86400000L);
            int workingDaysBetween = 0;

            for(int i = 0; i <= diffInDays; ++i) {
                int dayOfWeek = calendar.get(7);
                if (dayOfWeek != 7 && dayOfWeek != 1) {
                    ++workingDaysBetween;
                }

                calendar.add(5, 1);
            }

            System.out.println("Количество рабочих дней между введенными датами: " + workingDaysBetween);
        } catch (ParseException var17) {
            System.out.println("Нераспаршена с помощью " + ft);
        }

    }
}