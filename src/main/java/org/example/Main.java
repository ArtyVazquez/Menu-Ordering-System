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

            // input form ------>  menu, 1,2,3
            InputParser p = new InputParser(order);

            if  (!p.parse()) {
                System.out.println("Invalid order...");
                continue;
            }

            switch (p.getMealType()) {
                case "Breakfast":
                    System.out.println("Breakfast");
                    BreakfastOrder bo = new BreakfastOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
                    bo.verifyOrder();
                    break;
                case "Lunch":
                    System.out.println("Lunch");
                    LunchOrder lo = new LunchOrder(p.getMainCount(), p.getSideCount(), p.getDrinkCount());
                    lo.verifyOrder();
                    break;
                case "Dinner":
                    System.out.println("Dinner");
                    break;
                default:
                    System.out.println("Invalid Order...");
            }

        }
    }
}