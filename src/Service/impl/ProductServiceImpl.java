package Service.impl;

import Dao.impl.ProductDaoImpl;
import Model.Constants;
import Model.Product;
import Service.ProductService;

import java.util.Comparator;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    Scanner scanner = new Scanner(System.in);

    public ProductServiceImpl() {
    }

    @Override
    public void addProduct() {
        System.out.println("Enter name book");
        String inputNameBook = scanner.next();
        System.out.println("Enter author book");
        String inputAuthorBook = scanner.next();
        System.out.println("Enter prise book");
        int inputPriseBook = scanner.nextInt();
        ProductDaoImpl.getInstance().books.add(new Product(inputNameBook, inputAuthorBook, inputPriseBook));
        System.out.println("PLEASE ENTER THE MENU NUMBER");
    }

    @Override
    public void printAllProducts() {
        System.out.println("Our books: ");
        ProductDaoImpl.getInstance().books.forEach(System.out::println);
        System.out.println("PLEASE ENTER THE MENU NUMBER");
    }

    @Override
    public void deleteProduct() {
        System.out.println("Enter name book with remove");
        String nameRemove = scanner.nextLine();
        ProductDaoImpl.getInstance().books.remove(ProductDaoImpl.getInstance()
                .books.stream().filter(p -> p.getName().equals(nameRemove)).findAny().orElse(null));
        System.out.println("Book was removed");
        System.out.println("PLEASE ENTER THE MENU NUMBER");
    }

    @Override
    public void sortProductsByPrice() {
        ProductDaoImpl.getInstance().books.sort(Comparator.comparing(book -> book.getPrise()));
        ProductDaoImpl.getInstance().books.forEach(System.out::println);
    }

    public void sortBooksByName() {
        ProductDaoImpl.getInstance().books.sort(Comparator.comparing(book -> book.getName()));
        ProductDaoImpl.getInstance().books.forEach(System.out::println);
    }

    public void sortBooksByAuthor() {
        ProductDaoImpl.getInstance().books.sort(Comparator.comparing(book -> book.getAuthor()));
        ProductDaoImpl.getInstance().books.forEach(System.out::println);
    }

    public void editProduct() {
        scanner = new Scanner(System.in);
        System.out.println("Enter name book what you want edit");
        String nameProductEdit = scanner.next();

        if (ProductDaoImpl.getInstance().books.stream().filter(book -> book.getName().
                equals(nameProductEdit)).anyMatch(book -> book.getName().equals(nameProductEdit)) == false) {
            System.out.println("This product exist");
        } else {
            System.out.println("1. Edit Name 2. Edit Author 3. Edit Price");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (new Constants().EDIT_BOOK_NAME == choice) {
                editBookName();
            } else if (new Constants().EDIT_BOOK_AUTHOR == choice) {
                editBookAuthor();
            } else if (new Constants().EDIT_BOOK_PRICE == choice) {
                editBookPrice();
            } else {
                System.out.println("WRONG POINT MENU");
            }
        }
    }

    public void editBookName() {
        scanner = new Scanner(System.in);
        System.out.println("Enter name book what you want edit");
        String nameProductEdit = scanner.next();

        System.out.println("Enter new name book");
        String inputNameBook = scanner.next();
        ProductDaoImpl.getInstance().books.stream().filter(book -> book.getName().equals(nameProductEdit))
                .forEach(book -> book.setName(inputNameBook));
    }

    public void editBookAuthor() {
        scanner = new Scanner(System.in);
        System.out.println("Enter name book what you want edit");
        String nameProductEdit = scanner.next();

        System.out.println("Enter new author book");
        String inputAuthorBook = scanner.next();
        ProductDaoImpl.getInstance().books.stream().filter(book -> book.getName().equals(nameProductEdit))
                .forEach(book -> book.setAuthor(inputAuthorBook));
    }

    public void editBookPrice() {
        scanner = new Scanner(System.in);
        System.out.println("Enter name book what you want edit");
        String nameProductEdit = scanner.next();

        System.out.println("Enter new prise book");
        int inputPriseBook = scanner.nextInt();

        ProductDaoImpl.getInstance().books.stream().filter(book -> book.getName().equals(nameProductEdit))
                .forEach(book -> book.setPrise(inputPriseBook));
    }

    public void searchSpecificProduct() {
        System.out.println("1. Search by book`s name. 2. Search by book`s author");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (new Constants().SEARCH_BY_BOOK_NAME == choice) {
            searchByName();
        } else if (new Constants().SEARCH_BY_BOOK_AUTHOR == choice) {
            searchByAuthor();
        } else {
            System.out.println("WRONG POINT");
        }
        System.out.println("PLEASE ENTER THE MENU NUMBER");
    }

    public void searchByName() {
        System.out.println("Write name book");
        scanner = new Scanner(System.in);
        String searchName = scanner.next();
        if (ProductDaoImpl.getInstance().books.stream().filter(book -> book.getName().equals(searchName))
                .anyMatch(book -> book.getName().equals(searchName)) == false) {
            System.out.println("We don't have that book");
        } else {
            ProductDaoImpl.getInstance().books.stream().filter(book -> book.getName().equals(searchName))
                    .forEach(System.out::println);
        }
        System.out.println("PLEASE ENTER THE MENU NUMBER");
    }

    public void searchByAuthor() {
        System.out.println("Write author book");
        scanner = new Scanner(System.in);
        String searchAuthor = scanner.next();
        if (ProductDaoImpl.getInstance().books.stream().filter(book -> book.getAuthor().equals(searchAuthor))
                .anyMatch(book -> book.getAuthor().equals(searchAuthor)) == false) {
            System.out.println("We don't have that book");
        } else {
            ProductDaoImpl.getInstance().books.stream().filter(book -> book.getAuthor().equals(searchAuthor))
                    .forEach(System.out::println);
        }
        System.out.println("PLEASE ENTER THE MENU NUMBER");
    }
}
