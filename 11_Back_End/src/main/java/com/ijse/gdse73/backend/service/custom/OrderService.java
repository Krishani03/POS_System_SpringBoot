package com.ijse.gdse73.backend.service.custom;

import com.ijse.gdse73.backend.dto.OrderDTO;
import java.util.List;

public interface OrderService {
    void placeOrder(OrderDTO orderDTO);
    List<OrderDTO> getOrderHistory();
}
