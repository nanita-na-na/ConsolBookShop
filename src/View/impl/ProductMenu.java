package View.impl;

import Service.impl.ProductServiceImpl;
import View.Menuable;

import java.util.Scanner;

import static Model.Constants.*;

public class ProductMenu implements Menuable {
    private final String[] items = {"1. Order menu", "2. Show all books", "3. Sort by author", "4. Sort by price",
            "5. Sort by name", "6. Search specific product", "9. Back", "0. Exit"};
    boolean isRunning = true;

    @Override
    public void showMenu() {
        System.out.println("Welcome for product menu!".toUpperCase());
        showItems(items);
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLEASE ENTER THE MENU NUMBER");

        while (isRunning) {
            int choice = scanner.nextInt();

            if (CREATE_ORDER == choice) {
                new OrderMenu().showMenu();
            } else if (SHOW_ALL_BOOKS == choice) {
                new ProductServiceImpl().printAllProducts();
            } else if (SORT_BY_AUTHOR == choice) {
                new ProductServiceImpl().sortBooksByAuthor();
            } else if (SORT_BY_PRICE == choice) {
                new ProductServiceImpl().sortProductsByPrice();
            } else if (SORT_BY_NAME == choice) {
                new ProductServiceImpl().sortBooksByName();
            } else if (SEARCH_SPECIFIC_PRODUCT == choice) {
                new ProductServiceImpl().searchSpecificProduct();
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
