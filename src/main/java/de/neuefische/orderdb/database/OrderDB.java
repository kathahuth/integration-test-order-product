package de.neuefische.orderdb.database;

import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDB {

    ArrayList<Order> orders = new ArrayList<>();


    public List<Order> getList() {
        return orders;
    }

    public void add(Order order) {
        orders.add(order);
    }

}
