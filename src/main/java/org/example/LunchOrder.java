package org.example;

import org.javatuples.Pair;

public class LunchOrder extends Order {
    private Lunch l;

    public LunchOrder(int mainCount, int sideCount, int drinkCount) {
        if (drinkCount != 0)
            this.l = new Lunch("Soda");
        else
            this.l = new Lunch();

        this.main = new Pair<>(l.getMain(), mainCount);
        this.side = new Pair<>(l.getSide(), sideCount);
        this.drink = new Pair<>(l.getDrink(), drinkCount);
    }

    @Override
    public String place() {
        String ret;
        if (main.getValue1() > 1 && drink.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once, %s cannot be ordered more than once", main.getValue0(), drink.getValue0());
        } else if (main.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once",  main.getValue0());
        } else if (drink.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once",  drink.getValue0());
        } else if (main.getValue1() == 0 && side.getValue1() == 0) {
            ret = "Unable to process: Main is missing, side is missing";
        } else if (main.getValue1() == 0) {
            ret = "Unable to process: Main is missing";
        } else if (side.getValue1() == 0) {
            ret = "Unable to process: Side is missing";
        } else {
            ret = String.format("%s, %s, %s", main.getValue0(), side.getValue0().concat(side.getValue1() > 1 ? "(" + side.getValue1() + ")" : ""), drink.getValue0());
        }

        return ret;
    }
}