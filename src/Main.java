import enums.UserRole;
import models.Customer;
import Serveces.CustomerService;
import Serveces.ProductService;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService;
    private static ProductService productService;


    public static void main(String[] args) throws SQLException {

        System.out.println(" .افزودن محصول به سبد خرید\n" +
                "2 .حذف محصول از سبد خرید\n" +
                "3 .چاپ لیست کلیه محصوالت اضافه شده به سبد خرید به همراه تعداد آ نها\n" +
                "4 .چاپ مجموعه قیمت های آیتم های سبد خرید\n" +
                "5 .تایید نهایی خرید با تایید کاربر\n" +
                "6 .همچنین موجودی فروشگاه متناسب با تعداد موارد خریداری شده بروزرسانی شود.");
        System.out.println("********* Wellcome *********" +
                "\nEnter your role 1.manager 2.customer");
        String role = scanner.next();
        UserRole userRole = UserRole.getValue(role);
        switch (userRole) {
            case MANAGER:
              /*  productService.saveproductLine();
                System.out.println("Enter type of state do you want to add: ");
                String
                System.out.println("shoeType: 1.sport   quantity,EachPrice  2.formal   quantity,EachPrice");

                productService.saveProduct(new Product(ProductLine.SHOETYPE,ShoeType.sport.toString(),sport,));*/
                break;
            case CUSTOMER:

                System.out.println(" 1. register" +
                        "\nname,family,nationalCode,phone" +
                        "\n2.login");
                int choose = scanner.nextInt();
                switch (choose) {

                    case 1:
                        String input = scanner.nextLine();
                        String[] split = input.split(",");
                        String name = split[0];
                        String family = split[1];
                        String nationalCode = split[2];
                        String phone = split[3];
                        double balance = 0;
                        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                        Customer customer = new Customer(name, family, nationalCode, phone, date, balance);
                        if (customerService.saveCustomer(customer) == 1) {
                            System.out.println("your information register successfully");
                        } else {
                            System.out.println("you already register... login");
                        }
                        break;
                    case 2:
                        System.out.println("Enter your nationalCode");
                        String enetrNationalToFind = scanner.next();
                        Customer customerFound = customerService.findCustomerByNationalCode(enetrNationalToFind);
                        System.out.println("wellcome" + customerFound.getName() + customerFound.getFamily());
                        while (true) {
                            System.out.println("\n1.increase to your crediCard(balance)" + "2.show all product +" +
                                    "\n3.adding to your shoppingCart" + "\n4.delete product from your shoppingCart\n5.Exit");
                            int choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("you have amount" + customerFound.getBalance() + " in your creditcart" + "\n for increse your balance intert your amount ");
                                    double increaseBalance = scanner.nextDouble();
                                    customerService.updateCreditCart(customerFound.getNatioanalCode(), increaseBalance);
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


                System.out.println("choose one:" +
                        "\n1.adding to your shoppingCart" +
                        "\n2.delete product from your shoppingCart" +
                        "\n3.adding to ");


                customerService = new CustomerService();

                showList(customerService.getAll());


        }

    }

    private static void showList(List list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

}
