/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mattresssales;

/**
 *
 * @author thato
 */
import java.util.*;
public class MattressSales {
     
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Single-dimensional array: product names
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int months = 3;

        // Two-dimensional array: rows = products, columns = months
        int[][] sales = new int[products.length][months];

        // Ask the user for each month's sales for each product
        for (int product = 0; product < products.length; product++) {
            for (int month = 0; month < months; month++) {
                sales[product][month] = readSales(input, month + 1, products[product]);
            }
            System.out.println(); // blank line between products
        }

        // The Product class does all the calculations
        Product product = new Product(products, sales);

        // The PrintProduct class prints the report
        PrintProduct printer = new PrintProduct(product);
        printer.printHeader();
        printer.printTotalProductSales();
        printer.printAverageProductSales();
        printer.printMostPopularProduct();
    }

    /** Prompts for one month's sales and keeps asking until a valid number is typed. */
    private static int readSales(Scanner input, int month, String product) {
        while (true) {
            System.out.print("Enter the number of sales for month " + month
                    + " for " + product.toLowerCase() + " mattress:");
            if (input.hasNextInt()) {
                int value = input.nextInt();
                if (value >= 0) {
                    return value;
                }
            } else {
                input.next(); // discard the invalid text
            }
            System.out.println("Please enter a whole number of 0 or more.");
        }
    }
}