package com.ijse.gdse73.backend.service.custom.impl;

import com.ijse.gdse73.backend.dto.CustomerDTO;
import com.ijse.gdse73.backend.entity.Customer;
import com.ijse.gdse73.backend.exception.CustomException;
import com.ijse.gdse73.backend.repository.CustomerRepository;
import com.ijse.gdse73.backend.service.custom.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {

        Customer lastCustomer = customerRepository.findTopByOrderByIdDesc();

        String newId;

        if (lastCustomer == null) {
            newId = "C001";
        } else {
            String lastId = lastCustomer.getId();
            int number = Integer.parseInt(lastId.substring(1));
            number++;
            newId = String.format("C%03d", number);
        }

        customerDTO.setId(newId);

        customerRepository.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

        if (customerDTO.getId() == null || customerDTO.getId().isEmpty()) {
            throw new CustomException("Customer ID required for update");
        }

        if (!customerRepository.existsById(customerDTO.getId())) {
            throw new CustomException("Customer not found");
        }

        customerRepository.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public void deleteCustomer(String id) {

        if (!customerRepository.existsById(id)) {
            throw new CustomException("Customer not found");
        }

        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .toList();
    }
}
