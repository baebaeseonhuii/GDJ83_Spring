package com.seonhui.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seonhui.app.util.Pager;

@Repository
public class ProductDAO {

	// database-context.xml의 org.mybatis.spring.SqlSessionTemplate 찾아감
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.seonhui.app.product.ProductDAO.";

	public Long getTotalCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount");
	}

	public List<ProductDTO> getList(Pager page) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", page);

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		// 결과값 하나가져올땐 selectOne
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public int add(ProductDTO productDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", productDTO); // namespace에 productDTO를 파라미터로 보냄

	}

//
	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", productDTO);

	}

	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", productDTO);
	}
}
