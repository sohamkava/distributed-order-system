package com.Osystem.inventory_service.controller;

import com.Osystem.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/check")
    public boolean checkStock(
            @RequestParam String productId,
            @RequestParam int quantity) {
        return inventoryService.isInStock(productId, quantity);
    }
}
