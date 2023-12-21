package com.hnp.simplerestapi.customer;

import lombok.Data;

import java.util.List;

@Data
public class Customer {

    private Integer id;

    private String firstName;

    private String lastName;

    private List<Address> addressList;

}
