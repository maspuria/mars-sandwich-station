package com.pluralsight.data;

import com.pluralsight.model.Order;

public class ReceiptWriter {
    public static void saveReceipt(Order order) {
        // generate filename using current date/time (yyyyMMdd-HHmmss.txt)
        // create a FileWriter and wrap in BufferedWriter (src/main/resources/receipts)

        // loop through all order items
        //   - write the items to the to reciept

        //write total cost

        // close BufferedWriter
        // handle IOException with error message
    }

    private static String generateTimestamp() {
        // Create timestamp string useing a formatter
        // return that string
        return null; //temporary
    }
}
