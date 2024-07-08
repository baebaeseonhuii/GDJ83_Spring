package com.seonhui.app.accounts;

import java.sql.Date;

public class AccountDTO {

	private String ac_num;
	private String id;
	private String p_code;
	private Long account_balance;
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

	public Long getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(Long account_balance) {
		this.account_balance = account_balance;
	}

	public Date getAccount_date() {
		return account_date;
	}

	public void setAccount_date(Date account_date) {
		this.account_date = account_date;
	}

}
