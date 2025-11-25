package controller;

import services.OrderService;

import java.util.Scanner;

public class OrderController {
    Scanner sc = new Scanner(System.in);
    OrderService service = new OrderService();

    public void start() {
        while (true) {
            System.out.println("\n-- Order Management --");
            System.out.println("1. Create Order");
            System.out.println("2. View Orders");
            System.out.println("3. Back");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> service.createOrder();
                case 2 -> service.getAllOrders().forEach(System.out::println);
                case 3 -> {
                    return;
                }
            }
        }
    }
}
