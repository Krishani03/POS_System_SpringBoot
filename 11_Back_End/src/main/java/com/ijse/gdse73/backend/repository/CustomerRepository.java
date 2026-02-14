package com.ijse.gdse73.backend.repository;

import com.ijse.gdse73.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findTopByOrderByIdDesc(); // get last ID
}
