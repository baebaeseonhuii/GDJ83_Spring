package com.seonhui.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seonhui.app.files.FileManager;
import com.seonhui.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileManager fileManager;

	public int addWish(String p_code, String id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_code", p_code);
		map.put("id", id);
		return productDAO.addWish(map);
	}

	public int deleteWishList(String[] p_code, String id) throws Exception {
		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("ids", p_code);
		result = productDAO.deleteWishList(map);
//		for (String pc : p_code) {
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("p_code", pc);
//			map.put("id", id);
//			result = productDAO.deleteWishList(map);
//		}
		return result;
	}

	public List<ProductDTO> getWishList(String id) throws Exception {
		return productDAO.getWishList(id);
	}

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

	public int add(ProductDTO productDTO, HttpSession session, MultipartFile[] files) throws Exception {
		Long num = productDAO.getNum();
		productDTO.setIndex_Of_Lists(num);

		int result = productDAO.add(productDTO);

		if (files == null) {
			return result;
		}

		// 1. 저장할 폴더 지정
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/products");
		System.out.println(path);

		// 2. 저장할 파일 생성
		for (MultipartFile f : files) {
			if (f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);

			// 3. HDD에 파일 저장

			// 4. 파일정보를 DB에 저장
			// 파일명, 원파일명, 상품아이디, 파일번호
			ProductFileDTO productFileDTO = new ProductFileDTO();
			productFileDTO.setFileName(fileName);
			productFileDTO.setOriName(f.getOriginalFilename());
			productFileDTO.setP_code(num);
			result = productDAO.addFile(productFileDTO);
		}

		return result;

	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}

}
