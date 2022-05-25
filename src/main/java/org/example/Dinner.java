package org.example;

public class Dinner extends Meal{
    private String desert;
    private String optionalDrink;

    public Dinner() {
        super("Steak", "Potatoes"); // call this constructor since it gives water by default
        this.desert = "Cake";
        this.optionalDrink = "Wine";
    }

    public void setOptionalDrink(String optionalDrink) { this.optionalDrink = optionalDrink; }

    public String getOptionalDrink() { return optionalDrink; }

    public String getDesert() {
        return desert;
    }

    public void setDesert(String desert) {
        this.desert = desert;
    }
}
