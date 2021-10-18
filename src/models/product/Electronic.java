
package models.product;

import enums.ProductLine;

public class Electronic extends Product {
    private String model;
    private String color;

    public Electronic(int id, ProductLine line, String type, double eachPrice, int capacity, String model, String color) {
        super(id, line, type, eachPrice, capacity);
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "id=" + super.getId() +
                ", line=" + super.getLine() +
                ", type='" + super.getType() + '\'' +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", eachPrice=" + super.getEachPrice() +
                ", capacity=" + super.getCapacity() +
                '}';
    }





}


