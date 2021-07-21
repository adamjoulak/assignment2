package com.example.assignment2.controller;

import com.example.assignment2.data_access.CustomerRepository;
import com.example.assignment2.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    private CustomerRepository customerRepository = new CustomerRepository();


    @RequestMapping(value="/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    @RequestMapping(value = "api/customer", method = RequestMethod.GET)
    public Customer getCustomerByQueryId(@RequestParam(value="id", defaultValue = "ALFKI") String id){
        return customerRepository.getCustomerById(id);
    }

}
