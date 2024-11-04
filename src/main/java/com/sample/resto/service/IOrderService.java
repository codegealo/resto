package com.sample.resto.service;

import com.sample.resto.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> getAll();
    Order createOrder(Order order);
    Optional<Order> getOrderById(Long id);
    Optional<Order> updateOrderDetailsById(Long id, String details);
    Optional<Order> cancelOrderById(Long id);

}
