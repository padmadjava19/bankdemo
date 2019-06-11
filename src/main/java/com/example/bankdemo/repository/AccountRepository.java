package com.example.bankdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bankdemo.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
