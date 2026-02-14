package com.ijse.gdse73.backend.controller;

import com.ijse.gdse73.backend.dto.OrderDTO;
import com.ijse.gdse73.backend.service.custom.OrderService;
import com.ijse.gdse73.backend.util.APIResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<APIResponse<String>> placeOrder(
            @RequestBody @Valid OrderDTO orderDTO) {

        orderService.placeOrder(orderDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new APIResponse<>(201, "Order Placed Successfully", null));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrderHistory() {
        return ResponseEntity.ok(orderService.getOrderHistory());
    }
}
