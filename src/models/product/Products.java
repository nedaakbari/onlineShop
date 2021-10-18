package models.product;

import enums.ProductLine;

public class Products {
    private int id;
    private ProductLine line;
    private String type;
    private double eachPrice;
    private int capacity;
    private String info;

    public Products() {
    }

    public Products(int id) {
        this.id = id;
    }

    public Products(String type, double eachPrice) {
        this.type = type;
        this.eachPrice = eachPrice;
    }

    public Products(int id, ProductLine line, String type, double eachPrice, int capacity, String info) {
        this.id = id;
        this.line = line;
        this.type = type;
        this.eachPrice = eachPrice;
        this.capacity = capacity;
        this.info = info;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String print() {
        return " type:"+this.type + " ," + "eachPrice:"+ this.eachPrice;
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", line=" + line +
                ", type='" + type + '\'' +
                ", eachPrice=" + eachPrice +
                ", capacity=" + capacity +
                ", info='" + info + '\'' +
                '}';
    }
}
