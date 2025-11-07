package com.pluralsight.model;

import java.util.List;

public class Sandwich {
    // store bread type (white, wheat, rye, wrap)
    // store sandwich size (4, 8, or 12 inches)
    // store if sandwich is toasted
    // store meats, cheeses, toppings, sauces
    // keep track of total price

    // Field Members
    private String breadType;
    private int sandwichSize; // 4" , 8" , or 12"
    private boolean isToasted;
    private List<String> meats;
    private List<String> cheeses;
    private List<String> toppings;
    private List<String> sauces;
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

}
