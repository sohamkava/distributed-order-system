package com.Osystem.orderservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class InventoryClient {

    private final WebClient webClient;

    public InventoryClient(
            @Value("${inventory.service.url}") String inventoryServiceUrl
    ) {
        this.webClient = WebClient.builder()
                .baseUrl(inventoryServiceUrl)
                .build();
    }

    public boolean isInStock(String productId, int quantity) {
        try {
            Boolean response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/inventory/check")
                            .queryParam("productId", productId)
                            .queryParam("quantity", quantity)
                            .build())
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .timeout(Duration.ofSeconds(2))        // ⏱ timeout safety
                    .onErrorResume(ex -> Mono.just(false)) // 🔁 fallback
                    .block();

            return Boolean.TRUE.equals(response);

        } catch (Exception e) {
            return false;
        }
    }
}
