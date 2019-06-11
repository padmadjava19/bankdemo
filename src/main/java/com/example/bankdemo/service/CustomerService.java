package com.example.bankdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankdemo.repository.CustomerRepository;
import com.example.bankdemo.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customer -> customers.add(customer));
		return customers;
	}

	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).get();
	}

	public void saveOrUpdate(Customer customer) {
		customerRepository.save(customer);
	}

	public void delete(long id) {
		customerRepository.deleteById(id);
	}
}
