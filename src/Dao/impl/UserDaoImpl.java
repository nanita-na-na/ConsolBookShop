package Dao.impl;

import Dao.UserDao;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl INSTANCE_DAO_USER;
    public List<User> users = new ArrayList<>();

    private UserDaoImpl() {
        init();
    }

    public static UserDaoImpl getInstance() {
        if (INSTANCE_DAO_USER == null) {
            INSTANCE_DAO_USER = new UserDaoImpl();
        }
        return INSTANCE_DAO_USER;
    }

    @Override
    public List<User> init() {
        users.add(new User(0, "Ivan", "1234", true));
        users.add(new User(1, "Angelina", "12345", true));
        users.add(new User(2, "Johnny", "12345", true));
        users.add(new User(3, "Olexandr", "12345", true));
        users.add(new User(4, "Nina", "12345", true));
        users.add(new User(5, "Taras", "12345", true));
        users.add(new User(6, "Ivanka", "54321", true));

        return users;
    }
}
