package com.seonhui.app.records;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecordDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.seonhui.app.records.RecordDAO.";

	public int add(RecordDTO recordDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", recordDTO);
	}

	public int update(RecordDTO recordDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", recordDTO);
	}

}
