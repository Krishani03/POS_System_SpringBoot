package com.ijse.gdse73.backend.repository;

import com.ijse.gdse73.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    Item findTopByOrderByIdDesc(); // for auto ID
}
