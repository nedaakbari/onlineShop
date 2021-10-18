package models;

import enums.OrderStatus;
import models.product.Products;

public class Order {
    private int id;
    private Customer customer;
    private Products products;
    private int BuyNumberFromEach;
    private OrderStatus status;
    private double costAll;

    public Order(Products products) {
        this.products = products;
    }

    public Order(int id, Products products, int buyNumberFromEach, double costAll) {
        this.id = id;
        this.products = products;
        BuyNumberFromEach = buyNumberFromEach;
        this.costAll = costAll;
    }

    public Order(Customer customer, Products products, int buyNumberFromEach, double costAll) {

        this.customer = customer;
        this.products = products;
        BuyNumberFromEach = buyNumberFromEach;
        setStatus(OrderStatus.ONHOLD);
        this.costAll = costAll;
    }

    public Order(int id, Customer customer, Products products, int buyNumberFromEach, OrderStatus status, double costAll) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        BuyNumberFromEach = buyNumberFromEach;
        this.status = status;
        this.costAll = costAll;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getBuyNumberFromEach() {
        return BuyNumberFromEach;
    }

    public void setBuyNumberFromEach(int buyNumberFromEach) {
        BuyNumberFromEach = buyNumberFromEach;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getCostAll() {
        return costAll;
    }

    public void setCostAll(double costAll) {
        this.costAll = costAll;
    }

    @Override
    public String toString() {
        return
                "id=" + id +

                        ", products=" + products.print() +
                        ", BuyNumberFromEach=" + BuyNumberFromEach +
                        ", costAll=" + costAll;
    }
}
