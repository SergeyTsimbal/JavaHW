import java.util.concurrent.CountDownLatch;

public class Task3 {

    private static final CountDownLatch START = new CountDownLatch(16);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            new Thread(new Client(i)).start();
            Thread.sleep(300);
        }

        while (START.getCount() > 5) {

            for (int i = 1; i <= 5; i++) {
                System.out.println("Автомобиль " + i + " на аукционе");
                Thread.sleep(300);
                START.countDown();
            }

        }
        System.out.println("Аукцион начат");
        Thread.sleep(1000);
        START.countDown();

    }

    public static class Client implements Runnable {
        private int clientNumber;

        public Client(int clientNumber) {
            this.clientNumber = clientNumber;

        }

        @Override
        public void run() {
            try {

                System.out.printf("Клиент №%d возле аукциона\n", clientNumber);

                START.countDown();
                START.await();

                System.out.printf("Клиент №%d посетил аукцион\n", clientNumber);

            } catch (InterruptedException e) {
            }
        }

    }
}