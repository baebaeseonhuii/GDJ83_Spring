package com.seonhui.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seonhui.app.util.DBConnection;

@Repository
public class ProductDAO {

	@Autowired
	private DBConnection dbConnection;

	public List<ProductDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		List<ProductDTO> ar = new ArrayList<ProductDTO>();

		while (rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			String code = rs.getString("P_CODE");
			String name = rs.getString("P_NAME");
			double interest = rs.getDouble("INTEREST");
			String script = rs.getString("SCRIPT");

			productDTO.setP_code(code);
			productDTO.setP_name(name);
			productDTO.setInterest(interest);
			productDTO.setScript(script);

			ar.add(productDTO);

		}
		rs.close();
		st.close();
		con.close();

		return ar;

	}

	public ProductDTO getDetail(String code) throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS WHERE P_CODE=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, code);
		ResultSet rs = st.executeQuery();

		ProductDTO productDTO = null;

		if (rs.next()) {
			productDTO = new ProductDTO();
			String pCode = rs.getString("P_CODE");
			String name = rs.getString("P_NAME");
			double interest = rs.getDouble("INTEREST");
			String script = rs.getString("SCRIPT");

			productDTO.setP_code(pCode);
			productDTO.setP_name(name);
			productDTO.setInterest(interest);
			productDTO.setScript(script);

		}

		rs.close();
		st.close();
		con.close();

		return productDTO;

	}
}
