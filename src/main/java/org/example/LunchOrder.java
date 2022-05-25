package org.example;
import org.javatuples.Pair;

public class LunchOrder extends Order {
    private Lunch l;

    public LunchOrder(int one, int two, int three) {
        if (three != 0)
            this.l = new Lunch("Soda");
        else
            this.l = new Lunch();

        this.main = new Pair<String, Integer>(l.getMain(), one);
        this.side = new Pair<String, Integer>(l.getSide(), two);
        this.drink = new Pair<String, Integer>(l.getDrink(), three);
    }

    @Override
    public boolean verifyOrder() {
        return false;
    }
}
