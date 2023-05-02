package com.diallo.productservice.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public List<ProductDTO> getAllProducts() {
        log.info("Fetching all products");
        return productRepository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public void addProduct(ProductDTO productDTO) {
        Product product = mapper.toEntity(productDTO);
        productRepository.save(product);
        log.info("Adding new product: {}", productDTO);
    }

    public ProductDTO getProduct(String productId) {
        log.info("Get product with {}.", productId);
        return productRepository.findById(productId)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ProductNotFoundException("Product with id "+ productId + " not found"));
    }

    public ProductDTO updateProduct(String productId, ProductDTO productDTO) {
        return productRepository.findById(productId)
                .map(p -> {
                    p.setName(productDTO.name());
                    p.setDescription(productDTO.description());
                    p.setPrice(productDTO.price());
                    log.info("Product with id {} was updated", productId);
                    return mapper.toDTO(productRepository.save(p));
                }).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
        log.info("Product with id {} was deleted", productId);
    }
}
