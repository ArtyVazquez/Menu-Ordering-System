package org.example;

public class Meal {
    private String main;
    private String side;
    private String drink;

    Meal(String main, String side, String drink) {
        this.main = main;
        this.side = side;
        this.drink = drink;
    }

    Meal(String main, String side) {
        this.main = main;
        this.side = side;
        this.drink = "Water";
    }

    public String getDrink() {
        return drink;
    }

    public String getSide() {
        return side;
    }

    public String getMain() {
        return main;
    }
}