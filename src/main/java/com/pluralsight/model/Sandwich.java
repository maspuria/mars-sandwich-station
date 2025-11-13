package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends OrderItem { //sandwich class is the child of OrderItem
    // Field Members
    private String breadType; // store bread type (white, wheat, rye, wrap)
    private int sandwichSize; // store sandwich size (4" , 8" , or 12")
    private boolean isToasted; // store if sandwich is toasted
    // store meats, cheeses, toppings, sauces
    private List<String> meats;
    private List<String> cheeses;
    private List<String> toppings;
    private List<String> sauces;
    // keep track of total price
    private double totalPrice;

    // constructor: takes bread type, size, toasted
    //   - initialize properties
    //   - set base price based on size
    public Sandwich() {
       meats = new ArrayList<>();
       cheeses = new ArrayList<>();
       toppings = new ArrayList<>();
       sauces = new ArrayList<>();
    }

    // getBasePriceSandwichSize method:
    public void setBasePriceSandwichSize() {
        if (sandwichSize == 4) {
            totalPrice = 5.50;
        } else if (sandwichSize == 8) {
            totalPrice = 7.00;
        } else if (sandwichSize == 12) {
            totalPrice = 8.50;
        }
    }
    // addMeat method:
    //   - add meat(s)
    //   - what is the price based on size and whether it's extra?
    public void addMeat(String meat, boolean extraMeat) {
        meats.add(meat);

        if (sandwichSize == 4) {
            if (extraMeat) {
                totalPrice = totalPrice + 0.50; // extra charge for meat
            }
            totalPrice = totalPrice + 1.00;
        } else if (sandwichSize == 8) {
            if (extraMeat) {
                totalPrice = totalPrice + 1.00;
            }
            totalPrice = totalPrice + 2.00;
        } else if (sandwichSize == 12) {
            if (extraMeat) {
                totalPrice = totalPrice + 1.50;
            }
            totalPrice = totalPrice + 3.00;
        }
    }

    // addCheese method:
    //   - add cheese(s)
    //   - add price depending on size and whether it's extra
    public void addCheese(String cheese, boolean extraCheese) {
        cheeses.add(cheese);
        if (sandwichSize == 4) {
            if (extraCheese) {
                totalPrice = totalPrice + 0.30; // extra charge for meat
            }
            totalPrice = totalPrice + 0.75;

        } else if (sandwichSize == 8) {
            if (extraCheese) {
                totalPrice = totalPrice + 0.60;
            }
            totalPrice = totalPrice + 1.50;

        } else if (sandwichSize == 12) {
            if (extraCheese) {
                totalPrice = totalPrice + 0.90;
            }
            totalPrice = totalPrice + 2.25;
        }
    }

    // addTopping method:
    //   - add topping(s)
    //   - no charge
    public void addTopping(String topping) {
        toppings.add(topping);
    }

    // addSauce method:
    //   - add sauce(s)
    //   - no charge
    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    //Setters
    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setSandwichSize(int sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
    }

    // getPrice method:
    //   - return current total price
    @Override
    public double getPrice() {
        return totalPrice;
    }

    // getSummary method:
    //   - return a string with all sandwich details and price
    @Override
    public String getSummary() {
        String toastedChoice;
        if (isToasted) {
            toastedChoice = "Yes";
        } else {
            toastedChoice = "No";
        }

        return "\n===================== Sandwich Summary ===================== " +
                "\nToasted: " + toastedChoice +
                "\nMeats: " + meats +
                "\nCheeses: " + cheeses +
                "\nToppings: " + toppings +
                "\nSauces: " + sauces +
                "\nPrice: $" + String.format("%.2f", totalPrice);
    }

    @Override
    public String toString() {
        return "\n------------------------------------------------------------" +
                "\n Size: " + sandwichSize + " inch" + " Bread: " + breadType +
                "\n Toasted: " + isToasted +
                "\n Meats: " + meats +
                "\n Cheeses: " + cheeses +
                "\n Toppings: " + toppings +
                "\n Sauces: " + sauces +
                "\n------------------------------------------------------------" +
                "\n Price: $" + String.format("%.2f", totalPrice);
    }
}
