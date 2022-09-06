package View.impl;

import Service.impl.ValidationImpl;
import View.Menuable;

import java.util.Scanner;

import static Model.Constants.*;

public class LoginMenu implements Menuable {
    private final String[] items = {"1. Login", "2. Register", "3. I`m Admin",
            "4. Show product menu", "0. Exit"};
    boolean isRunning = true;

    @Override
    public void showMenu() {
        System.out.println("WELCOME TO THE BOOKSTORE!");
        showItems(items);
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLEASE ENTER THE MENU NUMBER");

        while (isRunning) {
            int choice = scanner.nextInt();

            if (LOGIN_USER == choice) {
                new ValidationImpl().loginUser();
            } else if (REGISTER_USER == choice) {
                new ValidationImpl().registerUser();
            } else if (ADMIN_LOGIN == choice) {
                new ValidationImpl().loginAdmin();
            } else if (SHOW_PRODUCT_MENU == choice) {
                new ProductMenu().showMenu();
            } else if (EXIT == choice) {
                exit();
            } else {
                System.out.println("WRONG POINT");
                showMenu();
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
