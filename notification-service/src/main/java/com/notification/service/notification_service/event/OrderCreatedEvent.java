package com.notification.service.notification_service.event;

public record OrderCreatedEvent(
        Long orderId,
        String product,
        Integer quantity,
        String customerEmail
) {
}
