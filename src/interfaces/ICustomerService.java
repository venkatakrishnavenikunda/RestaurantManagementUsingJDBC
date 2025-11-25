package interfaces;

import models.Customer;

import java.util.List;

public interface ICustomerService {
    void addCustomer(Customer c);
    List<Customer> getAllCustomers();
}
