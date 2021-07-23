package com.example.assignment2;

import com.example.assignment2.data_access.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Assignment2Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment2Application.class, args);
        CustomerRepository c = new CustomerRepository();

        System.out.println(c.getAllCustomers());
       // System.out.println(c.getCustomerByName("ma"));
    }

}
