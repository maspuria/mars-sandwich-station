package com.pluralsight.model;

public class Drink {
    //Field
   private String size;
   private String flavor;
   private double price;

   // constructor
    public Drink() {
        this.size = size;
        this.flavor = flavor;

        if (size.equalsIgnoreCase("small")) {
            price = 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 2.50;
        } else if (size.equalsIgnoreCase("large")) {
            price = 3.00;
        }
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\n==== Drink ====" +
                "\nSize: " + size +
                "\nFlavor: " + flavor +
                "\nPrice: $" + price;
    }
}
