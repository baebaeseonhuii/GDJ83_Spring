package com.seonhui.app.accounts;

public class ListOption {
	private String ac_num;
	private Integer order;
	private Integer depositOrWithdraw;

	public Integer getDepositOrWithdraw() {
		return depositOrWithdraw;
	}

	public void setDepositOrWithdraw(Integer depositOrWithdraw) {
		this.depositOrWithdraw = depositOrWithdraw;
	}

	public String getAc_num() {
		return ac_num;
	}

	public void setAc_num(String ac_num) {
		this.ac_num = ac_num;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}
