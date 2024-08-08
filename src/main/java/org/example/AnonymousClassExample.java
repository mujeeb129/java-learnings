package org.example;

abstract class Animal {
    abstract void makeSound();
}

public class AnonymousClassExample {
    public static void main(String[] args) {
        Animal animal = new Animal() {
            void makeSound() {
                System.out.println("Woof Woof!");
            }
        };
        animal.makeSound();
    }
}
