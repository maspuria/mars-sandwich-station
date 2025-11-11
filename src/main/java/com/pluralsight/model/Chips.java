package com.pluralsight.model;

public class Chips {
    //Field
    private String typeOfChip;
    private double price = 1.50;

    //constructor
    public Chips(String typeOfChip) {
        this.typeOfChip = typeOfChip;
    }

    //Getter
    public double getPrice() {
        return price;
    }

    public String getTypeOfChip() {
        return typeOfChip;
    }

    @Override
    public String toString() {
        return "\n--------------------------------" +
                "\nChip type: " + typeOfChip +
                "\nPrice: $" + String.format("%.2f", price) +
                "\n--------------------------------";
    }
}
