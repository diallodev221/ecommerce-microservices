package com.diallo.productservice.product;

import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public Product toEntity(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.name())
                .description(productDTO.description())
                .price(productDTO.price())
                .build();
    }
}
