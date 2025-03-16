package Task9;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentWithClock implements Learner {
    private Learner learner;

    public StudentWithClock(Learner learner) {
        this.learner = learner;
    }

    @Override
    public void learn() {
        learner.learn();

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String time = dateFormat.format(date);
        System.out.println("Текущее время: " + time);
    }
}
