package com.seonhui.app.records;

import java.sql.Date;

public class RecordDTO {
	private String transaction_code;
	private String ac_num;
	private Long money;
	private Date timestamp;
	private Long balance;
	private String type_of_transaction;
	private String account_u;
	private String order;

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getAccount_u() {
		return account_u;
	}

	public void setAccount_u(String account_u) {
		this.account_u = account_u;
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

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
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

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getType_of_transaction() {
		return type_of_transaction;
	}

	public void setType_of_transaction(String type_of_transaction) {
		this.type_of_transaction = type_of_transaction;
	}
}
