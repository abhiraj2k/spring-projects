package com.atmmachine;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankaccount.BankAccount;
import com.eventhandler.WithdrawalEventPublisher;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	BankAccount savings =(BankAccount)context.getBean("savingsBankAccount");
    	WithdrawalEventPublisher wPublisher = (WithdrawalEventPublisher)context.getBean("withdrawalEventPublisher");
    	double amount = savings.withdraw(2000);
    	wPublisher.publish(amount);
    }
}
