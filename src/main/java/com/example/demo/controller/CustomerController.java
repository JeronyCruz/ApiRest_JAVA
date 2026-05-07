package com.example.demo.controller;

import com.example.demo.dto.common.Response;
import com.example.demo.dto.customerDto.CustomerRequestDTO;
import com.example.demo.dto.customerDto.CustomerResponseDTO;
import com.example.demo.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Response<CustomerResponseDTO>> createCustomer(@Valid @RequestBody CustomerRequestDTO dto){

        CustomerResponseDTO customer = customerService.insertCustomer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>(
                true,
                "Cliente creado correctamente",
                customer
        ));

    }

    @GetMapping
    public List<CustomerResponseDTO> getCustomer(){
        return customerService.listCustomer();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable UUID id){
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<CustomerResponseDTO>> updateCustomer (@Valid @PathVariable UUID id,
                                                                                     @RequestBody CustomerRequestDTO dto) {
        CustomerResponseDTO customer = customerService.updateCustomer(id,dto);
        return ResponseEntity.ok(
                new Response<>(
                        true,
                        "Cliente actualizado correctamente",
                        customer
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteCustomer(@PathVariable UUID id){
        customerService.deleteCustomer(id);

        return ResponseEntity.ok(
                new Response<>(
                        true,
                        "Cliente eliminado correctamente",
                        null
                ));
    }
}
