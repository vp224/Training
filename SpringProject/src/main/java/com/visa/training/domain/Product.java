package com.visa.training.domain;

public class Product {
    int id;
    String name;
    float price;
    int qoh;
    
    public Product() {
        // TODO Auto-generated constructor stub
    }

    public Product( String name, float price, int qoh) {
        super();
        //this.id = id;
        this.name = name;
        this.price = price;
        this.qoh = qoh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQoh() {
        return qoh;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", qoh=" + qoh + "]";
    }
    
    

}