package com.example.assignment2.data_access;

import com.example.assignment2.model.CountriesCustomers;
import com.example.assignment2.model.Customer;
import com.example.assignment2.model.GenresCustomers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                    conn.prepareStatement("SELECT CustomerId,FirstName, LastName, Country, PostalCode, Phone, Email FROM customers");
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
                    conn.prepareStatement("SELECT CustomerId,FirstName, LastName, Country, PostalCode, Phone, Email FROM customers WHERE CustomerId = ?");
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
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customers WHERE FirstName LIKE ? OR LastName LIKE ?");
            preparedStatement.setString(1,"%" + custName + "%");
            preparedStatement.setString(2, "%" + custName + "%");
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("customerID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("postalCode"),
                        resultSet.getString("phone"),
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

    public ArrayList<Customer> getCustomersPage(int limit, int offset){
        ArrayList<Customer> customersList = new ArrayList<>();
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT CustomerId,FirstName, LastName, Country, PostalCode, Phone, Email FROM customers BETWEEN @limit AND @offset");
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customersList.add(
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
        return customersList;
    }

    public Boolean addCustomer(Customer customer){
        Boolean success = false;
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO customer(Id,firstName,lastName,country,postalCode,phoneNumber,email) VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setString(2,customer.getFirstName());
            preparedStatement.setString(3,customer.getLastName());
            preparedStatement.setString(4,customer.getCountry());
            preparedStatement.setString(5,customer.getPostalCode());
            preparedStatement.setString(6,customer.getPhoneNumber());
            preparedStatement.setString(7,customer.getEmail());
            // Execute Query
            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            System.out.println("Add customer successful");
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
        return success;
    }

    public boolean updateCustomer(Customer customer)
    {
        boolean success = false;

        try{
            // Connect to the database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // create query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE Customer SET FirstName = ?, lastName = ?, country = ?, postalCode = ?, phoneNumber = ?,email = ? WHERE CustomerId = ?");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2,customer.getLastName());
            preparedStatement.setString(3,customer.getCountry());
            preparedStatement.setString(4,customer.getPostalCode());
            preparedStatement.setString(5,customer.getPhoneNumber());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setInt(7,customer.getId());

            // Execute the Query
            ResultSet resultSet = preparedStatement.executeQuery();
            success = true;

            System.out.println("Updated specific customer successful");
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

        return success;
    }

    public ArrayList<CountriesCustomers> countryCounter()
    {
        ArrayList<CountriesCustomers> countryCounts = new ArrayList<CountriesCustomers>();
        try
        {
            //Make connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT c.Country, COUNT(*) AS count FROM Customer AS c GROUP BY Country ORDER BY count DESC");

            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                countryCounts.add(new CountriesCustomers(resultSet.getString(1), resultSet.getInt(2)));
            }
        }
        catch (SQLException e)
        {
        }finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }

        return countryCounts;
    }

    public ArrayList<Customer> getHighestSpenders()
    {
        ArrayList<Customer> highSpenders = new ArrayList<>();
        try
        {
            //Make connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT c.FirstName, c.LastName, SUM(i.Total) AS sum " +
                            "FROM Invoice AS i JOIN Customer AS c ON c.CustomerId = i.CustomerId " +
                            "GROUP BY i.CustomerId, c.FirstName, c.LastName " +
                            "ORDER BY sum DESC; ");

            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                highSpenders.add(
                        new Customer(
                                resultSet.getInt("customerID"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getFloat("total")

                        ));
            }
        }
        catch (SQLException e)
        {
        }finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }

        return highSpenders;
    }

    /// <summary>
    /// Query 9, Get favourite genre for specific customer by Id
    /// </summary>
    /// <param name="id">Customer ID</param>
    /// <returns>A List of the customers favourite genre</returns>
    public ArrayList<GenresCustomers> getFavouriteGenre(int custId)
    {
        ArrayList<GenresCustomers> customerGenreList = new ArrayList<GenresCustomers>();


        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT g.Name, COUNT(g.Name) AS genrecount, c.FirstName INTO #Populargenre FROM Customer AS c " +
                            "JOIN Invoice AS i ON c.CustomerId = i.CustomerId " +
                            "JOIN InvoiceLine AS il ON i.InvoiceId = il.InvoiceId " +
                            "JOIN Track AS t ON il.TrackId = t.TrackId " +
                            "JOIN Genre AS g ON g.GenreId = t.GenreId " +
                            "WHERE c.CustomerId = ? " +
                            "GROUP BY c.FirstName, g.Name " +
                            "ORDER BY genrecount DESC; " +

                            "SELECT FirstName, Name " +
                            "FROM #Populargenre " +
                            "GROUP BY FirstName, Name, genrecount " +
                            "HAVING genrecount = (SELECT MAX(genrecount) " +
                            "FROM #Populargenre) " +
                            "ORDER BY genrecount DESC; " +

                            "DROP TABLE #Populargenre; ");
            preparedStatement.setInt(1,custId);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customerGenreList.add(new GenresCustomers(resultSet.getString(1),resultSet.getString(0)));
            }
            System.out.println("successful");
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }

        return customerGenreList;
    }

}
