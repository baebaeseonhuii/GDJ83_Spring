package com.seonhui.app.product;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seonhui.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;

	@Test
	public void pageTest() {
		long perPage = 10L;
		long totalCount = 131;
		long totalPage = totalCount / perPage;
		long remainder = totalCount % perPage;
		if (remainder != 0) {
			totalPage++;
		}

		System.out.println(totalPage);
	}

//	@Test
//	public void addTest() throws Exception {
//		ProductDTO productDTO = new ProductDTO();
//		for (int i = 0; i < 100; i++) {
//			productDTO.setP_name("자유입출금" + i);
//			productDTO.setP_code("자유입출금" + i);
//			double r = ((int) (Math.random() * 1000)) / 100.0;
//			productDTO.setInterest(r);
//			productDTO.setScript("detail" + i);
//			// productDAO.add(productDTO);
//			Thread.sleep(500); // 0.5초 기다렸다가 다시 실행
//		}
//		System.out.println("finish");
//	}

	@Test
	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setP_code("hahaha");
		productDTO = productDAO.getDetail(productDTO);
		// 단정문
		assertNotNull(productDTO);// productDTO가 null이 아니었으면 좋겠다는 것을 테스트
	}

//	@Test
//	public void addTest() throws Exception {
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setP_code("hohoho");
//		productDTO.setP_name("호호호");
//		productDTO.setInterest(1.2);
//		productDTO.setScript("이 상품의 이자는 1.2입니다.");
//		int result = productDAO.add(productDTO);
//		assertEquals(1, result);
//	}

}
