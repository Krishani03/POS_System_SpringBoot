package com.ijse.gdse73.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemDTO {

    @NotBlank(message = "Item ID is required")
    private String itemId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int qty;
}
