package com.example.demo.dto.customerDto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@JsonPropertyOrder({ "customerId", "nombre", "telefono" })
public class CustomerResponseDTO {
    private UUID customerId;
    private String name;
    private String phoneNumber;
}
