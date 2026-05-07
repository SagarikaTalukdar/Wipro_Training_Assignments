package SDET_Day7;

class FoodDelivery extends Thread {

    static synchronized void process(String name) {
        try {
            System.out.println(name + " started");
            Thread.sleep(2000);
            System.out.println(name + " completed");
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
    }

    public FoodDelivery(String name) {
        setName(name);
    }

    public void run() {
        process(getName());
    }
}

public class Multithreading_Q2 {
    public static void main(String[] args) throws InterruptedException {

        FoodDelivery order = new FoodDelivery("Order Processing");
        FoodDelivery kitchen = new FoodDelivery("Kitchen Work");
        FoodDelivery delivery = new FoodDelivery("Delivery Task");

        order.setPriority(Thread.MAX_PRIORITY);
        kitchen.setPriority(Thread.NORM_PRIORITY);
        delivery.setPriority(Thread.MIN_PRIORITY);

        order.start();
        kitchen.start();

        System.out.println("Is order Alive? " + order.isAlive());

        order.join();
        kitchen.join();

        delivery.start();
        delivery.join();

        System.out.println("All tasks completed.");
    }
}