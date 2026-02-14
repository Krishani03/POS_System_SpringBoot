package com.ijse.gdse73.backend.service.custom.impl;

import com.ijse.gdse73.backend.dto.ItemDTO;
import com.ijse.gdse73.backend.dto.OrderDTO;
import com.ijse.gdse73.backend.dto.OrderItemDTO;
import com.ijse.gdse73.backend.entity.Item;
import com.ijse.gdse73.backend.entity.Order;
import com.ijse.gdse73.backend.repository.ItemRepository;
import com.ijse.gdse73.backend.repository.OrderRepository;
import com.ijse.gdse73.backend.service.custom.ItemService;
import com.ijse.gdse73.backend.service.custom.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemService itemService;

    @Transactional
    @Override
    public void placeOrder(OrderDTO orderDTO) {


        Order lastOrder = orderRepository.findTopByOrderByIdDesc();

        String newId;

        if (lastOrder == null) {
            newId = "O001";
        } else {
            int number = Integer.parseInt(lastOrder.getId().substring(1));
            number++;
            newId = String.format("O%03d", number);
        }

        double total = 0;


        for (OrderItemDTO orderItem : orderDTO.getItems()) {

            ItemDTO item = itemService.getItemById(orderItem.getItemId());

            if (orderItem.getQty() > item.getQty()) {
                throw new RuntimeException(
                        "Insufficient stock for item: " + item.getName()
                );
            }

            total += item.getPrice() * orderItem.getQty();

            // Reduce stock
            itemService.reduceStock(orderItem.getItemId(), orderItem.getQty());
        }


        Order order = new Order();
        order.setId(newId);
        order.setCustomerId(orderDTO.getCustomerId());
        order.setDate(orderDTO.getDate());
        order.setTotal(total);

        orderRepository.save(order);
    }

    @Override
    public List<OrderDTO> getOrderHistory() {

        return orderRepository.findAll()
                .stream()
                .map(order -> new OrderDTO(
                        order.getId(),
                        order.getCustomerId(),
                        order.getDate(),
                        order.getTotal(),
                        null
                ))
                .toList();
    }
}
