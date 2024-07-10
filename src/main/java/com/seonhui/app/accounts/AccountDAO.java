package com.seonhui.app.accounts;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.seonhui.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountDTO);
	}

//	public int transfer(AccountDTO accountDTO) throws Exception {
//		return sqlSession.update(NAMESPACE + "transfer", accountDTO);
//	}
//
//	public int transferInsert(AccountDTO accountDTO) throws Exception {
//		return sqlSession.insert(NAMESPACE + "transferInsert", accountDTO);
//	}

}
