package org.example;
import org.javatuples.Pair;

public class Lunch extends Meal{
    Lunch(String drink) {
        super("Sandwich", "Chips", drink);
    }

    Lunch() {
        super("Sandwich", "Chips");
    }
}
