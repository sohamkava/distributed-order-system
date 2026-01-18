package com.Osystem.inventory_service.service;

import com.Osystem.inventory_service.model.Inventory;
import com.Osystem.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String productId, int quantity) {
        return inventoryRepository
                .findByProductId(productId)
                .map(inv -> inv.getStock() >= quantity)
                .orElse(false);
    }

    public void reduceStock(String productId, int quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        inventory.setStock(inventory.getStock() - quantity);
        inventoryRepository.save(inventory);
    }
}
