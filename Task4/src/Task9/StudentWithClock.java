package Task9;

import Task9.Student;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StudentWithClock extends Student {
    @Override
    public void learn() {
        super.learn();

        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = now.format(formatter);
        System.out.println("Текущее время: " + time);
    }
}
