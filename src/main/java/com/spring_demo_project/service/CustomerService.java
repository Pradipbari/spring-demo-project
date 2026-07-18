package com.spring_demo_project.service;

import java.util.List;

import com.spring_demo_project.dto.request.CustomerRequestDto;
import com.spring_demo_project.dto.request.UpdateAgeDto;
import com.spring_demo_project.dto.response.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto getCustomerById(long id);

    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto saveCustomer(CustomerRequestDto requestDto);

    CustomerResponseDto updateCustomer(long id, CustomerRequestDto requestDto);

    CustomerResponseDto updateCustomerAge(long id, UpdateAgeDto ageDto);

    void deleteCustomer(long id);
}