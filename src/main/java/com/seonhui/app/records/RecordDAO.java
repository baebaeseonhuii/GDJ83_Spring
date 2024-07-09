package com.seonhui.app.records;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class RecordDAO {

	private SqlSession sqlSession;

	private final String NAMESPACE = "com.seonhui.app.records.RecordDAO.";

}
