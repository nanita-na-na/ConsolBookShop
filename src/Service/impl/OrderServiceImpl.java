package Service.impl;

import Dao.impl.ProductDaoImpl;
import Model.Order;
import Model.Product;
import Service.OrderService;
import View.impl.OrderMenu;
import View.impl.ProductMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static Model.Constants.CONFIRM_ORDER;
import static Model.Constants.UNCONFIRM_ORDER;

public class OrderServiceImpl implements OrderService {
    public static List<Order> order = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public OrderServiceImpl() {
    }

    @Override
    public void addProductToMyOrder() {
        System.out.println("Create new order ");
        List<Product> orderProduct;

        int count = 1;
        System.out.println("write the name of the product you want to buy".toUpperCase());
        String nameProductWithBy = scanner.nextLine();

        if (ProductDaoImpl.getInstance().books.stream().filter(book -> book.getName()
                .equals(nameProductWithBy)).noneMatch(book -> book.getName().equals(nameProductWithBy))) {
            System.out.println("this book exist");
            new ProductMenu().showMenu();
        } else {
            orderProduct = ProductDaoImpl.getInstance().books.stream().filter(book -> book.getName()
                    .equals(nameProductWithBy)).collect(Collectors.toList());
            order.add(new Order(count++, false, orderProduct));
            System.out.println("Order is created");
            order.forEach(System.out::println);
            new OrderMenu().showMenu();
        }
    }

    @Override
    public void showMyOrder() {
        order.forEach(System.out::println);
    }

    public void orderCheckoutStatus() {

        if (order.stream().filter(order1 -> !order1.isStatus())
                .anyMatch(order1 -> !order1.isStatus())) {
            System.out.println("Wait for admin confirmation");
        } else {
            System.out.println("Yor order confirm, wait for delivery");
        }
        new OrderMenu().showMenu();
    }

    @Override
    public void confirmOrUnconfirnOrder() {
        System.out.println("Our orders: " + OrderServiceImpl.order);

        System.out.println("1. Confirm order 2. Un-confirm order");
        int choice = scanner.nextInt();

        if (CONFIRM_ORDER == choice) {
            OrderServiceImpl.order.stream().filter(order -> !order.isStatus())
                    .forEach(order -> order.setStatus(true));
            System.out.println(OrderServiceImpl.order);
            System.out.println("Order confirmed");
        } else if (UNCONFIRM_ORDER == choice) {
            OrderServiceImpl.order.stream().filter(Order::isStatus)
                    .forEach(order -> order.setStatus(false));
            System.out.println(OrderServiceImpl.order);
            System.out.println("Order unconfirmed");
        } else {
            System.out.println("WRONG POINT");
            new OrderMenu().showMenu();
        }
    }
}
