package service;

import dataBaseAccess.ProductDao;
import dataBaseAccess.ProductLineDao;
import enums.ProductLine;
import models.Product;

import java.sql.SQLException;

public class ProductDervice {
    private final ProductDao productDao;
    private final ProductLineDao productLineDao;

    public ProductDervice() {
        productDao = new ProductDao();
        productLineDao = new ProductLineDao();
    }

    public void saveproductLine() throws SQLException {
        productLineDao.save(ProductLine.SHOETYPE);
        productLineDao.save(ProductLine.ElectronicTYPE);
        productLineDao.save(ProductLine.READABLETYPE);
    }
    public void saveProduct(Product product, int number)
}
