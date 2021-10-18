package DataAccess;


import models.Address;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDao extends BaseDataAccess{


    public int save(Address address) throws SQLException {
        if (connection != null) {
            String query = "INSERT INTO `address` (`state`, `city`, `info`) VALUES (?, ?,?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, address.getState());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getAdditionalInfo());
            statement.executeUpdate();
        }

        return 0;
    }


}

