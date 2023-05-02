package com.diallo.productservice.product;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDTO(String name, String description, BigDecimal price) {
}
