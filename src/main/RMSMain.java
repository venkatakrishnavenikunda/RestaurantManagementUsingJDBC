package main;

import controller.CustomerController;
import controller.MenuController;
import controller.OrderController;

import java.util.Scanner;

public class RMSMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomerController customerController = new CustomerController();
        MenuController menuController = new MenuController();
        OrderController orderController = new OrderController();

        while (true) {
            System.out.println("\n---- Restaurant Management System ----");
            System.out.println("1. Customer Management");
            System.out.println("2. Menu Management");
            System.out.println("3. Order Management");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> customerController.start();
                case 2 -> menuController.start();
                case 3 -> orderController.start();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
