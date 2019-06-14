package com.jainn.shopping;

@lombok.Data
public class Product {

    private String productName;
    private int quantity;
    private double totalPrice;

    public Product(String productName, int quantity, double totalPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
