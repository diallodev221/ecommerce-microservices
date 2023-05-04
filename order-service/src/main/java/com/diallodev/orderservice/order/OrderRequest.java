package com.diallodev.orderservice.order;

import java.util.List;

public record OrderRequest(List<OrderLineItemsDTO> orderLineItems) {
}
