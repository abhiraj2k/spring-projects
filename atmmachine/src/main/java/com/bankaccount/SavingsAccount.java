package com.bankaccount;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(String accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
	}

	@Override
	public double withdraw(double amount) {
		if(amount > 30000) {
			throw new IllegalArgumentException("Withdrawal limit is 30000");
		}
		this.accBalance = this.accBalance - amount;
		return this.accBalance;
	}

	@Override
	public double deposit(double amount) {
		if(amount > 1000000) {
			throw new IllegalArgumentException("Deposit limit is 1000000");
		}
		this.accBalance = this.accBalance - amount;
		return this.accBalance;
	}



}
