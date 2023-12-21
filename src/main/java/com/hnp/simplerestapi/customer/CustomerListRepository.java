package com.hnp.simplerestapi.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("list")
public class CustomerListRepository implements CustomerRepository {


    private List<Customer> customers;

    private static int NEXT_ID = 0;

    public CustomerListRepository() {

        List<Address> addressList1 = new ArrayList<>();
        Address address1 = new Address();
        address1.setId(1);
        address1.setFullAddress("address1...");
        address1.setCity("city1");
        Address address2 = new Address();
        address2.setId(2);
        address2.setFullAddress("address2...");
        address2.setCity("city2");

        addressList1.addAll(List.of(address1, address2));

        NEXT_ID += 1;
        Customer customer1 = new Customer();
        customer1.setId(NEXT_ID);
        customer1.setFirstName("first1");
        customer1.setLastName("last1");
        customer1.setAddressList(addressList1);

        NEXT_ID += 1;
        Customer customer2 = new Customer();
        customer2.setId(NEXT_ID);
        customer2.setFirstName("first2");
        customer2.setLastName("last2");

        this.customers = new ArrayList<>();
        customers.addAll(List.of(customer1, customer2));

    }

    @Override
    public List<Customer> getAllCustomer() {
        return this.customers;
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    @Override
    public void createCustomer(Customer customer) {
        NEXT_ID += 1;
        customer.setId(NEXT_ID);
        this.customers.add(customer);
    }

    @Override
    public void updateCustomer(Customer newCustomer) {
        Customer customer =
                this.customers.stream().filter(c -> c.getId().equals(newCustomer.getId())).findFirst().get();
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
    }

    @Override
    public void deleteCustomer(int customerId) {
        this.customers.removeIf(c -> c.getId().equals(customerId));
    }

    public boolean existsById(int id) {
        return this.customers.stream().anyMatch(c -> c.getId().equals(id));
    }
}
