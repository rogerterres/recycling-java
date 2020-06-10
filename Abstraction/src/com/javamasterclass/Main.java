package com.javamasterclass;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Morkie");
        dog.breathe();
        dog.eat();

        // Bird bird = new Bird("Parrot");
        Parrot parrot = new Parrot("Australian ringneck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
    }
}
