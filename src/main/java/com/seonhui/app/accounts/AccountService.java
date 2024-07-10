package com.seonhui.app.accounts;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public int add(AccountDTO accountDTO) throws Exception {
		Calendar calendar = Calendar.getInstance();
		accountDTO.setAc_num(String.valueOf(calendar.getTimeInMillis()));
		return accountDAO.add(accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return accountDAO.detail(accountDTO);
	}

//	public int transfer(AccountDTO accountDTO) throws Exception {
//		return accountDAO.transfer(accountDTO);
//	}
//
//	public int transferInsert(AccountDTO accountDTO) throws Exception {
//		return accountDAO.transferInsert(accountDTO);
//	}
}
