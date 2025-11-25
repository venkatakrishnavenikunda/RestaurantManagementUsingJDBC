package daoimpl;

import dao.OrderDAO;
import dbconnection.DBConnection;
import models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDAOImpl implements OrderDAO {
    Scanner sc = new Scanner(System.in);

    @Override
    public void createOrder() {
        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Customer ID: ");
            int customerId = sc.nextInt();

            // Create order
            String createOrderSQL = "INSERT INTO orders(customer_id, total_amount) VALUES (?, 0) RETURNING id";
            PreparedStatement ps = con.prepareStatement(createOrderSQL);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            int orderId = 0;

            if (rs.next()) {
                orderId = rs.getInt("id");
            }

            double total = 0;

            while (true) {
                System.out.print("Enter Menu Item ID (0 to finish): ");
                int menuId = sc.nextInt();
                if (menuId == 0) break;

                System.out.print("Qty: ");
                int qty = sc.nextInt();

                // Fetch price
                PreparedStatement pricePS = con.prepareStatement("SELECT price FROM menu WHERE id=?");
                pricePS.setInt(1, menuId);
                ResultSet priceRS = pricePS.executeQuery();

                if (!priceRS.next()) {
                    System.out.println("Invalid Menu ID!");
                    continue;
                }

                double price = priceRS.getDouble("price");
                double subtotal = price * qty;

                // Insert order item
                PreparedStatement oiPS = con.prepareStatement(
                        "INSERT INTO order_items(order_id, menu_id, quantity, subtotal) VALUES (?, ?, ?, ?)");
                oiPS.setInt(1, orderId);
                oiPS.setInt(2, menuId);
                oiPS.setInt(3, qty);
                oiPS.setDouble(4, subtotal);
                oiPS.executeUpdate();

                total += subtotal;
            }

            PreparedStatement updateTotal = con.prepareStatement(
                    "UPDATE orders SET total_amount=? WHERE id=?");
            updateTotal.setDouble(1, total);
            updateTotal.setInt(2, orderId);
            updateTotal.executeUpdate();

            System.out.println("Order created with ID: " + orderId);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();

        String sql = "SELECT * FROM orders";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Order(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getDouble("total_amount")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
