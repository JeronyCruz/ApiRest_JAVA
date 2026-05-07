package com.example.demo.services.impl;

import com.example.demo.dto.customerDto.CustomerRequestDTO;
import com.example.demo.dto.customerDto.CustomerResponseDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDTO insertCustomer(CustomerRequestDTO dto){
        Customer customer = CustomerMapper.toEntity(dto);
        Customer customerSaved = customerRepository.save(customer);
        return CustomerMapper.toDto(customerSaved);
    }

    public CustomerResponseDTO updateCustomer(UUID id, CustomerRequestDTO dto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cliente no encontrado con id: " + id)
                );

        // actualizar campos
        customer.setName(dto.getName());
        customer.setPhoneNumber(dto.getPhoneNumber());

        Customer CustomerTechnician = customerRepository.save(customer);
        return CustomerMapper.toDto(CustomerTechnician);
    }

//    public CustomerResponseDTO saveCustomer(CustomerRequestDTO dto){
//        if (!customerRepository.existsById(dto.)){
//            return insertCustomer(dto);
//        }else {
//            return updateCustomer(id,dto);
//        }
//    }

    @Override
    public List<CustomerResponseDTO> listCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDTO getCustomerById(UUID id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cliente no encontrado con id: " + id)
                );

        return CustomerMapper.toDto(customer);
    }

    @Override
    public void deleteCustomer(UUID id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente no encontrado con id: " + id);
        }
        customerRepository.deleteById(id);
    }
}
