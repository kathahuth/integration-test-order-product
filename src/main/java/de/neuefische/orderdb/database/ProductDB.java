package de.neuefische.orderdb.database;

import de.neuefische.orderdb.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDB {

    ArrayList<Product> products = new ArrayList<>(List.of(
            new Product("1", "Shampoo"),
            new Product("2", "Lotion")));



    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Optional<Product> getProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public Optional<Product> searchByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    /*public void removeProduct(String id) {
        for (Product product : products) {

        }
        products.remove()
    }*/
}
