package com.seonhui.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seonhui.app.util.DBConnection;

@Repository
public class DepartmentDAO {

	// DI, IOD
	@Autowired
	private DBConnection dbConnection;

	public void getList() throws Exception {
		// DB를 가져오려면
		Connection con = dbConnection.getConnection();

		// SQL(Query문) 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 작성한 쿼리문을 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// ?값 세팅

		// 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();// 미리 보낸 쿼리문을 처리하세요

		while (rs.next()) {
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			System.out.println(id + " : " + name);
		}

		rs.close();
		st.close();
		con.close();

	}
}
