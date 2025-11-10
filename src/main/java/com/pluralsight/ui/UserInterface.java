package com.pluralsight.ui;

import com.pluralsight.model.Order;

import java.util.Scanner;

public class UserInterface {
    // declare a Scanner object for reading input from the console
    private Scanner scanner = new Scanner(System.in);

    // constructor:

    // showHomeScreen:
    //   - print app title and welcome message
    //   - print:
    //       1) New Order
    //       0) Exit
    //   - prompt user for choice
    //   - return user input
    public void showHomeScreen() {
        boolean running = true;

        while (running) {
            System.out.println("===== Welcome to Mars Sandwich Station =====");
            System.out.println("(1) New Order");
            System.out.println("(0) Exit");
            System.out.print("Please enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Order order = new Order();
                    showOrderMenu(order);
                    break;
                case "0":
                    System.out.println("Thank you for using Mars Sandwich Station... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter 1 to place a new order or 0 to exit application. Please try again.");
            }
        }
    }

    // showOrderMenu:
    //   - print:
    //       1) Add Sandwich
    //       2) Add Drink
    //       3) Add Chips
    //       4) Checkout
    //       0) Cancel Order
    //   - prompt user for choice
    //   - return user input
    private void showOrderMenu(Order order) {
        boolean running = true;

        while (running) {
            System.out.println("\n==== Order Menu ====");
            System.out.println("(1) Add Sandwich");
            System.out.println("(2) Add Drink");
            System.out.println("(3) Add Chips");
            System.out.println("(4) Checkout");
            System.out.println("(0) Cancel Order");

            System.out.print("Enter Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    //add sandwich
                    break;
                case "2":
                    // add drink
                    break;
                case "3":
                    // add chips
                    break;
                case "4":
                    // checkout
                    break;
                case "0":
                    System.out.println("Your order is canceled.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-4 or 0 to cancel. Please try again.");
            }
        }
    }

    // promptForBreadType:
    //   - print list of bread types
    //   - ask user to type one in (e.g., "white")
    //   - return as user input

    // promptForSize:
    //   - ask user: "What size? (4, 8, or 12 inches)"
    //   - return user input

    // promptForToasted:
    //   - ask: "Would you like it toasted? (yes or no)"
    //   - return user input

    // promptForMeats:
    //   - possible loop (one or multiple meats?):
    //       - ask user to type of meat (or 'done' to finish)
    //       - ask if they want Extra meat? (yes or no)"
    //   - return list of meats and extras

    // and so on and so on........
}
