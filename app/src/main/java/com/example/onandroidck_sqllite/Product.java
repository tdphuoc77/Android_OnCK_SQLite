package com.example.onandroidck_sqllite;

public class Product {

    private int id;
    private String type;
    private Double price;
    private String country;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                '}';
    }

    public Product(){

    }
    public Product(String type, Double price, String country) {
        this.type = type;
        this.price = price;
        this.country = country;
    }

    public Product(int id, String type, Double price, String country) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
