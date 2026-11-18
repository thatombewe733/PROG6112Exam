/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mattresssales;

/**
 *
 * @author thato
 */
public class Product implements IProduct {

    // Single-dimensional array: product names
    private final String[] productNames;
    // Two-dimensional array: sales for each product per month
    private final int[][] sales;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    /** Adds up every sale for every product. */
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int productTotal : calculateProductTotals()) {
            total += productTotal;
        }
        return total;
    }

    /** Total divided by the number of monthly sales figures (9 in the sample). */
    @Override
    public double GetAverageProductSold() {
        int entries = 0;
        for (int[] productSales : sales) {
            entries += productSales.length;
        }
        // Guard against division by zero when there is no data
        return entries == 0 ? 0 : (double) GetTotalProductsSold() / entries;
    }

    /** Name of the product with the highest total sales. */
    @Override
    public String GetMostPopularProduct() {
        int best = getMostPopularIndex();
        return best < 0 ? "No sales" : productNames[best];
    }

    /** Total sales of the most popular product (extra helper for the report). */
    public int GetMostPopularProductSales() {
        int best = getMostPopularIndex();
        return best < 0 ? 0 : calculateProductTotals()[best];
    }

    /** Adds up each product's row and stores it in a 1D array. */
    private int[] calculateProductTotals() {
        int[] totals = new int[sales.length];
        for (int product = 0; product < sales.length; product++) {
            for (int sale : sales[product]) {
                totals[product] += sale;
            }
        }
        return totals;
    }

    /** Index of the product with the highest total, or -1 if there is no data. */
    private int getMostPopularIndex() {
        int[] totals = calculateProductTotals();
        if (totals.length == 0) {
            return -1;
        }
        int best = 0;
        for (int i = 1; i < totals.length; i++) {
            if (totals[i] > totals[best]) {
                best = i;
            }
        }
        return best;
    }
} 

