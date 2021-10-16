package models;

import enums.ProductLine;

public class Product {
    private int id;
    private String name;
    private ProductLine productLine;
    private int quantity;
    private double price;

    public Product(int id, String name, ProductLine productLine, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.productLine = productLine;
        this.quantity = quantity;
        this.price = price;
    }
}
