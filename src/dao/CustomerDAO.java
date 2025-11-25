package dao;

import exceptions.DuplicateEntryException;
import models.Customer;

import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer c) throws DuplicateEntryException;
    List<Customer> getAllCustomers();
}
