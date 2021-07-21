package com.example.assignment2.data_access;

import com.example.assignment2.model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerRepository {

    private String URL = ConnectionHelper.jdbcUrl;
    private Connection conn = null;

    public ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId,FirstName, LastName, Country, PostalCode, Phone, Email FROM customer");
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getInt("customerID"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("Country"),
                                resultSet.getString("postalCode"),
                                resultSet.getString("Phone"),
                                resultSet.getString("email")

                        ));
            }
            System.out.println("Select all customers successful");
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return customers;
    }

    public Customer getCustomerById(String custId){
        Customer customer = null;
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId,FirstName, LastName, Country, PostalCode, Phone, Email FROM customer WHERE CustomerId = ?");
            preparedStatement.setString(1,custId);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("customerID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("postalCode"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("email")
                );
            }
            System.out.println("Select specific customer successful");
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return customer;
    }

    public Customer getCustomerByName(String custName){
        Customer customer = null;
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer WHERE FirstName LIKE %?% OR LastName LIKE %?%");
            preparedStatement.setString(2,custName);
            preparedStatement.setString(3, custName);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("customerID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("postalCode"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("email")
                );
            }
            System.out.println("Select specific customer successful");
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return customer;
    }


}
