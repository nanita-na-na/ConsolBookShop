package View.impl;

import Model.Constants;
import Service.impl.ProductServiceImpl;
import View.Menuable;

import java.util.Scanner;

public class ProductMenu implements Menuable {
    boolean isRunning = true;

    private String[] items = {"1. Order menu", "2. Show all books", "3. Sort by author", "4. Sort by price",
            "5. Sort by name", "6. Search specific product", "9. Back", "0. Exit"};
    private Scanner scanner;


    @Override
    public void showMenu() {
        System.out.println("Welcome for product menu!".toUpperCase());
        showItems(items);
        scanner = new Scanner(System.in);
        System.out.println("PLEASE ENTER THE MENU NUMBER");

        while (isRunning) {
            int choice = scanner.nextInt();

            if (new Constants().CREATE_ORDER == choice) {
                new OrderMenu().showMenu();
            } else if (new Constants().SHOW_ALL_BOOKS == choice) {
                new ProductServiceImpl().printAllProducts();
            } else if (new Constants().SORT_BY_AUTHOR == choice) {
                new ProductServiceImpl().sortBooksByAuthor();
            } else if (new Constants().SORT_BY_PRICE == choice) {
                new ProductServiceImpl().sortProductsByPrice();
            } else if (new Constants().SORT_BY_NAME == choice) {
                new ProductServiceImpl().sortBooksByName();
            } else if (new Constants().SEARCH_SPECIFIC_PRODUCT == choice) {
                new ProductServiceImpl().searchSpecificProduct();
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
