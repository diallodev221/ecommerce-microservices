package com.diallodev.orderservice.order;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderLineItemsDTO(
        String skuCode,
        BigDecimal price,
        Integer quantity
) {
}
