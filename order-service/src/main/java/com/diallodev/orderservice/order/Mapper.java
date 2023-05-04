package com.diallodev.orderservice.order;

import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public OrderLineItemsDTO toDTO(OrderLineItems orderLineItems) {
        return OrderLineItemsDTO.builder()
                .skuCode(orderLineItems.getSkuCode())
                .price(orderLineItems.getPrice())
                .quantity(orderLineItems.getQuantity())
                .build();
    }
    public OrderLineItems toEntity(OrderLineItemsDTO orderLineItemsDTO) {
        return OrderLineItems.builder()
                .skuCode(orderLineItemsDTO.skuCode())
                .price(orderLineItemsDTO.price())
                .quantity(orderLineItemsDTO.quantity())
                .build();
    }
}
