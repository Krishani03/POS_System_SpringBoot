package com.ijse.gdse73.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    private String id;

    @NotBlank(message = "Customer name is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    @Size(min = 5, message = "Address must be at least 5 characters")
    private String address;
}
