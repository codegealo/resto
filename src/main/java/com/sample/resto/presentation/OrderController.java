package com.sample.resto.presentation;


import com.sample.resto.model.Order;
import com.sample.resto.model.constant.Constants;
import com.sample.resto.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder(){

        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    public ResponseEntity<Order>  createOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id){
        Optional<Order> optionalOrder = orderService.getOrderById(id);
        if(optionalOrder.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,Constants.ORDER_NOT_FOUND);
        }
        return    ResponseEntity.ok(optionalOrder.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Order> updateOrderDetails(@PathVariable Long id, @RequestBody String details){
        Optional<Order> optionalCustomer = orderService.updateOrderDetailsById(id,details);
        if(optionalCustomer.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,Constants.ORDER_NOT_FOUND);
        }
        return    ResponseEntity.ok(optionalCustomer.get());
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long id){
        Optional<Order> optionalCustomer = orderService.cancelOrderById(id);
        if(optionalCustomer.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ORDER_NOT_FOUND);
        }
        return    ResponseEntity.ok(optionalCustomer.get());
    }

}
