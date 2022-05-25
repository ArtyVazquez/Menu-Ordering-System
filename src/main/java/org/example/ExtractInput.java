package org.example;

import java.util.Arrays;

public class ExtractInput {
    private String in;
    private String mealType;
    private int mainCount;
    private int sideCount;
    private int drinkCount;
    private int desertCount;

    public ExtractInput(String in) {
        this.in = in.toLowerCase();
    }

    public String getMealType() {
        return this.mealType;
    }
    public int getMainCount() { return this.mainCount; }
    public int getSideCount() { return this.sideCount; }
    public int getDrinkCount() { return this.drinkCount; }
    public int getDesertCount() { return this.desertCount; }

    public boolean extract() {

        if (!inputMatch())
                return false;

        this.mealType = in.substring(0, in.indexOf(" "));

        int[] ids = Arrays.stream(in.substring(in.indexOf(" ") + 1).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        this.mainCount = ((int) Arrays.stream(ids).filter(e -> e == 1).count());
        this.sideCount = ((int) Arrays.stream(ids).filter(e -> e == 2).count());
        this.drinkCount = ((int) Arrays.stream(ids).filter(e -> e == 3).count());

        if (in.matches("[dinner]*\\s[1-4,]*[1-4]"))
                this.desertCount = ((int) Arrays.stream(ids).filter(e -> e == 4).count());

        return true;
    }

    // check that user input satisfies rule 1. An order consists of a meal and collection of comma separated item Ids
    public boolean inputMatch() {
        return in.matches("[breakfast]*\\s[1-3,]*[1-3]") || in.matches("[lunch]*\\s[1-3,]*[1-3]") ||
                in.matches("[dinner]*\\s[1-4,]*[1-4]");
    }

}