package DataAccess;

import enums.OrderStatus;
import models.Customer;
import models.Order;
import models.product.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDao extends BaseDataAccess {
    public OrderDao() {
    }


    public int save(Order order) throws SQLException {
        if (connection != null) {
            String query = " INSERT INTO orders( `customerId`, `productId`, `BuyNumberFromEach`, `status`, `costAll`) VALUES (?, ?, ?,?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, order.getCustomer().getId());
            statement.setInt(2, order.getProducts().getId());
            statement.setInt(3, order.getBuyNumberFromEach());
            String status = OrderStatus.value(order.getStatus());
            statement.setString(4, status);
            statement.setDouble(5, order.getCostAll());
            int rowIndex = statement.executeUpdate();
            if (rowIndex > 0) {
                System.out.println("your order add sussessfully");
            }
        }
        return 0;
    }


    public int deletOrderById(int getId) throws SQLException {
        if (connection != null) {
            String sql = "delete from orders  WHERE orderId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, getId);
        }
        return 0;
    }


    public int removeAllOrderById(int customerid) throws SQLException {
        if (connection != null) {
            String sql = "delete from orders where customerId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customerid);
        }
        return 0;
    }

   /* public int UpdateStatusOrder(int getId, OrderStatus orderStatus) throws SQLException {
        if (connection != null) {
            String sql = "UPDATE orders SET status = ?  WHERE orderId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            String status = OrderStatus.value(orderStatus);
            statement.setString(1, status);
            statement.setInt(2, getId);
            int i = statement.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }*/

   /* public Order findOrder(int getId) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where orderId = " + getId + ";");
            while (resultSet.next()) {
                int productId = resultSet.getInt("productId");
                Products products = new Products(productId);
                Order order = new Order(products);
                return order;
            }

        }
        return null;
    }*/


    public List<Order> findOrderOfCustomer(int customerId) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT orderId,type,eachPrice,BuyNumberFromEach,costAll FROM orders\n" +
                    " inner join product on orders.productId=product.id where customerId=" + customerId + ";");
            List<Order> orderList = new ArrayList<>();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("orderId");
                int BuyNumberFromEach = resultSet.getInt("BuyNumberFromEach");
                double costAll = resultSet.getDouble("costAll");
                String type = resultSet.getString("type");
                double eachPrice = resultSet.getDouble("eachPrice");
                Products products = new Products(type, eachPrice);
                Order foundorder = new Order(orderId, products, BuyNumberFromEach, costAll);
                orderList.add(foundorder);

            }
            return orderList;
        }
        return Collections.emptyList();
    }


    public double calculateCost(int customerId) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT customerId,costAll FROM orders where customerId=" + customerId + ";");
            double price = 0;
            while (resultSet.next()) {
                price += resultSet.getDouble("costAll");
            }
            return price;
        }
        return 0;
    }


    public Order findProductToincreaseBalance(int getId) throws SQLException {

        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where orderId=" + getId + ";");
            Order order = null;
            while (resultSet.next()) {
                int productId = resultSet.getInt("productId");
                Products products = new Products(productId);
                order = new Order(products);
            }
            return order;
        }
        return null;
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
