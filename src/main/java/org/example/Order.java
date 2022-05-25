package org.example;
import org.javatuples.Pair;

/*

        Rules:
        1. An order consists of a meal and collection of comma separated item Ids.
        2. The system should return the name of the items ordered
        3. The system should always return items in the following order: meal, side, drink
        4. If multiple items are ordered, the number of items should be indicated

        5. Each order must contain a main and a side
        6. If no drink is ordered, water should be returned
        7. At breakfast, multiple cups of coffee can be ordered
        8. At lunch, multiple sides can be ordered
        9. At dinner, dessert must be ordered
        10. At dinner, water is always provided
*/


public abstract class Order {
    protected Pair<String, Integer> main;
    protected Pair<String, Integer> side;
    protected Pair<String, Integer> drink;

    public abstract boolean verifyOrder();
}
