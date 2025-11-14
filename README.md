# Capstone Project 2: Mars Sandwich Station
## 🪐 Mars Sandwich Station 🪐
My Capstone 2 Project is a Java based console line interface (CLI) 
point of sales application, a custom sandwich shop, that will allow 
users to fully customize their sandwich orders.

## Project Features
### Creating at the Sandwich Station

- Choose Bread Type
- Choose Sandwich Size
- Option for Toasted Sandwich (yes/no)
- Choose Meat(s) (extra option available)
- Choose Cheeses (extra option available)
- Choose Toppings
- Sandwich Price Calculation Provided

### Drinks
- Choose Drink Size (Small, Medium, Large)
- Choose Flavor of Drink
- Drink Price Calculation Provided

### Chips
- Choose your choice of Chips

### Signature Sandwich of the Day
- Reuben Signature Sandwich option
- Customer has ability to customize their signature sandwich

### Process Your Order
- User can add multiple sandwiches, drinks, or chips to order
- Price Calculations Provided
- Checkout with confirmation and cancellation option

### Receipt 
- Saves receipt to `src/main/resources/receipts/` folder as '.txt' file
- Filename includes date and timestamp (yyyyMMdd-HHmmss.txt)
- Displays : 
  - All Order Items
  - Item Summaries
  - Prices
  - Total Order Price

### Advanced OOP - Polymorphism
Mars Sandwich Station project uses **abstract class** :`OrderItem` with the child classes being `Sandwich`, `Drink`, and `Chips`.

### Project Structure 
UML Class Diagram : 
![MarsSandwichStationUMLFinal.webp](diagrams/MarsSandwichStationUMLFinal.webp)


### Console Design
- Styled menu's with borders and symbols for a polished and easy to read
CLI.
- Displays messages with confirming successful actions to improve the user experience.

### Application Screens
A walkthrough of the screens in Mars Sandwich Station: 
- Home Screen Menu
![cap2homescreenmenu.png](diagrams/cap2homescreenmenu.png)
- When user chooses to create a new order, they are led to the Order Menu
![cap2ordermenu.png](diagrams/cap2ordermenu.png)
- Add Sandwich Prompts
  - Bread Type
    ![cap2addsandwichbreadtypemenu.png](diagrams/cap2addsandwichbreadtypemenu.png)
  - Sandwich Size
    ![cap2addsandwichsize.png](diagrams/cap2addsandwichsize.png)
  - Toasted Option
    ![cap2addsandwichtoasted.png](diagrams/cap2addsandwichtoasted.png)
  - Meat Menu
    ![cap2addsandwichmeatmenu.png](diagrams/cap2addsandwichmeatmenu.png)
    ![cap2addsandwichextrameat.png](diagrams/cap2addsandwichextrameat.png)
  - Cheese Menu
    ![cap2addsandwichcheesemenu.png](diagrams/cap2addsandwichcheesemenu.png)
    ![cap2extracheese.png](diagrams/cap2extracheese.png)
  - Toppings Menu
    ![cap2toppingsmenu.png](diagrams/cap2toppingsmenu.png)
  - Sauces Menu
    ![cap2addsaucesmenu.png](diagrams/cap2addsaucesmenu.png)
- Add Drink Prompts
  - Drink Size
    ![cap2drinksize.png](diagrams/cap2drinksize.png)
  - Drink Flavor
    ![cap2addflavormenu.png](diagrams/cap2addflavormenu.png)
- Add Chips Menu
  ![cap2addchips.png](diagrams/cap2addchips.png)
- Add Signature Sandwich of the Day
  ![cap2signatureoftheday.png](diagrams/cap2signatureoftheday.png)

#### Resources
Emoji's throughout project are from [Emojicombos.com](https://emojicombos.com/sandwich)
