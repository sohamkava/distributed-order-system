package com.Osystem.orderservice.service;

import com.Osystem.orderservice.model.Order;
import com.Osystem.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.Osystem.orderservice.exception.OutOfStockException;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    /**
     * Creates an order only if inventory is available
     */
    public Order createOrder(String productId, Integer quantity) {

        // Call Inventory Service
        boolean inStock = inventoryClient.isInStock(productId, quantity);

        if (!inStock) {
            throw new OutOfStockException("Product out of stock");

        }

        Order order = Order.builder()
                .productId(productId)
                .quantity(quantity)
                .status("CONFIRMED")
                .build();

        return orderRepository.save(order);
    }

    /**
     * Fetch order by ID
     */
    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
