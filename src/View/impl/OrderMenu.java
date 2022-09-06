package View.impl;

import Service.impl.OrderServiceImpl;
import View.Menuable;

import java.util.Scanner;

import static Model.Constants.*;

public class OrderMenu implements Menuable {
    boolean isRunning = true;
    private final String[] items = {"1. Add product to order", "2. Order checkout status",
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

            if (ADD_PRODUCT_TO_ORDER == choice) {
                new OrderServiceImpl().addProductToMyOrder();
            } else if (ORDER_CHECKOUT == choice) {
                new OrderServiceImpl().orderCheckoutStatus();
            } else if (SHOW_MY_ORDER == choice) {
                new OrderServiceImpl().showMyOrder();
            } else if (BACK == choice) {
                new ProductMenu().showMenu();
            } else if (EXIT == choice) {
                exit();
            } else {
                System.out.println("WRONG POINT!");
                showMenu();
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
