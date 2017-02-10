import java.util.Timer;
import java.util.TimerTask;

public class Task2 {

    private static volatile int value = 1500;
    private static String sort = "Белый налив";

    public static void main(String[] args) {
        System.out.println("На складе " + value+ " кг яблок сорта " + sort);
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                if (value != 0) {
                    int x = 100;
                    value -= 100;
                    System.out.println("Магазин 1 закупил " + x + " кг яблок "
                            + sort);
                    System.out.println("На складе осталось " + value
                            + " кг яблок " + sort);
                }

            }

        }, 1000, 2000);

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                if (value != 0) {
                    int x = 100;
                    value -= 100;

                    System.out.println("Магазин 2 закупил " + x + " кг яблок "
                            + sort);
                    System.out.println("На складе осталось " + value
                            + " кг яблок " + sort);
                }

            }

        }, 1000, 4000);

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                String s[] = { "Антоновка", "Белый налив", "Спартак", "Мельба",
                        "Грушовка", "Аркадик" };
                int n = (int) Math.floor(Math.random() * s.length);
                String str = s[n];
                int x = 1000;
                value += x;
                sort = str;
                System.out.println("На склад привезли " + x
                        + " кг яблок сорта " + str);

            }

        }, 22000, 22000);

    }

}