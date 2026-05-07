package com.example.demo.services;


import com.example.demo.dto.customerDto.CustomerRequestDTO;
import com.example.demo.dto.customerDto.CustomerResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerResponseDTO insertCustomer(CustomerRequestDTO dto);
    List<CustomerResponseDTO> listCustomer();
    CustomerResponseDTO getCustomerById(UUID id);
    CustomerResponseDTO updateCustomer(UUID id, CustomerRequestDTO dto);
    void deleteCustomer(UUID id);
}
