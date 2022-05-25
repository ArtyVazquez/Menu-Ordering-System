package org.example;

public class Breakfast extends Meal {
    Breakfast(String drink) {
        super("Eggs", "Toast", drink);
    }

    Breakfast() {
        super("Eggs", "Toast");
    }

}
