package com.diallodev.orderservice.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final Mapper mapper;
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .build();

        List<OrderLineItems> orderLineItems = orderRequest.orderLineItems().stream()
                .map(mapper::toEntity).toList();

        order.setOrderLineItems(orderLineItems);

        orderRepository.save(order);
    }
}
