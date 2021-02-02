package de.neuefische.orderdb.controller;

import de.neuefische.orderdb.model.Order;
import de.neuefische.orderdb.model.Product;
import de.neuefische.orderdb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public List<Order> listOrders() {
        return orderService.listOrders();
    }

    @PutMapping("{orderId}")
    public void addOrder(@RequestBody String[] productIds, @PathVariable String orderId){
        orderService.addOrder(productIds, orderId);
    }
}
