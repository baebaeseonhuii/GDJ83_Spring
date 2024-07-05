package com.seonhui.app.accounts;

import java.sql.Date;
import java.util.Calendar;

public class AccountDTO {
	Calendar ca = Calendar.getInstance();
	long l = ca.getTimeInMillis();

	private String ac_num = String.valueOf(l);
	private String id;
	private String p_code;
	private int account_balance;
	private Date account_date;

	public String getAc_num() {
		return ac_num;
	}

	public void setAc_num(String ac_num) {
		this.ac_num = ac_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public int getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}

	public Date getAccount_date() {
		return account_date;
	}

	public void setAccount_date(Date account_date) {
		this.account_date = account_date;
	}

}
