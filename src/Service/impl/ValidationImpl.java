package Service.impl;

import Dao.impl.UserDaoImpl;
import Model.Admin;
import Model.User;
import Service.Validations;
import View.impl.AdminMenu;
import View.impl.ProductMenu;

import java.util.Scanner;

public class ValidationImpl implements Validations {
    Scanner scanner = new Scanner(System.in);
    Admin admin = new Admin();
    UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();

    @Override
    public void registerUser() {

        System.out.println("Enter user id");
        long inputIdUser = scanner.nextLong();

        if (UserDaoImpl.getInstance().users.stream().filter(user -> user.getId() == inputIdUser)
                .anyMatch(user -> user.getId() == inputIdUser)) {
            System.out.println("Please get another id");
            registerUser();
        } else {
            System.out.println("Enter your name");
            String inputUserName = scanner.next();
            System.out.println("Enter your password");
            String inputUserPassword = scanner.next();
            UserDaoImpl.getInstance().users.add(new User(inputIdUser, inputUserName, inputUserPassword, true));
            System.out.println("Welcome!");
            System.out.println("PLEASE ENTER THE MENU NUMBER");
        }
    }

    @Override
    public void loginUser() {
        scanner = new Scanner(System.in);
        System.out.println("Enter your id ");
        long userId = this.scanner.nextLong();

        System.out.println("Enter your password");
        String pass = this.scanner.next();

        if (!(userDaoImpl.users.stream().filter(user -> user.getId() == userId).filter(user -> user.getPassword().equals(pass))
                .allMatch(user -> user.getId() == userId && user.getPassword() == pass))) {
            new ProductMenu().showMenu();
        } else {
            System.out.println("Wrong login or password");
        }
    }

    @Override
    public void loginAdmin() {
        scanner = new Scanner(System.in);

        System.out.println("Enter your name ".toUpperCase());
        String nameAdmin = scanner.nextLine();

        System.out.println("Enter your password".toUpperCase());
        long password = scanner.nextLong();

        if (nameAdmin.equals(admin.getName()) && password == admin.getPassword()) {
            System.out.println("you enter".toUpperCase());
            new AdminMenu().showMenu();
        } else {
            System.out.println("Wrong name or password".toUpperCase());
        }
    }
}
