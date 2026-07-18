package com.spring_demo_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_demo_project.dto.request.CustomerRequestDto;
import com.spring_demo_project.dto.request.UpdateAgeDto;
import com.spring_demo_project.dto.response.CustomerResponseDto;
import com.spring_demo_project.entity.Customer;
import com.spring_demo_project.mapper.CustomerMapper;
import com.spring_demo_project.repository.CustomerRepository;
import com.spring_demo_project.service.CustomerService;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper mapper;

    // Business Logic implementation

    @Override
    public CustomerResponseDto getCustomerById(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return mapper.toDto(customer);
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public CustomerResponseDto saveCustomer(CustomerRequestDto requestDto) {

        Customer customer = mapper.toEntity(requestDto);

        Customer savedCustomer = customerRepository.save(customer);

        return mapper.toDto(savedCustomer);
    }

    @Override
    public CustomerResponseDto updateCustomer(long id, CustomerRequestDto requestDto) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Update existing customer
        mapper.map(requestDto, customer);

        Customer updatedCustomer = customerRepository.save(customer);

        return mapper.toDto(updatedCustomer);
    }

    @Override
    public CustomerResponseDto updateCustomerAge(long id, UpdateAgeDto ageDto) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setAge(ageDto.getAge());

        Customer updatedCustomer = customerRepository.save(customer);

        return mapper.toDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customerRepository.delete(customer);
    }
}