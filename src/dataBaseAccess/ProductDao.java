package dataBaseAccess;

import enums.ProductLine;
import models.Customer;
import models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDao extends BaseDao {
    public ProductDao() {
    }

//    private int saveproduct() throws SQLException {
//        String sql = "INSERT INTO `shop`.`products` (`productName`, `productLine`, `quantity`, `buyPrice`) VALUES (?, ?, ?, ?);";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString();
//        statement.executeUpdate();
//
//    }

    public List<Product> findAllProducts() throws SQLException {
        if (connection != null) {
            List<Product> products = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shop.products;");
            while (resultSet.next()) {
                int id = resultSet.getInt("productId");
                String productName = resultSet.getString("productName");
                String productLine = resultSet.getString("productLine");
                ProductLine line = ProductLine.getValue(productLine);
                int quantity = resultSet.getInt("quantity");
                double eachPrice = resultSet.getDouble("EachPrice");
                Product product = new Product(id, productName, line, quantity, eachPrice);
                products.add(product);
            }
            return products;
        }
        return Collections.emptyList();
    }


}
