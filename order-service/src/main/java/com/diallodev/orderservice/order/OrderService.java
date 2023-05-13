package com.diallodev.orderservice.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderService {

    private final Mapper mapper;
    private final OrderRepository orderRepository;
    private final WebClient webClient;



    public void placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .build();

        List<OrderLineItems> orderLineItems = orderRequest.orderLineItems().stream()
                .map(mapper::toEntity).toList();

        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();
        /* Call Inventory service, and place order if product is in stock */

        InventoryResponse[] inventoryResponseArray = webClient.get().uri("http://localhost:8082/api/v1/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        var allProductsInStock = false;
        if (inventoryResponseArray != null)
            allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);

        if (Boolean.TRUE.equals(allProductsInStock)) {
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("Product is not in stock, please try again later.");
        }
    }
}
