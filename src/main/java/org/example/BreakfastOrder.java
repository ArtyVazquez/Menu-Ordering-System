package org.example;

import org.javatuples.Pair;

public class BreakfastOrder extends Order {
    private final Breakfast b;

    public BreakfastOrder(int mainCount, int sideCount, int drinkCount) {
        if (drinkCount != 0)
            this.b = new Breakfast("Coffee");
        else
            this.b = new Breakfast();

        this.main = new Pair<>(b.getMain(), mainCount);
        this.side = new Pair<>(b.getSide(), sideCount);
        this.drink = new Pair<>(b.getDrink(), drinkCount);
    }

    @Override
   public String place() {

        String ret;
        if (main.getValue1() > 1 && side.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once, %s cannot be ordered more than once", main.getValue0(), side.getValue0());
        } else if (main.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once",  main.getValue0());
        } else if (side.getValue1() > 1) {
            ret = String.format("Unable to process: %s cannot be ordered more than once",  side.getValue0());
        } else if (main.getValue1() == 0 && side.getValue1() == 0) {
            ret = "Unable to process: Main is missing, side is missing";
        } else if (main.getValue1() == 0) {
            ret = "Unable to process: Main is missing";
        } else if (side.getValue1() == 0) {
            ret = "Unable to process: Side is missing";
        } else {
            ret = String.format("%s, %s, %s", main.getValue0(), side.getValue0(),
                    drink.getValue0().concat(drink.getValue1() > 1 ? "(" + drink.getValue1() + ")" : ""));
        }

        return ret;
   }

}
