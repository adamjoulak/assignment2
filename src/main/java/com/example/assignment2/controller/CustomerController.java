package com.example.assignment2.controller;

import com.example.assignment2.data_access.CustomerRepository;
import com.example.assignment2.model.CountriesCustomers;
import com.example.assignment2.model.Customer;
import com.example.assignment2.model.GenresCustomers;
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

    @RequestMapping(value = "api/customer/name", method = RequestMethod.GET)
    public Customer getCustomerByName(@RequestParam(value="name", defaultValue = "ALFKI") String name){
        return customerRepository.getCustomerByName(name);
    }

    @RequestMapping(value = "api/customers/{limit}/{offset}", method = RequestMethod.GET)
    public ArrayList<Customer> getCustomersPage(@PathVariable int limit, @PathVariable int offset){
        return customerRepository.getCustomersPage(limit, offset);
    }

    @RequestMapping(value = "api/customers/add", method = RequestMethod.POST)
    public Boolean addNewCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    @RequestMapping(value = "api/customers/{id}", method = RequestMethod.PUT)
    public Boolean UpdateCustomer(@PathVariable String id, @RequestBody Customer customer){
        return customerRepository.updateCustomer(customer);
    }

    @RequestMapping(value = "api/customers/count", method = RequestMethod.GET)
    public ArrayList<CountriesCustomers> countryCounter(){
        return customerRepository.countryCounter();
    }

    @RequestMapping(value = "api/customers/spenders", method = RequestMethod.GET)
    public ArrayList<Customer> GetHighestSpenders(){
        return customerRepository.getHighestSpenders();
    }

    @RequestMapping(value = "api/customer/genre", method = RequestMethod.GET)
    public ArrayList<GenresCustomers> getFavouriteGenre(@RequestParam(value="id") int id){
        return customerRepository.getFavouriteGenre(id);
    }

}
