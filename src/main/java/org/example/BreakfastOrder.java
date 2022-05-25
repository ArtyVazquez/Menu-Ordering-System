package org.example;
import org.javatuples.Pair;

public class BreakfastOrder extends Order {
    private Breakfast b;

    public BreakfastOrder(int one, int two, int three) {
        if (three != 0)
            this.b = new Breakfast("Coffee");
        else
            this.b = new Breakfast();

        this.main = new Pair<String, Integer>(b.getMain(), one);
        this.side = new Pair<String, Integer>(b.getSide(), two);
        this.drink = new Pair<String, Integer>(b.getDrink(), three);
    }

    @Override
   public boolean verifyOrder() {
        boolean correctMain = true;
        boolean correctSide= true;

        if (main.getValue1() != 1)
            correctMain = false;
        if (side.getValue1() != 1)
            correctSide = false;

        if (correctMain && correctSide) {
            System.out.print(main.getValue0() + ", " + side.getValue0() + ", " + drink.getValue0());
            if (this.drink.getValue1() > 1)
              System.out.println("(" + drink.getValue1() + ")");
            else
              System.out.println();
        } else {
            System.out.print("Unable to process: ");
            if (!correctMain && !correctSide) {
                System.out.println("Main is missing, side is missing" );
            } else if (!correctMain) {
                System.out.println("Main is missing");
            } else {
                System.out.println("Side is missing");
            }
        }

        return correctMain && correctSide;
   }

}
