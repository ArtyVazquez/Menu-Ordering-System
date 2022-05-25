package org.example;

public class Dinner extends Meal{
    private String desert;
    private String optionalDrink;

    public Dinner() {
        super("Steak", "Potatoes");
        this.desert = "Cake";
        this.optionalDrink = "Wine";
    }

    public String getOptionalDrink() { return optionalDrink; }

    public String getDesert() {
        return desert;
    }
}
