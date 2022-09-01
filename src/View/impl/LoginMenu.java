package View.impl;

import Model.Constants;
import Service.impl.ValidationImpl;
import View.Menuable;

import java.util.Scanner;

public class LoginMenu implements Menuable {
    boolean isRunning = true;
    private final String[] items = {"1. Login", "2. Register", "3. I`m Admin",
            "4. Show product menu", "0. Exit"};
    private Scanner scanner;

    @Override
    public void showMenu() {
        System.out.println("WELCOME TO THE BOOKSTORE!");
        showItems(items);
        scanner = new Scanner(System.in);
        System.out.println("PLEASE ENTER THE MENU NUMBER");

        while (isRunning) {
            int choice = scanner.nextInt();

            if (new Constants().LOGIN_USER == choice) {
                new ValidationImpl().loginUser();
            } else if (new Constants().REGISTER_USER == choice) {
                new ValidationImpl().registerUser();
            } else if (new Constants().ADMIN_LOGIN == choice) {
                new ValidationImpl().loginAdmin();
            } else if (new Constants().SHOW_PRODUCT_MENU == choice) {
                new ProductMenu().showMenu();
            } else if (new Constants().EXIT == choice) {
                exit();
            }
        }
        System.out.println("PLEASE ENTER THE MENU NUMBER");
    }

    @Override
    public void exit() {
        System.out.println("You exited".toUpperCase());
        System.exit(0);
    }
}
