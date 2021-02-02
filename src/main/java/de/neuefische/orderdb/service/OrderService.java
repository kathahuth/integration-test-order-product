package de.neuefische.orderdb.service;

import de.neuefische.orderdb.database.OrderDB;
import de.neuefische.orderdb.database.ProductDB;
import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderDB orderDb;
    private final ProductDB productDB;

    @Autowired
    public OrderService(OrderDB orderDb, ProductDB productDB) {
        this.orderDb = orderDb;
        this.productDB = productDB;
    }

    public List<Order> listOrders() {

        return orderDb.getList();
    }

    public Optional<Product> getProduct(String id) {
        return productDB.getProductById(id);
    }

    public Order addOrder(String[] productIds, String orderId) {
        ArrayList<Product> productList = new ArrayList<>();
        for (String id : productIds) {
            if (getProduct(id).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + " id does not exist");
            }
                productList.add(getProduct(id).get());
            }
        Order order = new Order(orderId, productList);
        orderDb.add(order);
        return order;
        }



    }

