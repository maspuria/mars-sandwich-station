package com.pluralsight.ui;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
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
            System.out.println("============================================");
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
                    //addDrink
                    Drink drink = promptForDrink();
                    order.addDrink(drink);
                    System.out.println("Successfully added Drink!");
                    break;
                case "3":
                    //addChips
                    Chips chips = promptForChips();
                    order.addChips(chips);
                    System.out.println("Successfully added Chips!");
                    break;
                case "4":
                    System.out.println(order.getOrderSummary());
                    // write receipt
                    // ReceiptWriter.saveReceipt(order);
                    System.out.println("Checkout Success! Receipt saved.");
                    System.out.println("\nThank you for ordering at Mars Sandwich Station! Returning to Home Screen Menu...");
                    running = false;
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
    private String promptForBreadType() {
        System.out.println("Choose Bread Type: ");
        System.out.println(" - white ");
        System.out.println(" - wheat ");
        System.out.println(" - rye ");
        System.out.println(" - wrap ");
        System.out.println("Enter your choice of bread: ");
        return scanner.nextLine();
    }

    // promptForSandwichSize:
    //   - ask user: "What size? (4, 8, or 12 inches)"
    //   - return user input
    private int promptForSandwichSize() {
        System.out.println("What size sandwich would you like?");
        System.out.println("Options: 4, 8, or 12 inches");
        System.out.print("Enter size choice(4, 8, or 12): ");
        return Integer.parseInt(scanner.nextLine());
    }

    // promptForToasted:
    //   - ask: "Would you like it toasted? (yes or no)"
    //   - return user input
    private boolean promptForToasted() {
        System.out.println("Would you like your sandwich toasted?");
        System.out.println("Please enter yes or no.");
        System.out.print("Enter toasted choice: ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("yes");
    }

    // promptForMeats:
    //   - possible loop (one or multiple meats?):
    //       - ask user to type of meat (or 'done' to finish)
    //       - ask if they want Extra meat? (yes or no)"
    //   - return list of meats and extras



    // and so on and so on........
    //promptForDrink
    public Drink promptForDrink() {

        // Drink Size Menu
        System.out.println("\n ==== Add Drink ====");
        System.out.print("Enter size (small, medium, or large): ");
        String drinkSize = scanner.nextLine();

        // Drink Flavor Menu
        String flavor = "";
        boolean running = true;

        while(true) {
            System.out.println("\n==== Flavor Menu =====");
            System.out.println(" [1] Coke ");
            System.out.println(" [2] Sprite ");
            System.out.println(" [3] Lemonade ");
            System.out.println(" [4] Unsweetened Iced Tea ");
            System.out.println(" [5] Sweetened Iced Tea ");
            System.out.println(" [6] Water ");
            System.out.print("Enter choice(1-6): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    flavor = "Coke";
                    break;
                case "2":
                    flavor = "Sprite";
                    break;
                case "3":
                    flavor = "Lemonade";
                    break;
                case "4":
                    flavor = "Unsweetened Iced Tea";
                    break;
                case "5":
                    flavor = "Sweetened Iced Tea";
                    break;
                case "6":
                    flavor = "Water";
                    break;
                default:
                    System.out.println("Invalid Choice. Enter a number 1-6 for choice of flavor. Please try again.");
                    running = false;
            }
            return new Drink(drinkSize,flavor);
        }
    }

    //promptForChipType:
    private Chips promptForChips() {
        System.out.println("\n ==== Add Chips ====");
        System.out.println(" - Potato Chips ");
        System.out.println(" - SunChips Tomato Basil & Cheese ");
        System.out.println(" - Doritos Cool Ranch");
        System.out.println(" - Baked Hot Cheetos ");
        System.out.println(" - Pringles");
        System.out.print("Enter choice of chips: ");
        String typeOfChip = scanner.nextLine();
        Chips chips = new Chips(typeOfChip);
        return chips;
    }

}
