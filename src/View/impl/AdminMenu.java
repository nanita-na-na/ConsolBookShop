package View.impl;

import Service.impl.OrderServiceImpl;
import Service.impl.ProductServiceImpl;
import Service.impl.UserServiceImpl;
import View.Menuable;

import java.util.Scanner;

import static Model.Constants.*;

public class AdminMenu implements Menuable {
    private final String[] items = {"1. Show all users", "2. Show all books", "3. Add new book",
            "4. Block/Unblock user", "5. Confirm/Unconfirm orders", "6. Delete product",
            "7. Delete user", "8. Edit product", "9. Back", "0. Exit"};
    boolean isRunning = true;

    @Override
    public void showMenu() {
        System.out.println("HELLO ADMIN");
        showItems(items);
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLEASE ENTER THE MENU NUMBER");

        while (isRunning) {
            int choice = scanner.nextInt();

            if (SHOW_ALL_USERS == choice) {
                new UserServiceImpl().printAllUsers();
            } else if (SHOW_ALL_BOOKS == choice) {
                new ProductServiceImpl().printAllProducts();
            } else if (ADD_NEW_BOOKS == choice) {
                new ProductServiceImpl().addProduct();
            } else if (BLOCK_UNBLOCK_USERS == choice) {
                new UserServiceImpl().blockOrUnblockUser();
            } else if (CONFIRM_UNCONFIRM_ORDERS == choice) {
                new OrderServiceImpl().confirmOrUnconfirnOrder();
            } else if (DELETE_PRODUCT == choice) {
                new ProductServiceImpl().deleteProduct();
            } else if (DELETE_USER == choice) {
                new UserServiceImpl().deleteUser();
            } else if (EDIT_PRODUCT == choice) {
                new ProductServiceImpl().editProduct();
            } else if (BACK == choice) {
                new LoginMenu().showMenu();
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
        System.out.println("You exited!".toUpperCase());
        System.exit(0);
    }
}
