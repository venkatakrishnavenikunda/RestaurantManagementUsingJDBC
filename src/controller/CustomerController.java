package controller;

import models.Customer;
import services.CustomerService;

import java.util.Scanner;

public class CustomerController {
    private final CustomerService service = new CustomerService();
    Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n-- Customer Menu --");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Back");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addCustomer();
                case 2 -> viewCustomers();
                case 3 -> {
                    return;
                }
            }
        }
    }

    private void addCustomer() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        service.addCustomer(new Customer(id, name, phone));
    }

    private void viewCustomers() {
        service.getAllCustomers().forEach(System.out::println);
    }
}

