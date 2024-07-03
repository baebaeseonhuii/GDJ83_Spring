package com.seonhui.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

	// database-context.xml의 org.mybatis.spring.SqlSessionTemplate 찾아감
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.seonhui.app.product.ProductDAO.";

	public List<ProductDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList");

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		// 결과값 하나가져올땐 selectOne
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public int add(ProductDTO productDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", productDTO);

	}
//
//	public int update(ProductDTO productDTO) throws Exception {
//		int result = 0;
//		Connection con = dbConnection.getConnection();
//		String sql = "UPDATE PRODUCTS SET P_CODE=?, P_NAME=?, INTEREST=?, SCRIPT=? WHERE INDEX_OF_LISTS=?";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, productDTO.getP_code());
//		st.setString(2, productDTO.getP_name());
//		st.setDouble(3, productDTO.getInterest());
//		st.setString(4, productDTO.getScript());
//		st.setInt(5, productDTO.getIndexOfLists());
//
//		result = st.executeUpdate();
//		st.close();
//		con.close();
//
//		return result;
//
//	}
}
