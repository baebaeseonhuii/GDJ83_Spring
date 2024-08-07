package com.seonhui.app.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seonhui.app.util.Pager;
import com.seonhui.app.util.ProductCommentPager;

@Repository
public class ProductDAO {

	// database-context.xml의 org.mybatis.spring.SqlSessionTemplate 찾아감
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.seonhui.app.product.ProductDAO.";

	public int commentUpdate(ProductCommentDTO productCommentDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "commentUpdate", productCommentDTO);
	}

	public int commentDelete(ProductCommentDTO productCommentDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "commentDelete", productCommentDTO);
	}

	public Long commentTotalCount(ProductCommentPager productCommentPager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "commentTotalCount", productCommentPager);
	}

	public List<ProductCommentDTO> commentList(ProductCommentPager productCommentPager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "commentList", productCommentPager);
	}

	public int commentAdd(ProductCommentDTO productCommentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "commentAdd", productCommentDTO);
	}

	public int addWish(Map<String, Object> map) throws Exception {
		return sqlSession.insert(NAMESPACE + "addWish", map);
	}

	public List<ProductDTO> getWishList(String id) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getWishList", id);
	}

	public int deleteWishList(Map<String, Object> map) throws Exception {
		return sqlSession.delete(NAMESPACE + "deleteWishList", map);
	}

	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	public List<ProductDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		// 결과값 하나가져올땐 selectOne
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public Long getNum() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getNum");
	}

	public int add(ProductDTO productDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", productDTO); // namespace에 productDTO를 파라미터로 보냄

	}

	public int addFile(ProductFileDTO productFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "addFile", productFileDTO); // namespace에 productDTO를 파라미터로 보냄

	}

//
	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", productDTO);

	}

	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", productDTO);
	}
}
