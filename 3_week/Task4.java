import java.util.concurrent.Semaphore;

public class Task4 {
    static int f;
    static int b;

    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(5);
        for (int i = 1; i <= 5; i++) {
            new Client(sem, i).start();
            if (f > 4) {
                System.out.println("Магазин открыт");
            }
        }
    }

    static class Client extends Thread {

        Semaphore sem;
        int num = 0;
        int c;

        Client(Semaphore sem, int c) throws InterruptedException {
            this.sem = sem;
            this.c = c;
            f++;
            Thread.sleep(300);
        }

        public void run() {
            try {
                while (num < 3) {
                    sem.acquire();
                    b++;
                    System.out.println("Клиент " + c + " заходит в магазин");
                    int n = (int) (Math.random() * 8) + 1;
                    sleep(n * 1000);
                    num++;
                    System.out.println("Клиент " + c + " выходит из-магазина");
                    sem.release();
                    b--;
                    int f = (int) (Math.random() * 8) + 1;
                    sleep(f * 1000);

                    if (b <= 3) {
                        System.out.println("Мазазин закрыт");
                           System.exit(0);
                    }


                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
    }

}