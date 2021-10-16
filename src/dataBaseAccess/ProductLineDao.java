/*
package dataBaseAccess;

import enums.ProductLine;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductLineDao extends BaseDao {
    public ProductLineDao() {
    }

    public int save(ProductLine productLine) throws SQLException {
        String query = "INSERT INTO `shop`.`productline` ( `productLineId`,`productLineName`) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, productLine.getId());
        statement.setString(2, productLine.getName());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new passeneger  inserted successfully!");
            return rowsInserted;
        }
        return 0;
    }
}*/
