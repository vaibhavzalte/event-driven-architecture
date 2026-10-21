package com.order.service.order_service.event;

public record OrderCreatedEvent(
        Long orderId,
        String product,
        Integer quantity,
        String customerEmail
) {
}