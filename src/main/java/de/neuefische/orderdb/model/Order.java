package de.neuefische.orderdb.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    String id;
    ArrayList<Product> products = new ArrayList();

    public Order(String id, ArrayList<Product> products) {
        this.id = id;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
