package com.seonhui.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seonhui.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList(Pager pager) throws Exception {
		// page = 1 2 3 4
		// 첫번째 숫자 = 1 11 21 31
		// 두번째 숫자 = 10 20 30 40

		pager.makeRow();

		long totalCount = productDAO.getTotalCount(pager);

		pager.makeNum(totalCount);

		return productDAO.getList(pager);

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);
	}

	public int add(ProductDTO productDTO) throws Exception {
		return productDAO.add(productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}

}
