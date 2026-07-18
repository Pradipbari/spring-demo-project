package com.spring_demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_demo_project.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
