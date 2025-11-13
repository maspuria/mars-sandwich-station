package com.pluralsight.model;

import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> items = new ArrayList<>(); // create List for order items (sandwiches, drinks, and chips)
    private double totalPrice; // store total price

    //adds any item: sandwich, drink, chips
    public void addItem(OrderItem item) {
        items.add(item);
    }

    // getTotal method:
    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total = total + item.getPrice();
        }
        return total; // return total price of order
    }

    // getOrderSummary method:
    //   - return formatted string of all items and total
    public String getOrderSummary() {
        String summary = "";
        summary += "\n*************************************************************";
        summary += "\n                   Mars Sandwich Station";
        summary += "\n-------------------------------------------------------------";
        summary += "\n                        Receipt";
        summary += "\n-------------------------------------------------------------";

        for (OrderItem item : items) {
            summary = summary + item.getSummary() + "\n";
        }
        summary += "\n-------------------------------------------------------------";
        summary += "\n TOTAL: $" + String.format("%.2f", getTotal());
        summary += "\n=============================================================";
        summary += "\n                     Enjoy your Meal!";
        summary += "\n=============================================================";

        return summary;
    }
}
