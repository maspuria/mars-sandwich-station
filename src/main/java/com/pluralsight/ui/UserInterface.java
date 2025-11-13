package com.pluralsight.ui;

import com.pluralsight.data.ReceiptWriter;
import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;

import java.util.Scanner;

public class UserInterface {
    // declare a Scanner object for reading input from the console
    private final Scanner scanner = new Scanner(System.in);

    // showHomeScreen:
    //   - print app title and welcome message
    //   - print:
    //       1) New Order
    //       0) Exit
    //   - prompt user for choice
    //   - return user input
    public void showHomeScreen() {
        boolean running = true;

        while (running) { // 🪐
            System.out.println("\n \uD83E\uDE90 Welcome to Mars Sandwich Station \uD83E\uDE90");
            System.out.println("\n ╔═══════ Home Screen Menu ═════╗");
            System.out.println(" ║ (1) New Order");
            System.out.println(" ║ (0) Exit");
            System.out.println(" ╚══════════════════════════════╝");
            System.out.print("Please enter your choice: ");

            String choice = scanner.nextLine().trim();

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
    public void showOrderMenu(Order order) {
        boolean running = true;

        while (running) {
            System.out.println("\n ╔═══════ Order Menu ═════╗");
            System.out.println(" ║ [1] Add Sandwich");
            System.out.println(" ║ [2] Add Drink");
            System.out.println(" ║ [3] Add Chips");
            System.out.println(" ║ [4] Checkout");
            System.out.println(" ║ [0] Cancel Order");
            System.out.println(" ╚════════════════════════╝");
            System.out.print("Enter Choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    //add sandwich
                    Sandwich sandwich = promptForSandwich();
                    order.addItem(sandwich);
                    System.out.println("\n------------------------------------------------------------");
                    System.out.println("               Successfully added Sandwich!");
                    System.out.println(sandwich.getSummary());
                    System.out.println("\n------------------------------------------------------------");
                    break;
                case "2":
                    //addDrink
                    Drink drink = promptForDrink();
                    order.addItem(drink);
                    System.out.println("\n------------------------------------------------------------");
                    System.out.println("               Successfully added Drink!");
                    System.out.println(drink.getSummary());
                    System.out.println("\n------------------------------------------------------------");
                    break;
                case "3":
                    //addChips
                    Chips chips = promptForChips();
                    order.addItem(chips);
                    System.out.println("\n------------------------------------------------------------");
                    System.out.println("               Successfully added Chips!");
                    System.out.println(chips.getSummary());
                    System.out.println("------------------------------------------------------------");
                    break;
                case "4": // Checkout Option - confirm or cancel
                    System.out.println(order.getOrderSummary());

                    System.out.println("\nWould you like to confirm your order(yes/no): ");
                    String confirmOrder = scanner.nextLine().trim();

                    if (confirmOrder.equalsIgnoreCase("yes")) {
                        ReceiptWriter.saveReceipt(order); //saving your receipt order to new file
                        System.out.println("\n Your order is complete and receipt is saved! Thank you for ordering at Mars Sandwich Station!!");
                    } else {
                        System.out.println("\n Your order is canceled. Returning to Home Screen Menu...");
                    }
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

    //promptForSandwich:
    public Sandwich promptForSandwich() {
        Sandwich sandwich = new Sandwich();

        System.out.println("\n===== Time to Create Your Sandwich! =====");
        // Set the bread type and prompt user for bread type
        sandwich.setBreadType(promptForBreadType());

        // set the sandwich size and prompt user for sandwich size
        int sandwichSize = promptForSandwichSize();
        sandwich.setSandwichSize(sandwichSize);
        sandwich.setBasePriceSandwichSize();

        // prompt user if they want their sandwich toasted
        sandwich.setToasted(promptForToasted());

        promptForMeats(sandwich); //prompt user for the meats
        promptForCheeses(sandwich); //prompt user for the cheeses
        promptForToppings(sandwich); //prompt user for toppings
        promptForSauces(sandwich); //prompt user for the sauces

        return sandwich;
    }

    // promptForBreadType:
    //   - print list of bread types
    //   - ask user to type one in (e.g., "white")
    //   - return as user input
    public String promptForBreadType() {
//        System.out.println("Choose Bread Type: ");
//        System.out.println(" - white ");
//        System.out.println(" - wheat ");
//        System.out.println(" - rye ");
//        System.out.println(" - wrap ");
//        System.out.println("Enter your choice of bread: ");
//        return scanner.nextLine().trim();
        String breadType="";
        while (true) {
            System.out.println("\n ╔═══════ Choose Bread Type ═════╗");
            System.out.println(" ║  [1] White ");
            System.out.println(" ║  [2] Wheat ");
            System.out.println(" ║  [3] Rye ");
            System.out.println(" ║  [4] Wrap ");
            System.out.println(" ╚═══════════════════════════════╝");
            System.out.print("Enter your choice of bread: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case"1":
                    breadType = "White";
                    break;
                case"2":
                    breadType = "Wheat";
                    break;
                case"3":
                    breadType = "Rye";
                    break;
                case"4":
                    breadType = "Wrap";
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-4. Please try again.");
                    continue;
            }
            return breadType;
        }
    }

    // promptForSandwichSize:
    //   - ask user: "What size? (4, 8, or 12 inches)"
    //   - return user input
    public int promptForSandwichSize() {
        while (true) {
            System.out.println("\n ╔═══════ Sandwich Size ═════╗");
            System.out.println(" ║ - 4 inches ");
            System.out.println(" ║ - 8 inches ");
            System.out.println(" ║ - 12 inches ");
            System.out.println(" ╚═══════════════════════════╝");
            System.out.println("What size would you like?");
            System.out.print("Enter choice(4, 8, or 12): ");

            String userInput = scanner.nextLine().trim();

            try {
                int sandwichSize = Integer.parseInt(userInput);

                if (sandwichSize == 4 || sandwichSize == 8 || sandwichSize == 12) {
                    return sandwichSize;
                } else {
                    System.out.println("Invalid choice. Enter 4, 8, or 12. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number: 4, 8, or 12. Please try again.");
            }
        }
    }

    // promptForToasted:
    //   - ask: "Would you like it toasted? (yes or no)"
    //   - return user input
    public boolean promptForToasted() {
        System.out.println("\nWould you like your sandwich toasted? (yes/no)");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("yes");
    }

    // promptForMeats:
    //   - possible loop (one or multiple meats?):
    //       - ask user to type of meat (or 'done' to finish)
    //       - ask if they want Extra meat? (yes or no)
    //   - return list of meats and extras
    public void promptForMeats(Sandwich sandwich) {

        while (true) {
            System.out.println("\n ╔═══════ Meat Menu ═════════╗");
            System.out.println(" ║  [1] Steak");
            System.out.println(" ║  [2] Ham");
            System.out.println(" ║  [3] Salami");
            System.out.println(" ║  [4] Roast Beef");
            System.out.println(" ║  [5] Chicken");
            System.out.println(" ║  [6] Bacon");
            System.out.println(" ║  [0] Done Adding Meat");
            System.out.println(" ╚═══════════════════════════╝");
            System.out.print(" Enter choice: ");

            String meatChoice = scanner.nextLine().trim();
            String meat;

            switch (meatChoice) {
                case "1":
                    meat = "Steak";
                    break;
                case "2":
                    meat = "Ham";
                    break;
                case "3":
                    meat = "Salami";
                    break;
                case "4":
                    meat = "Roast Beef";
                    break;
                case "5":
                    meat = "Chicken";
                    break;
                case "6":
                    meat = "Bacon";
                    break;
                case "0":
                    System.out.println("\nFinished adding meats to your sandwich!");
                    return;
                default:
                    System.out.println("\nInvalid choice. Enter 1-6 or 0 to finish adding your meats. Please, try again.");
                    continue; // so the user can add more meats if they so desire
            }
            //       - ask if they want Extra meat? (yes or no)
            System.out.print("\n Would you like to add Extra of this meat?(yes/no): ");
            boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");

            sandwich.addMeat(meat, extraMeat);

            // confirmation message to user on what meats and extra meats they chose
            if (extraMeat) {
                System.out.println("\n Successfully added: " + meat + " (Extra)");
            } else {
                System.out.println("\n Successfully added: " + meat);
            }
        }
    }
    //promptForDrink
    public Drink promptForDrink() {
        // Drink Size Menu
        String drinkSize;
        while (true) {
            System.out.println("\n ╔════ Drink Size ═══╗");
            System.out.println(" ║ [1] Small");
            System.out.println(" ║ [2] Medium");
            System.out.println(" ║ [3] Large");
            System.out.println(" ╚═══════════════════╝");
            System.out.print("Enter Choice: ");

            String sizeInput = scanner.nextLine().trim();

            try {
                int choice= Integer.parseInt(sizeInput);
                switch (choice) {
                    case 1:
                        drinkSize = "Small";
                        break;
                    case 2:
                        drinkSize = "Medium";
                        break;
                    case 3:
                        drinkSize = "Large";
                        break;
                    default:
                        System.out.println("Invalid number. Please enter 1, 2, or 3");
                        continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number 1, 2, or 3.");
            }
        }
        // Drink Flavor Menu
        String flavor;

        while (true) {
            System.out.println("\n ╔═══════ Flavor Menu ════════╗");
            System.out.println(" ║ [1] Coke");
            System.out.println(" ║ [2] Sprite");
            System.out.println(" ║ [3] Lemonade");
            System.out.println(" ║ [4] Unsweetened Iced Tea");
            System.out.println(" ║ [5] Sweetened Iced Tea");
            System.out.println(" ║ [6] Water");
            System.out.println(" ╚════════════════════════════╝");
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
                    System.out.println("\nInvalid Choice. Enter a number 1-6 for choice of flavor. Please try again.");
                    continue;
            }
            break;
        }
        return new Drink(drinkSize, flavor);
    }

    //promptForChipType:
    public Chips promptForChips() {
        while(true){
            System.out.println("\n ╔═══════ Chips Menu ══════════════════╗");
            System.out.println(" ║ [1] Potato Chips");
            System.out.println(" ║ [2] SunChips Tomato Basil & Cheese");
            System.out.println(" ║ [3] Doritos Cool Ranch");
            System.out.println(" ║ [4] Baked Hot Cheetos");
            System.out.println(" ║ [5] Pringles");
            System.out.println(" ╚═════════════════════════════════════╝");
            System.out.print("Enter choice of chips: ");
            String choice = scanner.nextLine().trim();

            String typeOfChip;
            switch (choice) {
                case "1":
                    typeOfChip = "Potato Chips";
                    break;
                case "2":
                    typeOfChip = "SunChips Tomato Basil & Cheese";
                    break;
                case "3":
                    typeOfChip= "Doritos Cool Ranch";
                    break;
                case "4":
                    typeOfChip = "Baked Hot Cheetos";
                    break;
                case "5":
                    typeOfChip = "Pringles";
                    break;
                default:
                    System.out.println("\nInvalid Choice. Enter a number 1-5 for choice of chips. Please try again.");
                    continue;
            }
            Chips chips = new Chips(typeOfChip);
            return chips;
        }
    }

    //promptForCheese:
    public void promptForCheeses(Sandwich sandwich) {

        while (true) {
            System.out.println("\n ╔═══════ Cheese Menu ════════╗");
            System.out.println(" ║ [1] American");
            System.out.println(" ║ [2] Provolone");
            System.out.println(" ║ [3] Cheddar");
            System.out.println(" ║ [4] Swiss");
            System.out.println(" ║ [0] Done Adding Cheese");
            System.out.println(" ╚════════════════════════════╝");
            System.out.print(" Enter choice: ");

            String cheeseChoice = scanner.nextLine().trim();
            String cheese;

            switch (cheeseChoice) {
                case "1":
                    cheese = "American";
                    break;
                case "2":
                    cheese = "Provolone";
                    break;
                case "3":
                    cheese = "Cheddar";
                    break;
                case "4":
                    cheese = "Swiss";
                    break;
                case "0":
                    System.out.println("\nFinished adding cheese to your sandwich!");
                    return;
                default:
                    System.out.println("\nInvalid choice. Enter 1-4 or 0 to finish adding your cheeses. Please, try again.");
                    continue;
            }
            System.out.print("\n Would you like to add Extra of this cheese?(yes/no): ");
            boolean extraCheese = scanner.nextLine().equalsIgnoreCase("yes");

            sandwich.addCheese(cheese, extraCheese); //adding cheese choices to your sandwich

            if (extraCheese) {
                System.out.println("\n Successfully added: " + cheese + " (Extra)");
            } else {
                System.out.println("\n Successfully added: " + cheese);
            }
        }
    }

    //promptForTopping:
    public void promptForToppings(Sandwich sandwich) {

        while (true) {
            System.out.println("\n ╔═══════ Toppings (Included) ═══════╗");
            System.out.println(" ║ [1] Lettuce");
            System.out.println(" ║ [2] Peppers");
            System.out.println(" ║ [3] Onions");
            System.out.println(" ║ [4] Tomatoes");
            System.out.println(" ║ [5] Jalapeños");
            System.out.println(" ║ [6] Cucumbers");
            System.out.println(" ║ [7] Pickles");
            System.out.println(" ║ [8] Guacamole");
            System.out.println(" ║ [9] Mushrooms");
            System.out.println(" ║ [0] Done Adding Toppings");
            System.out.println(" ╚═══════════════════════════════════╝");
            System.out.print(" Enter choice: ");

            String toppingChoice = scanner.nextLine().trim();
            String topping;

            switch (toppingChoice) {
                case "1":
                    topping = "Lettuce";
                    break;
                case "2":
                    topping = "Peppers";
                    break;
                case "3":
                    topping = "Onions";
                    break;
                case "4":
                    topping = "Tomatoes";
                    break;
                case "5":
                    topping = "Jalapeños";
                case "6":
                    topping = "Cucumbers";
                    break;
                case "7":
                    topping = "Pickles";
                    break;
                case "8":
                    topping = "Guacamole";
                    break;
                case "9":
                    topping = "Mushrooms";
                    break;
                case "0":
                    System.out.println("\nFinished adding toppings to your sandwich!");
                    return;
                default:
                    System.out.println("\nInvalid choice. Enter 1-7 or 0 to finish adding your toppings. Please, try again.");
                    continue; // so the user can add more toppings if they so desire
            }
            sandwich.addTopping(topping);

            System.out.println("\n Successfully added toppings: " + topping);
        }
    }

    //promptForSauces:
    public void promptForSauces(Sandwich sandwich) {
        while (true) {
            System.out.println("\n ╔═══════ Sauces (Included) ═══════╗");
            System.out.println(" ║  [1] Mayo ");
            System.out.println(" ║  [2] Mustard");
            System.out.println(" ║  [3] Ketchup");
            System.out.println(" ║  [4] Ranch");
            System.out.println(" ║  [5] Thousand Island");
            System.out.println(" ║  [6] Vinaigrette");
            System.out.println(" ║  [7] Cup of Au Jus");
            System.out.println(" ║  [0] Done Adding Sauces");
            System.out.println(" ╚═════════════════════════════════╝");
            System.out.print(" Enter choice: ");

            String sauceChoice = scanner.nextLine().trim();
            String sauce = "";

            switch (sauceChoice) {
                case "1":
                    sauce = "Mayo";
                    break;
                case "2":
                    sauce = "Mustard";
                    break;
                case "3":
                    sauce = "Ketchup";
                    break;
                case "4":
                    sauce = "Ranch";
                    break;
                case "5":
                    sauce = "Thousand Island";
                case "6":
                    sauce = "Vinaigrette";
                    break;
                case "7":
                    sauce = "Cup of Au Jus";
                    break;
                case "0":
                    System.out.println("\nFinished adding sauces to your sandwich!");
                    return;
                default:
                    System.out.println("\nInvalid choice. Enter 1-6 or 0 to finish adding your sauces. Please, try again.");
                    continue; // so the user can add more sauces if they so desire
            }
            sandwich.addSauce(sauce);
            System.out.println("\nSuccessfully added: " + sauce); // confirmation
        }
    }
}
