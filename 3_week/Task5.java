import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class Task5 {
    private static final CountDownLatch START = new CountDownLatch(11);

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                Match m = new Match();
                try {
                    m.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, 0, 10000);
    }

    static class Match {

        public void run() throws InterruptedException {
            int r = ((int) (Math.random() * 3) + 8);
            if (r != 10) {
                for (int i = 1; i <= r; i++) {
                    System.out.println("Игрок №" + i + " пришел");
                    Thread.sleep(100);
                }
                Thread.sleep(2000);
                System.out.println("Матч Переноситься, мало людей");
            }

            else {
                for (int i = 1; i <= 10; i++) {
                    new Thread(new Player(i)).start();
                    Thread.sleep(100);
                }
                while (START.getCount() > 3)
                    Thread.sleep(100);
                if (Math.random() < 0.5) {
                    System.out.println("Матч прошел успешно");
                    START.countDown();
                } else {
                    System.out.println("На улице дождь");
                    System.out.println("Матч Переноситься");
                }

            }
        }
    }

    static class Player implements Runnable {

        private int player;

        public Player(int player) {
            this.player = player;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Игрок №%d пришел.\n", player);
                START.countDown();
                START.await();
            } catch (InterruptedException e) {
            }
        }
    }
}