package de.neuefische.orderdb.service;

import de.neuefische.orderdb.database.ProductDB;
import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {
    ProductDB productDB;

    @Autowired
    public ProductService(ProductDB productDB) {
        this.productDB = productDB;
    }

    public ArrayList<Product> listProducts() {
        return productDB.getProducts();
    }

    public Product addProduct(Product product) {
        return productDB.addProduct(product);
    }

    /*public void removeProduct(String id) {
        productDB.removeProduct(id);
    }*/

    public Optional<Product> findProductById(String id) {
        return productDB.getProductById(id);
    }

    public Optional<Product> searchProductByName(String name) {

        return productDB.searchByName(name);
    }
}
