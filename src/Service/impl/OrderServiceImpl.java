package Service.impl;

import Dao.impl.ProductDaoImpl;
import Model.Constants;
import Model.Order;
import Model.Product;
import Service.OrderService;
import View.impl.OrderMenu;
import View.impl.ProductMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    Scanner scanner = new Scanner(System.in);
    public static List<Order> order = new ArrayList<>();

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
                .equals(nameProductWithBy)).anyMatch(book -> book.getName().equals(nameProductWithBy)) == false) {
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
        System.out.println(order);
    }

    public void orderCheckoutStatus() {

        if (order.stream().filter(order1 -> order1.isStatus() == false)
                .anyMatch(order1 -> order1.isStatus() == false)) {
            System.out.println("wait for admin confirmation");
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

        if (new Constants().CONFIRM_ORDER == choice) {
            OrderServiceImpl.order.stream().filter(order -> order.isStatus() == false)
                    .forEach(order -> order.setStatus(true));
            System.out.println(OrderServiceImpl.order);
            System.out.println("Order confirmed");
        } else if (new Constants().UNCONFIRM_ORDER == choice) {
            OrderServiceImpl.order.stream().filter(order -> order.isStatus() == true)
                    .forEach(order -> order.setStatus(false));
            System.out.println(OrderServiceImpl.order);
            System.out.println("Order unconfirmed");
        } else {
            System.out.println("WRONG POINT");
        }
    }
}
