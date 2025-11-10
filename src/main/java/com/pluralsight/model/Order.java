package com.pluralsight.model;

import java.util.ArrayList;

public class Order {
    // create List for order items (sandwiches, drinks, and chips)
    // store total price
    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Chips> chips = new ArrayList<>();
    private double totalPrice;

    // constructor:
    //   - initialize the class propeties


    // addSandwich method:
    //   - add sandwich to list
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    // addDrink method:
    //   - add drink to list
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    // addChips method:
    //   - add chips to list
    public void addChips(Chips chipsType) {
        chips.add(chipsType);

    }

    // getTotal method:
    //   - return total price of order
    public double getTotal() {
        double total = 0;

        for (Sandwich sandwich: sandwiches)
            total = total + sandwich.getPrice();

        for (Drink drink: drinks)
            total = total + drink.getPrice();

        for(Chips chip: chips)
            total = total + chip.getPrice();

        return total;
    }

    // getSandwiches, getDrinks, getChips:
    //   - return the orders items
    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chips> getChips() {
        return chips;
    }

    // getOrderSummary method:
    //   - return formatted string of all items and total
}
