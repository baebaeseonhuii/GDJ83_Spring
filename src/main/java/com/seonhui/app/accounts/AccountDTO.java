package com.seonhui.app.accounts;

import java.sql.Date;

import com.seonhui.app.members.MemberDTO;
import com.seonhui.app.product.ProductDTO;
import com.seonhui.app.records.RecordDTO;

public class AccountDTO {

	private String ac_num;
	private String id;
	private String p_code;
	private Long account_balance;
	private Date account_date;
	private MemberDTO memberDTO;
	private ProductDTO productDTO;
	private RecordDTO recordDTO;
	private String recipient_account;

	public RecordDTO getRecordDTO() {
		return recordDTO;
	}

	public void setRecordDTO(RecordDTO recordDTO) {
		this.recordDTO = recordDTO;
	}

	public String getRecipient_account() {
		return recipient_account;
	}

	public void setRecipient_account(String recipient_account) {
		this.recipient_account = recipient_account;
	}

	private double money;

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

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
