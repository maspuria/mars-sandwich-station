package com.pluralsight.model;

public class Reuben extends Sandwich {
    //constructor to define what Reuben sandwich is made of
    public Reuben() {
        setBreadType("Rye");
        setSandwichSize(8);
        setToasted(true);
        addBasePriceSandwichSize();
        addMeat("Roast Beef", false); // substituting for corn beef
        addCheese("Swiss", false);
        addTopping("Onions"); // sub for sauerkraut
        addSauce("Thousand Island");
    }

    @Override
    public String getSummary() {
        // returns custom title and getSummary() from the parent class to display sandwich summary
       return "\n=============== Reuben Signature Sandwich ================== " + super.getSummary();
    }
}
