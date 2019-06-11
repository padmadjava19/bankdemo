package com.example.bankdemo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankdemo.data.Transaction;
import com.example.bankdemo.entity.Account;
import com.example.bankdemo.entity.Customer;
import com.example.bankdemo.service.AccountService;
import com.example.bankdemo.service.CustomerService;

@RestController
@RequestMapping("/bankdemo")
public class BankDemoController {
	@Autowired
	CustomerService customerService;

	@Autowired
	AccountService accountService;

	// CRUD operations on Customers

	@GetMapping("/customers")
	private List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/customers/{id}")
	private Customer getCustomer(@PathVariable("id") Long id) {
		return customerService.getCustomerById(id);
	}

	@DeleteMapping("/customers/{id}")
	private void deleteCustomer(@PathVariable("id") Long id) {
		customerService.delete(id);
	}

	@PostMapping("/customers")
	private Long saveCustomer(@RequestBody Customer customer) {
		customerService.saveOrUpdate(customer);
		return customer.getId();
	}

	// CRUD operations Accounts

	@GetMapping("/accounts")
	private List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/accounts/{id}")
	private Account getAccount(@PathVariable("id") Long id) {
		return accountService.getAccountById(id);
	}

	@DeleteMapping("/accounts/{id}")
	private void deleteAccount(@PathVariable("id") Long id) {
		accountService.delete(id);
	}

	@PostMapping("/accounts")
	private Long saveAccount(@RequestBody Account account) {
		accountService.saveOrUpdate(account);
		return account.getId();
	}

	@PostMapping("/performTransaction")
	private Boolean performTransaction(@RequestBody Transaction transaction) {
		if (transaction.getTransactionType().equalsIgnoreCase("DEPOSIT")) {
			Account account = accountService.getAccountById(transaction.getAccountId());
			account.setBalance(account.getBalance() + transaction.getAmount());
			account.setCreditorDebitDate(new Date());
			accountService.saveOrUpdate(account);

		} else if (transaction.getTransactionType().equalsIgnoreCase("WITHDRAW")) {
			Account account = accountService.getAccountById(transaction.getAccountId());
			account.setBalance(account.getBalance() - transaction.getAmount());
			account.setCreditorDebitDate(new Date());
			accountService.saveOrUpdate(account);
		} else if (transaction.getTransactionType().equalsIgnoreCase("TRANSFER")) {
			Account fromAccount = accountService.getAccountById(transaction.getFromAccountId());
			fromAccount.setBalance(fromAccount.getBalance() - transaction.getAmount());
			fromAccount.setCreditorDebitDate(new Date());
			Account toAccount = accountService.getAccountById(transaction.getToAccountId());
			toAccount.setBalance(toAccount.getBalance() + transaction.getAmount());
			toAccount.setCreditorDebitDate(new Date());
			accountService.saveOrUpdate(fromAccount);
			accountService.saveOrUpdate(toAccount);
		}

		return true;
	}

}
