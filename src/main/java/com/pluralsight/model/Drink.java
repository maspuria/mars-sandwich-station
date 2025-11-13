package com.pluralsight.model;

public class Drink extends OrderItem { // Drink class is child class of OrderItem
    // Field
   private String drinkSize;
   private String flavor;
   private double price;

   // constructor
    public Drink(String drinkSize, String flavor) {
        this.drinkSize = drinkSize;
        this.flavor = flavor;

        if (this.drinkSize.equalsIgnoreCase("small")) {
            price = 2.00;
        } else if (this.drinkSize.equalsIgnoreCase("medium")) {
            price = 2.50;
        } else if (this.drinkSize.equalsIgnoreCase("large")) {
            price = 3.00;
        } else {
            price = 0;
        }
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getSummary() {
        return "\nDrink: " + drinkSize +
                " " + flavor + " $" +
                String.format("%.2f",price);
    }

    @Override
    public String toString() {
        return "\n------------------------------" +
                "\nSize: " + drinkSize +
                "\nFlavor: " + flavor +
                "\nPrice: $" + String.format("%.2f", price) +
                "\n------------------------------";
    }
}
