package com.ijse.gdse73.backend.repository;

import com.ijse.gdse73.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    Order findTopByOrderByIdDesc(); // for auto ID
}

