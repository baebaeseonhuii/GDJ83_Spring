package com.seonhui.app.members;

import java.util.List;

import com.seonhui.app.accounts.AccountDTO;

public class MemberDTO {
	private String id;
	private String phone;
	private String pw;
	private String name;
	private String ss_num;
	private String email;
	private List<AccountDTO> dtos; // member는 account를 가지고 있다(사용자는 계좌를 여러 개 가지고 있다)
	// DTO는 테이블과 같다

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSs_num() {
		return ss_num;
	}

	public void setSs_num(String ss_num) {
		this.ss_num = ss_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AccountDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<AccountDTO> dtos) {
		this.dtos = dtos;
	}
}
