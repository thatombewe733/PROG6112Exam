/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mattresssales;

/**
 *
 * @author thato
 */
public class PrintProduct {

    private final Product product;

    public PrintProduct(Product product) {
        this.product = product;
    }

    //Prints the report title and the line of stars
    public void printHeader() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println("******************************************");
    }

    /** Prints the total number of products sold. */
    public void printTotalProductSales() {
        System.out.println("TOTAL product sales:" + product.GetTotalProductsSold());
    }

    /** Prints the average products sold, rounded to a whole number as in the sample. */
    public void printAverageProductSales() {
        System.out.println("average product sales:" + Math.round(product.GetAverageProductSold()));
    }

    /** Prints the most popular product with its total sales in brackets. */
    public void printMostPopularProduct() {
        System.out.println("most popular product:" + product.GetMostPopularProduct()
                + "(" + product.GetMostPopularProductSales() + ")");
    }
}    

