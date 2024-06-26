package com.seonhui.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seonhui.app.util.DBConnection;

@Repository
public class DepartmentDAO {

	// DI, IOD
	@Autowired
	private DBConnection dbConnection;

	public List<DepartmentDTO> getList() throws Exception {
		// DB를 가져오려면
		Connection con = dbConnection.getConnection();

		// SQL(Query문) 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 작성한 쿼리문을 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// ?값 세팅

		// 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();// 미리 보낸 쿼리문을 처리하세요
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();

		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");

			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));

			ar.add(departmentDTO);
		}

		rs.close();
		st.close();
		con.close();

		return ar;

	}

	public DepartmentDTO getDetail(int num) throws Exception {
		// 1. 디비접속
		Connection con = dbConnection.getConnection();

		// 2. sql 작성
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";

		// 3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);// sql injection을 방지한 코드

		// 4. ? 세팅 ?의 인덱스 번호
		st.setInt(1, num);

		// 5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();

		DepartmentDTO departmentDTO = null;

		if (rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
		}

		rs.close();
		st.close();
		con.close();

		return departmentDTO;

	}

	public int add(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "INSERT INTO DEPARTMENTS " + "(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) "
				+ "VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;

	}

	public int delete(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = ?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, departmentDTO.getDepartment_id());

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;

	}

	public int update(DepartmentDTO departmentDTO) throws Exception {
		int result = 0;

		Connection con = dbConnection.getConnection();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? WHERE DEPARTMENT_ID=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());

		result = st.executeUpdate();
		st.close();
		con.close();

		return result;
	}
}
