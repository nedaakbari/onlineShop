package DataAccess;

import models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDao extends BaseDataAccess {
    public CustomerDao() {
    }

    public int save(Customer customer) throws SQLException {
        if (connection != null) {
            String query = "INSERT INTO customers( `customerName`, `customerLastName`, `nationalCode`, `phone`, `registerdate`, `creditLimit`, `shoppingCount`) VALUES (?, ?, ?,?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getFamily());
            statement.setString(3, customer.getNatioanalCode());
            statement.setString(4, customer.getPhone());
            statement.setDate(5, customer.getRegisterDate());
            statement.setDouble(6, customer.getBalance());
            statement.setInt(7, customer.getShoppingCount());
            statement.executeUpdate();
        }
        return 0;
    }


    public Customer findCustomerByNationalCode(String nationalCode) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers where nationalCode='" + nationalCode + "';");
            while (resultSet.next()) {
                //int id, String name, String family, double balance,String natioanalCode, int shoppingCount
                int id = resultSet.getInt("customerId");
                String customerName = resultSet.getString("customerName");
                String customerLastName = resultSet.getString("customerLastName");
                double creditLimit = resultSet.getDouble("creditLimit");
                int shoppingCount = resultSet.getInt("shoppingCount");
                Customer findCustomer = new Customer(id, nationalCode, customerName, customerLastName, creditLimit, shoppingCount);
                /*Customer findCustomer = new Customer();
                findCustomer.setId(resultSet.getInt("customerId"));
                findCustomer.setName(resultSet.getString("customerName"));
                findCustomer.setFamily(resultSet.getString("customerLastName"));
                findCustomer.setBalance(resultSet.getDouble("creditLimit"));
                findCustomer.setNatioanalCode(resultSet.getString("nationalCode"));
                findCustomer.setShoppingCount(resultSet.getInt("shoppingCount"));*/
                return findCustomer;
            }
        }
        return null;
    }


    public int UpdateCustomerBalance(String nationalCode, double amount) throws SQLException {
        if (connection != null) {
            String sql = "UPDATE customers SET creditLimit = creditLimit + ?  WHERE nationalCode = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, amount);
            statement.setString(2, nationalCode);
            int i = statement.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }


    public int getshoppingCountsOfCustomer(int customerId) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT shoppingCount FROM customers where customerId='" + customerId + "';");
            int shoppingCounts = 0;
            while (resultSet.next()) {
                //int id, String name, String family, double balance,String natioanalCode, int shoppingCount
                shoppingCounts = resultSet.getInt("shoppingCount");
            }
            return shoppingCounts;
        }
        return 0;
    }

    public int UpdateCustomerBuyNumber(int customerId, int capacity) throws SQLException {
        if (connection != null) {
            String sql = "UPDATE customers SET shoppingCount = shoppingCount + ?  WHERE customerId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, capacity);
            statement.setInt(2, customerId);
            int i = statement.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }


    public List<Customer> findAllCustomer() throws SQLException {
        if (connection != null) {
            List<Customer> customerList = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" SELECT * FROM customers;");
            while (resultSet.next()) {
                int id = resultSet.getInt("customerId");
                String customerName = resultSet.getString("customerName");
                String customerLastName = resultSet.getString("customerLastName");
                String nationalCode = resultSet.getString("nationalcode");
                String phone = resultSet.getString("phone");
                Date registerdate = resultSet.getDate("registerdate");
                double creditLimit = resultSet.getDouble("creditLimit");
                int shoppingCount = resultSet.getInt("shoppingCount");
                Customer customer = new Customer(id, nationalCode, customerName, customerLastName, phone, registerdate, creditLimit, shoppingCount);
                customerList.add(customer);

            }
            return customerList;
        }
        return Collections.emptyList();
    }


}
