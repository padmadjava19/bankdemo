package com.example.bankdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bankdemo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
