import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
//Задание 1
//Нужно сохранить имена и фамилии всех своих сотрудников в ArrayList.
//Каждый месяц, работник будет выбран случайным образом из этих записей, чтобы получить премию.
public class Workers {

    static List<String> workers = new ArrayList<String>();

    public static void main(String[] args) {

        workers.add("Назар Волокитин");
        workers.add("Адам Трофимов");
        workers.add("Никита Игнатов");
        workers.add("Ульяна Иванова");
        workers.add("Селена Носкова");
        workers.add("Иоанна Матиевская");
        workers.add("Ярослав Шашко");
        workers.add("Даниил Устинов");
        workers.add("Филимон Новиков");
        workers.add("Захар Галкинн");
        workers.add("Анастасий Зимин");
        workers.add("Виктор Федосеев");
        workers.add("Максим Степанов");
        workers.add("Моисей Колесников");
        workers.add("Михаил Кошелев");
        workers.add("Аполлон Комаров");
        workers.add("Нина Наумова");
        workers.add("Ипатия Громова");
        workers.add("Василий Дмитриев");
        workers.add("Арнольд Сафонов");

        int delay = 1;   // задержка

        int interval = 1000;  // здесь можно задать любой интервал

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                premium(workers);
            }

        }, delay, interval);
    }

    public static int premium(List<String> worker) {
        int n = (int) Math.floor(Math.random() * worker.size());
        System.out.println(worker.get(n) + " - Получит премию");
        return n;
    }
}