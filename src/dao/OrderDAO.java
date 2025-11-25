package dao;

import models.Order;

import java.util.List;

public interface OrderDAO {
    void createOrder();
    List<Order> getAllOrders();
}
