package SDET_Day3;

abstract class Animal {
    abstract void sound(); // Abstraction

    void sleep() {
        System.out.println("Sleeping");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Animal obj = new Dog(); // Upcasting

        obj.sound(); // Calls Dog's method
        obj.sleep(); // Calls Animal's method
    }
}