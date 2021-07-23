package com.example.assignment2.model;

import java.util.ArrayList;
import java.util.UUID;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String email;
    private Float total;
    private String countCountry;

    private ArrayList<Customer> arrayListCustomer = new ArrayList<Customer>();

    public Customer(int id, String firstName, String lastName, String country, String postalCode, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
       // arrayListCustomer.add(this);
    }
    public Customer (int id, String firstName, String lastName, Float total){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.total=total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode){
        this.postalCode=postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getCountCountry() {
        return countCountry;
    }

    public void setCountCountry(String countCountry) {
        this.countCountry = countCountry;
    }
}
