package com.spring_demo_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_demo_project.dto.request.CustomerRequestDto;
import com.spring_demo_project.dto.request.UpdateAgeDto;
import com.spring_demo_project.dto.response.CustomerResponseDto;
import com.spring_demo_project.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers"
public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	// Get customer by id
    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerById(@PathVariable long id) {
        return customerService.getCustomerById(id);
    }

    // Get all customers
    @GetMapping
    public List<CustomerResponseDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Save customer
    @PostMapping
    public CustomerResponseDto saveCustomer(@RequestBody CustomerRequestDto dto) {
        return customerService.saveCustomer(dto);
    }

    // Update entire customer
    @PutMapping("/{id}")
    public CustomerResponseDto updateCustomer(
            @PathVariable long id,
            @Valid @RequestBody CustomerRequestDto dto) {

        return customerService.updateCustomer(id, dto);
    }

    // Update only age
    @PatchMapping("/{id}")
    public CustomerResponseDto updateCustomerAge(
            @PathVariable long id,
            @RequestBody UpdateAgeDto dto) {

        return customerService.updateCustomerAge(id, dto);
    }

    // Delete customer
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
    }
	
	//handler methods
}
