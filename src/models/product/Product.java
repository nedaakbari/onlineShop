package models.product;

import enums.ProductLine;

public abstract class Product {
    private int id;
    private ProductLine line;
    private String type;
    private double eachPrice;
    private int capacity;


    public Product(int id, ProductLine line, String type, double eachPrice, int capacity) {
        this.id = id;
        this.line = line;
        this.type = type;
        this.eachPrice = eachPrice;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductLine getLine() {
        return line;
    }

    public void setLine(ProductLine line) {
        this.line = line;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getEachPrice() {
        return eachPrice;
    }

    public void setEachPrice(double eachPrice) {
        this.eachPrice = eachPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public abstract String toString();
}
