package interfaces;

import models.Order;

import java.util.List;

public interface IOrderService {
    void createOrder();
    List<Order> getAllOrders();
}
