package models;

import java.sql.Date;
import java.util.List;

public class Customer {
    private int id;
    private String natioanalCode;
    private String name;
    private String family;
    private String phone;
    private Date registerDate;
    private double balance;
    private final int maximumOrder = 5;
    private List<Product> BuyProductCapacity;

    public Customer() {
    }

    public Customer(int id, String natioanalCode, String name, String family, String phone, Date registerDate, double balance) {
        this.id = id;
        this.natioanalCode = natioanalCode;
        this.name = name;
        this.family = family;
        this.phone = phone;
        this.registerDate = registerDate;
        this.balance = balance;
    }

    public Customer(String natioanalCode, String name, String family, String phone, Date registerDate, double balance) {
        this.natioanalCode = natioanalCode;
        this.name = name;
        this.family = family;
        this.phone = phone;
        this.registerDate = registerDate;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNatioanalCode() {
        return natioanalCode;
    }

    public void setNatioanalCode(String natioanalCode) {
        this.natioanalCode = natioanalCode;
    }

    public int getMaximumOrder() {
        return maximumOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Product> getBuyProductCapacity() {
        return BuyProductCapacity;
    }

    public void setBuyProductCapacity(List<Product> buyProductCapacity) {
        BuyProductCapacity = buyProductCapacity;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "natioanalCode='" + natioanalCode + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", phone='" + phone + '\'' +
                ", registerDate=" + registerDate +
                ", balance=" + balance +
                '}';
    }
}
