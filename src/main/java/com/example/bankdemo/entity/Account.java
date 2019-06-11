package com.example.bankdemo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double balance;
	private Double creaditorDebitAmt;
	private Date creditorDebitDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer")
	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getCreaditorDebitAmt() {
		return creaditorDebitAmt;
	}

	public void setCreaditorDebitAmt(Double creaditorDebitAmt) {
		this.creaditorDebitAmt = creaditorDebitAmt;
	}

	public Date getCreditorDebitDate() {
		return creditorDebitDate;
	}

	public void setCreditorDebitDate(Date creditorDebitDate) {
		this.creditorDebitDate = creditorDebitDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
