package com.springboot.my.org.crudapi.models;

import java.util.Date;

public class Bonus {
	private int workerRefId;
	 private int bonusAmount;
	 private Date bonusDate;
	 
	 public Bonus(int workerRefId, int bonusAmount) {
		 super();
		 this.workerRefId = workerRefId;
		 this.bonusAmount = bonusAmount;
		 this.bonusDate = new Date();
	 }
	public Bonus(int workerRefId, int bonusAmount, Date bonusDate) {
		super();
		this.workerRefId = workerRefId;
		this.bonusAmount = bonusAmount;
		this.bonusDate = bonusDate;
	}
	public Bonus(int bonusAmount) {
		this.bonusAmount = bonusAmount;
		this.bonusDate = new Date();
	}
	
	public int getWorkerRefId() {
		return workerRefId;
	}
	public void setWorkerRefId(int workerRefId) {
		this.workerRefId = workerRefId;
	}
	public int getBonusAmount() {
		return bonusAmount;
	}
	public void setBonusAmount(int bonusAmount) {
		this.bonusAmount = bonusAmount;
	}
	public Date getBonusDate() {
		return bonusDate;
	}
	public void setBonusDate(Date bonusDate) {
		this.bonusDate = bonusDate;
	}
	 
	@Override
	public String toString() {
		return "Bonus [workerRefId=" + workerRefId + ", bonusAmount=" + bonusAmount + ", bonusDate=" + bonusDate + "]";
	}
}
