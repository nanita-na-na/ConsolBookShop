package Service.impl;

import Dao.impl.UserDaoImpl;
import Model.Constants;
import Service.UserService;

import java.util.Scanner;

public class UserServiceImpl implements UserService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void deleteUser() {
        System.out.println("Enter name user with remove");
        String nameRemove = scanner.nextLine();
        UserDaoImpl.getInstance().users.remove(UserDaoImpl.getInstance()
                .users.stream().filter(p -> p.getName().equals(nameRemove)).findAny().orElse(null));
        System.out.println("User was removed");
        System.out.println("PLEASE ENTER THE MENU NUMBER");
    }

    @Override
    public void printAllUsers() {
        System.out.println("Our users: ");
        UserDaoImpl.getInstance().users.forEach(System.out::println);
        System.out.println("PLEASE ENTER THE MENU NUMBER");
    }

    @Override
    public void blockOrUnblockUser() {
        System.out.println("1. Block user. 2. Unblock user");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (new Constants().BLOCK_USER == choice) {
            blockUser();
        } else if (new Constants().UNBLOCK_USER == choice) {
            unblockUser();
        } else {
            System.out.println("WRONG POINT");
        }
    }

    public void blockUser() {
        System.out.println("Enter id of the user you want to block");
        scanner = new Scanner(System.in);
        long blockId = scanner.nextLong();

        if (UserDaoImpl.getInstance().users.stream().filter(user -> user.getId() == blockId)
                .anyMatch(user -> user.getId() == blockId) == false) {
            System.out.println("We don't have that user");
        } else {
            UserDaoImpl.getInstance().users.stream().filter(user -> user.getId() == blockId)
                    .forEach(user -> user.setStatus(false));
            System.out.println("User is blocked");
        }
    }

    public void unblockUser() {
        System.out.println("Enter id of the user you want to unblock");
        scanner = new Scanner(System.in);
        long unblockId = scanner.nextLong();

        if (UserDaoImpl.getInstance().users.stream().filter(user -> user.getId() == unblockId)
                .anyMatch(user -> user.getId() == unblockId) == false) {
            System.out.println("We don't have that user");
        } else {
            UserDaoImpl.getInstance().users.stream().filter(user -> user.getId() == unblockId)
                    .forEach(user -> user.setStatus(true));
            System.out.println("User is unblocked");
        }
    }
}
