package com.seonhui.app.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seonhui.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;

	@Test
	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setP_code("hahaha");
		productDTO = productDAO.getDetail(productDTO);
		// 단정문
		assertNotNull(productDTO);// productDTO가 null이 아니었으면 좋겠다는 것을 테스트
	}

	@Test
	public void addTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setP_code("hohoho");
		productDTO.setP_name("호호호");
		productDTO.setInterest(1.2);
		productDTO.setScript("이 상품의 이자는 1.2입니다.");
		int result = productDAO.add(productDTO);
		assertEquals(1, result);
	}

}
