package SDET_Day3;

// Car class: encapsulate engine status, speed, fuelLevel.

import java.util.Scanner;

class Car {
    private boolean engineOn;
    private int speed;
    private double fuel;

    public void setFuel(double fuel) {
        if (fuel >= 0) {
            this.fuel = fuel;
        }
    }

    public void startEngine() {
        if (fuel > 0) {
            engineOn = true;
            System.out.println("Engine started");
        } else {
            System.out.println("No fuel!");
        }
    }

    public void accelerate(int value) {
        if (engineOn) {
            speed += value;
        } else {
            System.out.println("Start engine first!");
        }
    }

    public void showStatus() {
        System.out.println("Engine: " + engineOn);
        System.out.println("Speed: " + speed);
        System.out.println("Fuel: " + fuel);
    }
}

public class Encapsulation_Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car c = new Car();

        System.out.print("Enter fuel: ");
        double f = sc.nextDouble();
        c.setFuel(f);

        c.startEngine();

        System.out.print("Enter speed increment: ");
        int s = sc.nextInt();
        c.accelerate(s);

        c.showStatus();
        
        sc.close();
    }
}