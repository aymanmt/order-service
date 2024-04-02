package com.alterawi.awscodepipeline.dao;

import com.alterawi.awscodepipeline.model.Order;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Repository
public class OrderDao {

    private final List<Order> orders;

    public OrderDao() {
        orders = new ArrayList<>(Arrays.asList(
                new Order(1, "Book", 2, 10.0),
                new Order(2, "Pen", 5, 5.0),
                new Order(3, "Pencil", 10, 2.0)
        ));
    }

    public List<Order> getOrdersByName(String orderName) {
        return getOrders().stream()
                .filter(order -> order.getName().equalsIgnoreCase(orderName))
                .toList();
    }

    public void addOrder(Order order) {
        getOrders().add(order);
    }
}
