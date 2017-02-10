public class Task1 implements Runnable {
    String name;
    Thread t;

    Task1(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Запуск потока " + name);
        t.start();
    }

    public void run() {
        try {
            int n = (int) (Math.random() * 50);
            Thread.sleep(n * 100);
        } catch (InterruptedException e) {
            System.out.println(name + " прерван.");
        }
        System.out.println("Поток " + name + " завершен: ");
    }

        public static void main(String args[]) throws InterruptedException {

            Task1 t1 = new Task1("1");
            t1.t.join();
            Task1 t2 = new Task1("2");
            Task1 t3 = new Task1("3");
            t2.t.join();
            t3.t.join();
            Task1 t4 = new Task1("4");
            t4.t.join();

    }
}


