package com.seonhui.app.records;

import java.sql.Date;

public class RecordDTO {
	private String transaction_code;
	private String ac_num;
	private double money;
	private Date timestamp;
	private double balance;
	private String type_of_transaction;
	private String recipient_account;

	public String getRecipient_account() {
		return recipient_account;
	}

	public void setRecipient_account(String recipient_account) {
		this.recipient_account = recipient_account;
	}

	public String getTransaction_code() {
		return transaction_code;
	}

	public void setTransaction_code(String transaction_code) {
		this.transaction_code = transaction_code;
	}

	public String getAc_num() {
		return ac_num;
	}

	public void setAc_num(String ac_num) {
		this.ac_num = ac_num;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType_of_transaction() {
		return type_of_transaction;
	}

	public void setType_of_transaction(String type_of_transaction) {
		this.type_of_transaction = type_of_transaction;
	}
}
