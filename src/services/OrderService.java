package services;

import dao.OrderDAO;
import daoimpl.OrderDAOImpl;
import interfaces.IOrderService;
import models.Order;

import java.util.List;
import java.util.Scanner;

public class OrderService implements IOrderService {
    private final OrderDAO dao = new OrderDAOImpl();
    Scanner sc = new Scanner(System.in);

    @Override
    public void createOrder() {
        dao.createOrder();
    }

    @Override
    public List<Order> getAllOrders() {
        return dao.getAllOrders();
    }
}
