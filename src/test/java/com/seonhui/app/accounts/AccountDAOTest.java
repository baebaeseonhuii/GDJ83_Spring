package com.seonhui.app.accounts;

import org.springframework.beans.factory.annotation.Autowired;

import com.seonhui.app.DefaultTest;

public class AccountDAOTest extends DefaultTest {

	@Autowired
	private AccountDAO accountDAO;

//	@Test
//	public void detailTest() throws Exception {
//		AccountDTO accountDTO = new AccountDTO();
//		accountDTO.setAc_num("1720399341967");
//		int a = accountDAO.transfer(accountDTO);
//		assertNotNull(a);
//	}

}
