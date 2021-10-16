import enums.UserRole;
import models.Customer;
import Serveces.CustomerService;
import Serveces.ProductService;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static CustomerService customerService = new CustomerService();
    private static ProductService productService = new ProductService();


    //sara,gharaee,2560266752,091177326041
    public static void main(String[] args) throws SQLException {
        showMenue();
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
                    Customer customerFound = customerService.findCustomerByNationalCode(enetrNationalToFind);
                    System.out.println("wellcome " + customerFound.getName() + customerFound.getFamily());
                    while (true) {
                        System.out.println("\n1.increase to your crediCard(balance)" + "\n2.show all product " +
                                "\n3.adding to your shoppingCart" + "\n4.delete product from your shoppingCart\n5.Exit");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("you have amount" + customerFound.getBalance() + " in your creditcart" + "\n for increase your balance intert your amount ");
                                double increaseBalance = scanner.nextDouble();
                                System.out.println(customerFound);
                                int i = customerService.updateCreditCart(customerFound.getNatioanalCode(), increaseBalance);
                                if (i > 0) {
                                    System.out.println("you have " + customerFound.getBalance()+increaseBalance);
                                } else {
                                    System.out.println("unseccess");
                                }
                                break;
                            case 2:
                                System.out.println();
                                showList(productService.getAllProduct());
                                break;
                            case 3:
                                break;
                            case 5:
                                break;
                        }
                    }//while

            }
        }


    }

    private static void showList(List list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }


    public static void addCustomer() throws SQLException {
        Scanner scanner11 = new Scanner(System.in);
        System.out.println("name,family,nationalCode,phone");
        String input = scanner11.nextLine();
        String[] split = input.split(",");
        String name = split[0];
        String family = split[1];
        String nationalCode = split[2];
        String phone = split[3];
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Customer customer = new Customer(name, family, nationalCode, phone, date);
        if (customerService.saveCustomer(customer) == 1) {
            System.out.println("your info register successFully");
        } else {
            System.out.println("you already register... login");
            showMenue();
        }
    }
}
