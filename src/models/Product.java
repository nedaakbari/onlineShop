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

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productLine=" + productLine +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
