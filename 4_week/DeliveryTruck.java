import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeliveryTruck {

    static int g1 = 1;
    static int g2 = 10;

    public int getG1() {
        return g1;
    }

    public void setG1(int g1) {
        DeliveryTruck.g1 = g1;
    }

    public int getG2() {
        return g2;
    }

    public void setG2(int g2) {
        DeliveryTruck.g2 = g2;
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                try {
                    System.out.println("Грузовики загружаються");
                    trip();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, 1, 20000);
    }

    private static void trip() throws InterruptedException {
        ExecutorService storageA = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= g1; i++) {
            storageA.submit(new DeliveryTruckA(i, "A"));
        }

        storageA.shutdown();

        ExecutorService storageB = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= g2; i++) {
            storageB.submit(new DeliveryTruckB(i, "B"));
        }
        storageB.shutdown();

    }

}

class DeliveryTruckA implements Runnable {
    int i;
    String s;

    DeliveryTruck t = new DeliveryTruck();

    public DeliveryTruckA(int i, String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Грузовик " + i + " со склада \"" + s + "\" отправился с посылкой № " + i);
            t.setG1(t.getG1() - 1);
            Thread.sleep(1000);
            System.out.println("Грузовик " + i + " с отделения \"" + s + "\" прибыл на склад  B ");
            Thread.sleep(2000);
            System.out.println("Грузовик " + i + " с отделения \"" + s + "\" разгрузился ");
            t.setG2(t.getG2() + 1);
            Thread.sleep(3000);
            System.out.println("Грузовик " + i + " с отделения \"" + s + "\" вернулся на склад  A ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class DeliveryTruckB implements Runnable {
    int i;
    String s;

    DeliveryTruck t = new DeliveryTruck();

    public DeliveryTruckB(int i, String s){
        this.i = i;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Грузовик " + i + " со склада \"" + s + "\" отправился с посылкой № " + i);
            t.setG2(t.getG2() - 1);
            Thread.sleep(3000);
            System.out.println("Грузовик " + i + " с отделения \"" + s + "\" прибыл на склад  A ");
            Thread.sleep(2000);
            System.out.println("Грузовик " + i + " с отделения \"" + s + "\" разгрузился ");
            t.setG1(t.getG1() + 1);
            Thread.sleep(1000);
            System.out.println("Грузовик " + i + " с отделения \"" + s + "\" вернулся на склад  B ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}