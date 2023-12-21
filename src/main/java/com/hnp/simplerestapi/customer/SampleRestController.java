package com.hnp.simplerestapi.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleRestController {

    @GetMapping()
    public Customer sampleCustomer() {
        Customer customer = new Customer();
        customer.setId(0);
        customer.setFirstName("sample");
        customer.setLastName("sample");

        return customer;
    }
}
