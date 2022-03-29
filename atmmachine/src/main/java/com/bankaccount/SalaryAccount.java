package com.bankaccount;

public class SalaryAccount extends BankAccount {

	public SalaryAccount(String accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
	}

	@Override
	public double withdraw(double amount) {
		if(amount > 100000 ) {
			throw new IllegalArgumentException("Withdrawal limit is 100000");
		}
		this.accBalance = this.accBalance - amount;
		return this.accBalance;
	}

	@Override
	public double deposit(double amount) {
		this.accBalance = this.accBalance - amount;
		return this.accBalance;
	}

}
