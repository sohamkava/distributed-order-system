package com.Osystem.orderservice.controller;

import com.Osystem.orderservice.model.Order;
import com.Osystem.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(
            @RequestParam String productId,
            @RequestParam Integer quantity) {
        return orderService.createOrder(productId, quantity);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
}
