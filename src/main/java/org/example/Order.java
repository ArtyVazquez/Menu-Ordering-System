package org.example;
import org.javatuples.Pair;

public abstract class Order {
    protected Pair<String, Integer> main;
    protected Pair<String, Integer> side;
    protected Pair<String, Integer> drink;

    public abstract String place();
}