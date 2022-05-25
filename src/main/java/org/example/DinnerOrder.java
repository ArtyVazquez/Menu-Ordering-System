package org.example;

import org.javatuples.Pair;

public class DinnerOrder extends Order{
    private final Dinner d;
    private final Pair<String, Integer> desert;

    public DinnerOrder(int mainCount, int sideCount, int drinkCount, int desertCount) {
        d = new Dinner();

        this.main = new Pair<>(d.getMain(), mainCount);
        this.side = new Pair<>(d.getSide(), sideCount);
        this.drink = new Pair<>(d.getOptionalDrink(), drinkCount);
        this.desert = new Pair<>(d.getDesert(), desertCount);
    }

    @Override
    public String place() {
        String ret;
        if (main.getValue1() > 1 && side.getValue1() > 1 && drink.getValue1() > 1 && desert.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once, %s cannot be ordered more than once, %s cannot be ordered more than once, %s cannot be ordered more than once",
                    main.getValue0(), side.getValue0(), drink.getValue0(), desert.getValue0());
        } else if (main.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once",  main.getValue0());
        } else if (side.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once",  side.getValue0());
        } else if (drink.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once",  drink.getValue0());
        } else if (desert.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once",  desert.getValue0());
        } else if (main.getValue1() == 0 && side.getValue1() == 0 && desert.getValue1() == 0) {
            ret = "Unable to process: Main is missing, side is missing, desert is missing";
        } else if (main.getValue1() == 0) {
            ret = "Unable to process: Main is missing";
        } else if (side.getValue1() == 0) {
            ret = "Unable to process: Side is missing";
        } else if (desert.getValue1() == 0) {
            ret = "Unable to process: Dessert is missing";
        } else {
            if (drink.getValue1() == 0)
                ret = String.format("%s, %s, %s, %s", main.getValue0(), side.getValue0(), d.getDrink(), desert.getValue0());
            else
                ret = String.format("%s, %s, %s, %s, %s", main.getValue0(), side.getValue0(), drink.getValue0(), d.getDrink(), desert.getValue0());
        }

        return ret;
    }
}
