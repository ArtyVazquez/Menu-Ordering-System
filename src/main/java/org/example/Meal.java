package org.example;

// This class will be the superclass. Will be inherited by the Breakfast, Lunch and Dinner class
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

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setSide(String side) {
        this.side = side;
    }

}
