package com.alterawi.awscodepipeline.controller;

import com.alterawi.awscodepipeline.dao.OrderDao;
import com.alterawi.awscodepipeline.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderDao orderDao;

    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderDao.getOrders().stream().sorted(Comparator.comparing(Order::getPrice)).toList());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Order>> getOrdersByName(@RequestParam String name) {
        return ResponseEntity.ok(orderDao.getOrdersByName(name));
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        orderDao.addOrder(order);
        return ResponseEntity.ok(order);
    }
}
