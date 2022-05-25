package org.example;

import java.util.Arrays;

public class InputParser {
    private String in;
    private String mealType;
    private int mainCount;
    private int sideCount;
    private int drinkCount;
    private int[] entries;

    public InputParser(String in) {
        this.in = in.trim();
        this.entries = null;
        this.mealType =  null;
        this.mainCount = 0;
        this.sideCount = 0;
        this.drinkCount = 0;
    }

    public String getMealType() {
        return this.mealType;
    }
    public int getMainCount() { return mainCount; }
    public int getSideCount() { return sideCount; }
    public int getDrinkCount() { return drinkCount; }

    public boolean parse() {

            if (!inputMatch())
                return false;

            mealType = in.substring(0, in.indexOf(" ")); // turn this into a sorted array
            entries = Arrays.stream(in.substring( in.indexOf(" ") + 1). split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            this.mainCount = ((int) Arrays.stream(entries).filter(e -> e == 1).count());
            this.sideCount = ((int) Arrays.stream(entries).filter(e -> e == 2).count());
            this.drinkCount = ((int) Arrays.stream(entries).filter(e -> e == 3).count());

        return true;
    }

    public boolean inputMatch() {
        return in.matches("[a-zA-Z]*\\s[0-9,]*[0-9]");
    }
}
