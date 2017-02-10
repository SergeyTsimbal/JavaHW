public class Race implements Runnable {
    static int b = 0;
    String name;
    Thread t;
    boolean suspendFlag;

    Race(String threadname) throws InterruptedException {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Автомобиль " + name + " готов");
        suspendFlag = false;
        t.start();

    }

    public void run() {
        try {
            synchronized (this) {
                while (suspendFlag) {
                    b++;
                    wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Автомобиль " + name + " уехал с гонки");
        }
        System.out.println("Автомобиль " + name + " прибыл к финишу");
    }

    void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }

    public static void main(String args[]) {

        try {
            Race[] r = new Race[5];
            for (int i = 1; i <= 5; i++) {
                String str = String.valueOf(i);
                r[i - 1] = new Race(str);
                r[i - 1].mysuspend();
                Thread.sleep(500);
                if (b == 5) {
                    System.out.println("Гонка началась!!!");
                    Thread.sleep(1000);
                    for (int j = 0; j < r.length; j++) {
                        r[j].myresume();
                    }

                }

            }

        } catch (InterruptedException e) {
        }

    }
}