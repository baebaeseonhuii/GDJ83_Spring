package com.seonhui.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<ProductDTO> ar = productService.getList();
		model.addAttribute("list", ar);

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(Model model, String p_code) throws Exception {
		System.out.println("detail");
		ProductDTO productDTO = productService.getDetail(p_code);
		String path = "commons/message";
		if (productDTO != null) {
			model.addAttribute("detail", productDTO);
			path = "product/detail";
		} else {
			model.addAttribute("result", "상품을 찾을 수 없습니다.");
			model.addAttribute("url", "./list");

		}
		return path;

	}
}
