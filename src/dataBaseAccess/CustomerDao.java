package dataBaseAccess;

import models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDao extends BaseDao {
    public CustomerDao() {
    }


    public int save(Customer customer) throws SQLException {
        String query = "INSERT INTO `shop`.`customers` (`customerName`, `customerLastName`, `phone`,`registerdate`, `creditLimit`) VALUES (?, ?, ?, ?,?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getFamily());
        statement.setString(3, customer.getPhone());
        statement.setDate(4, customer.getRegisterDate());
        statement.setDouble(5, customer.getBalance());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            return rowsInserted;
        }
        return 0;
    }


    public Customer findCustomerByNationalCode(String nationalCode) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT customerName,customerLastName,creditLimit FROM customer where nationalCode='" + nationalCode + "';");
            while (resultSet.next()) {
                Customer findCustomer = new Customer();
                findCustomer.setName(resultSet.getString("customerName"));
                findCustomer.setFamily(resultSet.getString("customerLastName"));
                findCustomer.setBalance(resultSet.getDouble("creditLimit"));

                return findCustomer;
            }
        }
        return null;
    }


/*    public Customer findCustomerByNationalCode(String nationalCode) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer where nationalCode='" + nationalCode + "';");
            while (resultSet.next()) {
                Customer findCustomer = new Customer();
                findCustomer.setName(resultSet.getString("customerName"));
                findCustomer.setFamily(resultSet.getString("customerLastName"));
                findCustomer.setNatioanalCode(resultSet.getString("nationalcode"));
                findCustomer.setPhone(resultSet.getString("phone"));
                findCustomer.setRegisterDate(resultSet.getDate("registerdate"));
                findCustomer.setBalance(resultSet.getDouble("creditLimit"));

                return findCustomer;
            }
        }
        return null;
    }*/


    public int UpdateCustomerBalance(String nationalCode, double amount) throws SQLException {
        if (connection != null) {
            String sql = "UPDATE customer SET creditLimit = creditLimit + ?  WHERE nationalCode = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, amount);
            statement.setString(2, nationalCode);
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
            ResultSet resultSet = statement.executeQuery(" SELECT * FROM shop.customers;");
            while (resultSet.next()) {
                int id = resultSet.getInt("customerId");
                String customerName = resultSet.getString("customerName");
                String nationalCode = resultSet.getString("nationalcode");
                String customerLastName = resultSet.getString("customerLastName");
                String phone = resultSet.getString("phone");
                Date registerdate = resultSet.getDate("registerdate");
                double creditLimit = resultSet.getDouble("creditLimit");
                Customer customer = new Customer(id, customerName, customerLastName, nationalCode, phone, registerdate, creditLimit);
                customerList.add(customer);

            }
            return customerList;
        }
        return Collections.emptyList();
    }


}
