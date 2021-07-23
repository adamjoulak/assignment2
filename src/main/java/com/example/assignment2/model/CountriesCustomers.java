package com.example.assignment2.model;

public class CountriesCustomers {

    private int count;
    private String country;

    public CountriesCustomers(String country, int count) {
        this.count = count;
        this.country = country;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
