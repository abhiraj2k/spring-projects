package com.bankaccount;

import com.eventhandler.WithdrawalEventPublisher;

public abstract class BankAccount {
	String accNum;
	String accHolder;
	double accBalance;
	public BankAccount(String accNum, String accHolder, double accBalance) {
		super();
		this.accNum = accNum;
		this.accHolder = accHolder;
		this.accBalance = accBalance;
	}
	public void showBalance() {
		System.out.println("Account Balance is:: "+ this.accBalance);
	}
	public abstract double withdraw(double amount);
	public abstract double deposit(double amount);
	
}
