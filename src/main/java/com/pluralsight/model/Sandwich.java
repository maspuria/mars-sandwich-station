package com.pluralsight.model;

import java.util.List;

public class Sandwich {
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
    private double basePrice;
    private double totalPrice;

    // constructor: takes bread type, size, toasted
    //   - initialize properties
    //   - set base price based on size
    public Sandwich(String breadType, int sandwichSize, boolean isToasted,
                    List<String> meats, List<String> cheeses, List<String> toppings, List<String> sauces,
                    double basePrice, double totalPrice) {
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.isToasted = isToasted;
        this.meats = meats;
        this.cheeses = cheeses;
        this.toppings = toppings;
        this.sauces = sauces;
        this.basePrice = basePrice;
        this.totalPrice = totalPrice;
    }
    // addMeat method:
    //   - add meat(s)
    //   - what is the price based on size and whether it's extra?
    public void addMeat(String meat, boolean extraMeat) {
        meats.add(meat);

    }

    // addCheese method:
    //   - add cheese(s)
    //   - add price depending on size and whether it's extra
    public void addCheese(String cheese, boolean extra) {
        cheeses.add(cheese);

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

    // getPrice method:
    //   - return current total price
    public double getPrice() {
        return totalPrice;
    }

    // getSummary method:
    //   - return a string with all sandwich details and price
    public String getSummary() {
        return "\n========== Sandwich Summary ========== " +
                "\n Size: " + sandwichSize +
                "\n Bread: " + breadType +
                "\n Toasted: " + isToasted +
                "\n Meats: " + meats +
                "\n Cheeses: " + cheeses +
                "\n Toppings: " + toppings +
                "\n Sauces: " + sauces +
                "\n Price: $" + totalPrice + "\n";
    }


}
