package DataAccess;

import enums.ProductLine;
import models.Customer;
import models.product.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.ProductLine;
import models.product.Electronic;
import models.product.ReadableProduct;
import models.product.Shoe;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDao extends BaseDataAccess {

    public ProductDao() {
    }

    public List<Object> findAllProducts() throws SQLException {
        if (connection != null) {
            List<Object> AllProducts = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM electronic");

            while (resultSet1.next()) {
                int id = resultSet1.getInt("id");
                String productLine = resultSet1.getString("line");
                ProductLine line = ProductLine.getValue(productLine);
                String type = resultSet1.getString("type");
                String model = resultSet1.getString("model");
                String color = resultSet1.getString("color");
                double eachPrice = resultSet1.getDouble("eachPrice");
                int capacity = resultSet1.getInt("capacity");
                Electronic electronic = new Electronic(id, line, type, eachPrice, capacity, model, color);
                AllProducts.add(electronic);
            }

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM readable;");
            while (resultSet2.next()) {
                int id = resultSet2.getInt("id");
                String productLine = resultSet2.getString("line");
                ProductLine line = ProductLine.getValue(productLine);
                String type = resultSet2.getString("type");
                String title = resultSet2.getString("title");
                String publisher = resultSet2.getString("publisher");
                double eachPrice = resultSet2.getDouble("eachPrice");
                int capacity = resultSet2.getInt("capacity");
                ReadableProduct readableProduct = new ReadableProduct(id, line, type, eachPrice, capacity, title, publisher);
                AllProducts.add(readableProduct);
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM shoe");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productLine = resultSet.getString("line");
                ProductLine line = ProductLine.getValue(productLine);
                String type = resultSet.getString("type");
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                double eachPrice = resultSet.getDouble("eachPrice");
                int capacity = resultSet.getInt("capacity");
                Shoe shoe = new Shoe(id, line, type, eachPrice, capacity, model, color);
                AllProducts.add(shoe);

            }
            return AllProducts;

        }
        return Collections.emptyList();
    }


    public List<Electronic> findAllElectronics() throws SQLException {
        if (connection != null) {
            List<Electronic> electronics = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM electronic");

            while (resultSet1.next()) {
                int id = resultSet1.getInt("id");
                String productLine = resultSet1.getString("line");
                ProductLine line = ProductLine.getValue(productLine);
                String type = resultSet1.getString("type");
                String model = resultSet1.getString("model");
                String color = resultSet1.getString("color");
                double eachPrice = resultSet1.getDouble("eachPrice");
                int capacity = resultSet1.getInt("capacity");
                Electronic electronic = new Electronic(id, line, type, eachPrice, capacity, model, color);
                electronics.add(electronic);
            }
            return electronics;
        }
        return Collections.emptyList();
    }

    public List<ReadableProduct> findAllReadable() throws SQLException {
        if (connection != null) {
            List<ReadableProduct> readable = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM readable;");
            while (resultSet2.next()) {
                int id = resultSet2.getInt("id");
                String productLine = resultSet2.getString("line");
                ProductLine line = ProductLine.getValue(productLine);
                String type = resultSet2.getString("type");
                String title = resultSet2.getString("title");
                String publisher = resultSet2.getString("publisher");
                double eachPrice = resultSet2.getDouble("eachPrice");
                int capacity = resultSet2.getInt("capacity");
                ReadableProduct readableProduct = new ReadableProduct(id, line, type, eachPrice, capacity, title, publisher);
                readable.add(readableProduct);
            }
            return readable;
        }
        return Collections.emptyList();
    }

    public List<Shoe> findAllShoe() throws SQLException {
        if (connection != null) {
            List<Shoe> shoeList = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shoe");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productLine = resultSet.getString("line");
                ProductLine line = ProductLine.getValue(productLine);
                String type = resultSet.getString("type");
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                double eachPrice = resultSet.getDouble("eachPrice");
                int capacity = resultSet.getInt("capacity");
                Shoe shoe = new Shoe(id, line, type, eachPrice, capacity, model, color);
                shoeList.add(shoe);

            }
            return shoeList;
        }
        return Collections.emptyList();
    }


    public int findCapacity(int productId) throws SQLException {
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement("select capacity from product where id =?");
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();
            int capacity=0;
            while (resultSet.next()){
                capacity=resultSet.getInt("capacity");
            }
            return capacity;
        }
        return -1;
    }

    public int UpdateCapacity(int productId, int number) throws SQLException {
        if (connection != null) {
            String sql = "UPDATE product SET capacity = capacity - ?  WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, number);
            statement.setInt(2, productId);
            int i = statement.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }

    public List<Products> findProducts() throws SQLException {
        if (connection != null) {
            List<Products> products = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productLine = resultSet.getString("line");
                ProductLine line = ProductLine.getValue(productLine);
                String type = resultSet.getString("type");
                String info = resultSet.getString("info");
                double eachPrice = resultSet.getDouble("eachPrice");
                int capacity = resultSet.getInt("capacity");
                Products products1 = new Products(id, line, type, eachPrice, capacity, info);
                products.add(products1);
            }
            return products;
        }
        return Collections.emptyList();
    }


    public Products findProductById(int id) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product where id='" + id + "';");
            while (resultSet.next()) {

                int productId = resultSet.getInt("id");
                ProductLine line = ProductLine.getValue(resultSet.getString("line"));
                String type = resultSet.getString("type");
                String info = resultSet.getString("info");
                double eachPrice = resultSet.getDouble("eachPrice");
                int capacity = resultSet.getInt("capacity");
                Products findProducts = new Products(productId, line, type, eachPrice, capacity, info);
                return findProducts;
            }
        }
        return null;
    }
/*  public List<Products> findProducts() throws SQLException {
        if (connection != null) {
            List<Products> products = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT productId,lineName,productName,productColor,model,title,info,eachPrice,quantity FROM product\n" +
                    "inner join productline\n" +
                    "on productline.lineId=product.productLine;");
            while (resultSet.next()) {
                int id = resultSet.getInt("productId");
                String productLine = resultSet.getString("lineName");
                ProductLine line = ProductLine.getValue(productLine);
                String productName = resultSet.getString("productName");
                String productColor = resultSet.getString("productColor");
                String model = resultSet.getString("model");
                double eachPrice = resultSet.getDouble("eachPrice");
                int quantity = resultSet.getInt("quantity");
                Product product = new Product(id, productName, line, quantity, eachPrice);
                products.add(product);
            }
            return products;
        }
        return Collections.emptyList();
    }*/
    //    private int saveproduct() throws SQLException {
//        String sql = "INSERT INTO `shop`.`products` (`productName`, `productLine`, `quantity`, `buyPrice`) VALUES (?, ?, ?, ?);";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString();
//        statement.executeUpdate();
//
//    }

}