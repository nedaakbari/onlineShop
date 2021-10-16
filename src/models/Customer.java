package models;

import models.product.Product;

import java.sql.Date;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String family;
    private Date registerDate;
    private double balance;
    private List<Product> BuyProductCapacity;

}
