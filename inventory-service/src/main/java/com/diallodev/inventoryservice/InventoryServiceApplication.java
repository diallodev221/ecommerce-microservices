package com.diallodev.inventoryservice;

import com.diallodev.inventoryservice.inventory.Inventory;
import com.diallodev.inventoryservice.inventory.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = Inventory.builder()
                    .id(1L)
                    .skuCode("iphone_13")
                    .quantity(1000)
                    .build();

            Inventory inventory1 = Inventory.builder()
                    .id(2L)
                    .skuCode("iphone_13_blue")
                    .quantity(0)
                    .build();

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
        };
    }
}
