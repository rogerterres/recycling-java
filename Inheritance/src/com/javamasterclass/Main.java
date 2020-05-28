package com.javamasterclass;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("Animal", 1, 1, 5, 5);
        Dog becky = new Dog("Morkie", 8, 20, 2, 4, 1, 20, "long silky");
//        becky.eat();
        becky.walk();
//        becky.run();
    }
}
