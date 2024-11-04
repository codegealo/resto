package com.sample.resto.service;

import com.sample.resto.model.Order;
import com.sample.resto.model.constant.Constants;
import com.sample.resto.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        Sort sort = Sort.by("customer_id").ascending();
        return orderRepository.findAll(sort);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional<Order> updateOrderDetailsById(Long id, String details) {

        Optional<Order> optionalOrder = getOrderById(id);
        if(optionalOrder.isPresent() && optionalOrder.get().getStatus().equalsIgnoreCase(Constants.OrderStatus.NEW.name())) {
            Order order = optionalOrder.get();
            order.setDetails(details);
            return Optional.of(orderRepository.save(order));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Order> cancelOrderById(Long id) {
        Optional<Order> optionalOrder = getOrderById(id);
        if(optionalOrder.isPresent() && !optionalOrder.get().getStatus().equalsIgnoreCase(Constants.OrderStatus.DONE.name())) {
            Order order = optionalOrder.get();
            order.setStatus(Constants.OrderStatus.CANCELED.name());
            return Optional.of(orderRepository.save(order));
        }
        return Optional.empty();
    }
}
