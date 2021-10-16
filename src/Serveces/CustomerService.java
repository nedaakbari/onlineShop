package Serveces;

import dataBaseAccess.CustomerDao;
import dataBaseAccess.ProductDao;
import models.Customer;
import models.Product;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    private final CustomerDao customerDao = new CustomerDao();
    private final ProductDao productDao = new ProductDao();

    public CustomerService() {
    }

    public int saveCustomer(Customer customer) throws SQLException {
        if (findCustomerByNationalCode(customer.getNatioanalCode()) == null) {
            customerDao.save(customer);
            return 1;
        }
        return 0;
    }


    public void updateCreditCart(String nationalCode, double amount) throws SQLException {
        customerDao.UpdateCustomerBalance(nationalCode, amount);
    }

    public Customer findCustomerByNationalCode(String nationalCode) throws SQLException {
        return customerDao.findCustomerByNationalCode(nationalCode);
    }

    public List<Customer> getAll() throws SQLException {
        return customerDao.findAllCustomer();
    }

}




