package com.example.demo.mapper;

import com.example.demo.dto.customerDto.CustomerRequestDTO;
import com.example.demo.dto.customerDto.CustomerResponseDTO;
import com.example.demo.models.Customer;

public class CustomerMapper {
    public static Customer toEntity(CustomerRequestDTO dto){
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setPhoneNumber(dto.getPhoneNumber());
        return customer;
    }

    public static CustomerResponseDTO toDto(Customer customer){
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setCustomerId(customer.getCustomerId());
        dto.setName(customer.getName());
        dto.setPhoneNumber(customer.getPhoneNumber());
        return dto;
    }
}
