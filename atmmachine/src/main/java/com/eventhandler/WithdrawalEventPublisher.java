package com.eventhandler;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class WithdrawalEventPublisher implements ApplicationEventPublisherAware {
	ApplicationEventPublisher publisher;
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	public void publish(final double amount) {
		WithdrawalEvent withdrawalEvent = new WithdrawalEvent(this, amount);
		publisher.publishEvent(withdrawalEvent);
	}

}
