package com.example.assignment2.model;

public class GenresCustomers {
    private String genre;
    private String nameOfCustomer;

    public GenresCustomers(String genre, String nameOfCustomer) {
        this.genre = genre;
        this.nameOfCustomer = nameOfCustomer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }
}
