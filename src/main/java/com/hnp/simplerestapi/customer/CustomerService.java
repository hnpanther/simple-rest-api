package com.hnp.simplerestapi.customer;

import com.hnp.simplerestapi.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(@Qualifier("list") CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getAllCustomers() {
        return this.customerRepository.getAllCustomer();
    }

    public Customer getCustomerById(int id) {
        return this.customerRepository.getCustomerById(id).orElseThrow(
                () -> new CustomerNotFoundException("customer not found")
        );
    }

    public void createCustomer(Customer customer) {
        this.customerRepository.createCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        boolean checkExists = this.customerRepository.existsById(customer.getId());
        if(!checkExists) {
            throw new CustomerNotFoundException("customer not found");
        }
        this.customerRepository.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        this.customerRepository.deleteCustomer(id);
    }
}
