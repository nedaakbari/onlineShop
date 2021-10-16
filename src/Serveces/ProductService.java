package Serveces;

import dataBaseAccess.ProductDao;
import enums.ProductLine;
import models.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private final ProductDao productDao;


    public ProductService() {
        productDao = new ProductDao();
    }

    public List<Product> getAllProduct() throws SQLException {
        return productDao.findAllProducts();
    }

}
