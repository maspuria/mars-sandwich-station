package com.pluralsight.model;

public class Chips extends OrderItem { //Chips is child of OrderItem
    //Field
    private String typeOfChip;
    private double price = 1.50;

    //constructor
    public Chips(String typeOfChip) {
        this.typeOfChip = typeOfChip;
    }

    //Getter
    public String getTypeOfChip() {
        return typeOfChip;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getSummary() {
        return "\nChips: " + typeOfChip + " $" + String.format("%.2f", price);
    }

    @Override
    public String toString() {
        return "\n--------------------------------" +
                "\nChip type: " + typeOfChip +
                "\nPrice: $" + String.format("%.2f", price) +
                "\n--------------------------------";
    }
}
