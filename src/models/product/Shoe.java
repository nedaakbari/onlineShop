
package models.product;

import enums.ProductLine;

public class Shoe extends Product{
    private String color;
    private String model;

    public Shoe(int id, ProductLine line, String type, double eachPrice, int capacity, String color, String modol) {
        super(id, line, type, eachPrice, capacity);
        this.color = color;
        this.model = modol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "shoe{" +
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

