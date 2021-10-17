import DataAccess.AddressDao;
import DataAccess.CustomerDao;
import DataAccess.ProductDao;
import models.Address;
import models.Customer;
import models.Order;
import models.product.Products;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Test {
    static AddressDao addressDao = new AddressDao();
    static CustomerDao customerDao = new CustomerDao();
    static ProductDao productDao = new ProductDao();

    public static void main(String[] args) throws SQLException {
        while (true) {
            showMenue();
        }
    }


    public static void showMenue() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("********* Wellcome *********");
            System.out.println("1.register\n2.login");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    scanner = new Scanner(System.in);
                    System.out.println("Enter your nationalCode");
                    String enetrNationalToFind = scanner.next();
                    Customer customerFound = customerDao.findCustomerByNationalCode(enetrNationalToFind);
                    System.out.println("*** wellcome " + customerFound.getName() + " " + customerFound.getFamily() + " ***");
                    while (true) {
                        System.out.println("\n1.increase to your crediCard(balance)" + "\n2.show products " +
                                "\n3.adding to your shoppingCart" + "\n4.delete product from your shoppingCart" + "\n5.confirm your shopping" + "\n6.Exit");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("you have amount " + customerFound.getBalance() + " in your creditcart" + "\n for increase your balance intert your amount ");
                                double increaseBalance = scanner.nextDouble();
                                System.out.println(customerFound);
                                int i = customerDao.UpdateCustomerBalance(customerFound.getNatioanalCode(), increaseBalance);
                                if (i > 0) {
                                    System.out.println("you have " + customerFound.getBalance() + increaseBalance);
                                } else {
                                    System.out.println("unSuccess");
                                }
                                break;
                            case 2:
                                System.out.println("which Line do you want to Buy?    1. Electronic    2.READABLE   3.SHOE   4. show all product  5.findProducts()");
                                scanner = new Scanner(System.in);
                                int case2input = scanner.nextInt();
                                switch (case2input) {
                                    case 1:
                                        System.out.println("               ********** Electronic  **********");
                                        showList(productDao.findAllElectronics());
                                        break;
                                    case 2:
                                        System.out.println("               ********** Readable  **********");
                                        showList(productDao.findAllReadable());
                                        break;
                                    case 3:
                                        System.out.println("               ********** shoe  **********");
                                        showList(productDao.findAllShoe());
                                        break;
                                    case 4:
                                        System.out.println("               ********** All Products  **********");
                                        showList(productDao.findAllProducts());
                                        break;
                                    case 5:
                                        System.out.println("                           ********** All Products  **********");
                                        showList(productDao.findProducts());
                                        break;
                                }//switch case2input

                            case 3:
                                addingToShoppingCart(customerFound);
                                break;
                        }//switch

                    }//while case 2


            }


        }//while
    }//showMenue()


    public static void addCustomer() throws SQLException {
        //sara,gharaee,222222222,0933333,tehran,tehran,pelak145
        Scanner scanner11 = new Scanner(System.in);
        System.out.println("name,family,nationalCode,phone    address: state,city,otherinfo");
        String input = scanner11.nextLine();
        String[] split = input.split(",");
        String name = split[0];
        String family = split[1];
        String nationalCode = split[2];
        String phone = split[3];
        String state = split[4];
        String city = split[5];
        String info = split[6];
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Address address = new Address(state, city, info);
        addressDao.save(address);
        Customer customer = new Customer(nationalCode, name, family, phone, date);
        if (customerDao.findCustomerByNationalCode(nationalCode) == null) {
            customerDao.save(customer);
            System.out.println("your info register successFully");
        } else {
            System.out.println("you already register... login");
            showMenue();
        }
    }

    private static void showList(List list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }


    public static void addingToShoppingCart(Customer customerFound) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int shoppingCount = customerFound.getShoppingCount();
        if (shoppingCount == 5) {
            System.out.println("your Shoppingcredit cart is full");
            showMenue();
        } else {
            System.out.println("you can buy " + (5 - shoppingCount) + " items");
            System.out.println("for adding to your credit cart insert id and number of each product:");
            while (shoppingCount <= 5) {
                String shop = scanner.nextLine();
                String[] shopping = shop.split(",");
                int productId = Integer.parseInt(shopping[0]);
                int number = Integer.parseInt(shopping[1]);
                if (productDao.findCapacity(productId) > number) {
                    productDao.UpdateCapacity(productId, number);
                    customerFound.setShoppingCount(customerFound.getShoppingCount() + number);
                    Products productById = productDao.findProductById(productId);
                    Order order = new Order(customerFound, productById, number, number * productById.getEachPrice());
                    shoppingCount+=number;
                } else {
                    System.out.println("your number is more than capacity Of this product");
                }

            }//while
        }//else


    }//addingToShoppingCart


    public static void deleteProductFromShoppingCart(Customer customerfound) {
    }//deleteProductFromShoppingCart


}// Test