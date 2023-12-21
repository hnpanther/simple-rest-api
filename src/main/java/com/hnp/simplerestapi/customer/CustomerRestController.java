package com.hnp.simplerestapi.customer;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping()
    public List<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable("id") int id) {
        return this.customerService.getCustomerById(id);
    }

    @PostMapping()
    public void addNewCustomer(@RequestBody Customer customer) {
        this.customerService.createCustomer(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        this.customerService.updateCustomer(customer);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") int id) {
        this.customerService.deleteCustomer(id);
    }
}
