package com.eventhandler;

import org.springframework.context.ApplicationEvent;

public class WithdrawalEvent extends ApplicationEvent {
	private double amount;
	public WithdrawalEvent(Object obj, double amount) {
		super(obj);
		this.amount = amount;
	}
	public double getAmount() {
		return this.amount;
	}
}
