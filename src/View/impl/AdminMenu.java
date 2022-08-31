package View.impl;

import Model.Constants;
import Service.impl.OrderServiceImpl;
import Service.impl.ProductServiceImpl;
import Service.impl.UserServiceImpl;
import View.Menuable;

import java.util.Scanner;

public class AdminMenu implements Menuable {
    boolean isRunning = true;
    private String[] items = {"1. Show all users", "2. Show all books", "3. Add new book",
            "4. Block/Unblock user", "5. Confirm/Unconfirm orders", "6. Delete product",
            "7. Delete user", "8. Edit product", "9. Back", "0. Exit"};

    private Scanner scanner;

    @Override
    public void showMenu() {
        System.out.println("HELLO ADMIN");
        showItems(items);
        scanner = new Scanner(System.in);
        System.out.println("PLEASE ENTER THE MENU NUMBER");

        while (isRunning) {
            int choice = scanner.nextInt();

            if (new Constants().SHOW_ALL_USERS == choice) {
                new UserServiceImpl().printAllUsers();
            } else if (new Constants().SHOW_ALL_BOOKS == choice) {
                new ProductServiceImpl().printAllProducts();
            } else if (new Constants().ADD_NEW_BOOKS == choice) {
                new ProductServiceImpl().addProduct();
            } else if (new Constants().BLOCK_UNBLOCK_USERS == choice) {
                new UserServiceImpl().blockOrUnblockUser();
            } else if (new Constants().CONFIRM_UNCONFIRM_ORDERS == choice) {
                new OrderServiceImpl().confirmOrUnconfirnOrder();
            } else if (new Constants().DELETE_PRODUCT == choice) {
                new ProductServiceImpl().deleteProduct();
            } else if (new Constants().DELETE_USER == choice) {
                new UserServiceImpl().deleteUser();
            } else if (new Constants().EDIT_PRODUCT == choice) {
                new ProductServiceImpl().editProduct();
            } else if (new Constants().BACK == choice) {
                new LoginMenu().showMenu();
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
