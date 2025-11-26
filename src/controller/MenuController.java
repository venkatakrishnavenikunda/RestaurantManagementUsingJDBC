package controller;

import models.MenuItem;
import services.MenuSerivices;

import java.util.Scanner;

public class MenuController {
    MenuSerivices service = new MenuSerivices();
    Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n--- Menu Management ---");
            System.out.println("1. Add Menu Item");
            System.out.println("2. View Menu");
            System.out.println("3. Back");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addMenuItem();
                case 2 -> viewMenu();
                case 3 -> { return; }
            }
        }
    }

    private void addMenuItem() {
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Category: ");
        String cat = sc.nextLine();

        service.addMenuItem(new MenuItem(0, name, price, cat));
    }

    private void viewMenu() {
        service.getAllMenuItems().forEach(System.out::println);
    }
}
