package com.order.service.order_service.controller;


import com.order.service.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(
            @RequestParam String product,
            @RequestParam Integer quantity,
            @RequestParam String customerEmail) {

        Long orderId =orderService.createOrder(product,quantity,customerEmail);

        return ResponseEntity.ok(
                "Order created successfully. ID = " + orderId
        );
    }
}
