package com.eventhandler;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationListener;

public class TransactionEventHandler implements ApplicationListener<WithdrawalEvent>{
	private void sendSMS() {
		System.out.println("Withdrawal is done");
	}
	public void onApplicationEvent(WithdrawalEvent event) {
		this.sendSMS();
		System.out.println("The amount remaining is:: "+ event.getAmount());
		System.out.println("The date is:: " + new Date(new Timestamp(event.getTimestamp()).getTime()));
	}
}
