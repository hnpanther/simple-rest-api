package com.hnp.simplerestapi.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {


    public List<Customer> getAllCustomer();

    public Optional<Customer> getCustomerById(int id);

    public void createCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int customerId);

    public boolean existsById(int id);

}
