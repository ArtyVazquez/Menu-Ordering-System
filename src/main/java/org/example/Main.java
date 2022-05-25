/*
 * Arturo Vazquez
 *
 * Solution for Evive Engineering test (Menu ordering System)
 *
 *
 * */
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            // Get the user input
            Scanner myObj = new Scanner(System.in);
            System.out.print("Order: ");
            String order = myObj.nextLine();

            // From user input extract the data and check that it's valid
            ExtractInput p = new ExtractInput(order);
            if  (!p.extract()) {
                System.out.println("Invalid order...");
                continue;
            }

            // place order(s) and get feedback
            switch (p.getMealType()) {
                case "Breakfast":
                    BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
                    System.out.println(bo.place());
                    break;
                case "Lunch":
                    LunchOrder lo = new LunchOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
                    System.out.println(lo.place());
                    break;
                case "Dinner":
                    DinnerOrder dio = new DinnerOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount(),p.getDesertCount());
                    System.out.println(dio.place());
                    break;
                default:
                    System.out.println("Invalid Order...");
            }
        }

    }
}