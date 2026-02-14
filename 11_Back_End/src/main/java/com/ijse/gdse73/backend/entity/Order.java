package com.ijse.gdse73.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @Column(name = "order_id")
    private String id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "order_date")
    private String date;

    @Column(name = "total_amount")
    private double total;
}
