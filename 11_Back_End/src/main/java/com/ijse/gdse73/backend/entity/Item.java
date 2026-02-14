package com.ijse.gdse73.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {

    @Id
    @Column(name = "item_id")
    private String id;   // I001

    private String name;

    private int qty;

    private double price;
}
