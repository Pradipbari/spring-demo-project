package com.spring_demo_project.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring_demo_project.dto.request.CustomerRequestDto;
import com.spring_demo_project.dto.response.CustomerResponseDto;
import com.spring_demo_project.entity.Customer;

@Component
public class CustomerMapper {
	@Autowired
	private ModelMapper mapper;
	
	public CustomerResponseDto toDto(Customer customer){
		return mapper.map(customer, CustomerResponseDto.class);
	}
	
	public Customer toEntity(CustomerRequestDto requestDto) {
		return mapper.map(requestDto, Customer.class);
	}
	
	public void map(CustomerRequestDto dto,Customer c) {
		mapper.map(dto, c);
	}
	
}
