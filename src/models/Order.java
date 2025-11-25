package models;

import java.util.ArrayList;
import java.util.List;



public class Order {
    private int id;
    private int customerId;
    private double totalAmount;

    public Order(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    // ✅ ADD THIS CONSTRUCTOR
    public Order(int id, int customerId, double totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }

    // getters & setters
    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public double getTotalAmount() { return totalAmount; }

    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    @Override
    public String toString() {
        return "Order ID: " + id +
                ", Customer ID: " + customerId +
                ", Total: " + totalAmount;
    }
}














//public class Order {
//    private int id;
//    private int customerId;
//    private boolean cancelled;
//    private List<OrderItem> items = new ArrayList<>();
//
//    public Order(int id, int customerId) {
//        this.id = id;
//        this.customerId = customerId;
//    }
//
//    public int getId() {
//        return id;
//    }
//    public int getCustomerId() {
//        return customerId;
//    }
//    public List<OrderItem> getItems() {
//        return items;
//    }
//
//    public boolean isCancelled() {
//        return cancelled;
//    }
//    public void cancel() {
//        this.cancelled = true;
//    }
//}
