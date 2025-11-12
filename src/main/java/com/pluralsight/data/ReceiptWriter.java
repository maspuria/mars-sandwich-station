package com.pluralsight.data;

import com.pluralsight.model.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveReceipt(Order order) {
        // generate filename using current date/time (yyyyMMdd-HHmmss.txt)
        String fileName = generateTimestamp() + ".txt";
        // create a FileWriter and wrap in BufferedWriter (src/main/resources/receipts)
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/receipts/" + fileName);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);

            // loop through all order items
            //   - write the items to the to reciept
            buffWriter.write(order.getOrderSummary());

            //write total cost
            buffWriter.newLine();
            buffWriter.write("Total: $" + String.format("%.2f",order.getTotal()));

            // close BufferedWriter
            buffWriter.close();
            System.out.println("\n Receipt successfully saved as: " + fileName);
        } catch (IOException e) {
            // handle IOException with error message
            System.out.println("\n Error saving receipt, please try again. Receipt not saved." + e.getMessage());
        }
    }

    private static String generateTimestamp() {
        // Create timestamp string using a formatter
        // return that string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String format = LocalDateTime.now().format(formatter);
        return format;
    }
}
