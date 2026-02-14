package com.ijse.gdse73.backend.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIResponse<T> {

    private int status;
    private String message;
    private T data;
}
