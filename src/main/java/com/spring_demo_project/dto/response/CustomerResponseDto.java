package com.spring_demo_project.dto.response;

import lombok.Data;

@Data
public class CustomerResponseDto {
	private long id;
	private String name;
	private int age;
	private String gender;
}
