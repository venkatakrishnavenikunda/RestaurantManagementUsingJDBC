package services;

import dao.CustomerDAO;
import daoimpl.CustomerDAOImpl;
import exceptions.DuplicateEntryException;
import interfaces.ICustomerService;
import models.Customer;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final CustomerDAO dao = new CustomerDAOImpl();

    @Override
    public void addCustomer(Customer c) {
        try {
            dao.addCustomer(c);
        } catch (DuplicateEntryException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }
}
