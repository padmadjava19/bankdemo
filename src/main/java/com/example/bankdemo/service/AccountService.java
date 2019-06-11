package com.example.bankdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankdemo.entity.Account;
import com.example.bankdemo.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		accountRepository.findAll().forEach(account -> accounts.add(account));
		return accounts;
	}

	public Account getAccountById(Long id) {
		return accountRepository.findById(id).get();
	}

	public void saveOrUpdate(Account account) {
		accountRepository.save(account);
	}

	public void delete(long id) {
		accountRepository.deleteById(id);
	}


}
