package View.impl;

import Model.Constants;
import Service.impl.OrderServiceImpl;
import View.Menuable;

import java.util.Scanner;

public class OrderMenu implements Menuable {
    boolean isRunning = true;
    private String[] items = {"1. Add product to order", "2. Order checkout status",
            "3. Show my order", "9. BACK", "0. EXIT"};
    private Scanner scanner;

    @Override
    public void showMenu() {
        System.out.println("HELLO BY ORDER MENU");
        showItems(items);
        scanner = new Scanner(System.in);
        System.out.println("PLEASE ENTER THE MENU NUMBER");

        while (isRunning) {
            int choice = scanner.nextInt();

            if (new Constants().ADD_PRODUCT_TO_ORDER == choice) {
                new OrderServiceImpl().addProductToMyOrder();
            } else if (new Constants().ORDER_CHECKOUT == choice) {
                new OrderServiceImpl().orderCheckoutStatus();
            } else if (new Constants().SHOW_MY_ORDER == choice) {
                new OrderServiceImpl().showMyOrder();
            } else if (new Constants().BACK == choice) {
                new ProductMenu().showMenu();
            } else if (new Constants().EXIT == choice) {
                exit();
            }
        }
        System.out.println("PLEASE ENTER THE MENU NUMBER");
    }

    @Override
    public void exit() {
        System.out.println("You exited!".toUpperCase());
        System.exit(0);
    }
}
