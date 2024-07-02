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

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, ProductDTO productDTO) throws Exception {
		int result = productService.add(productDTO);
		String path = "commons/message";
		if (result > 0) {
			path = "redirect:./list";
		} else {
			model.addAttribute("result", "상품을 찾을 수 없습니다.");
			model.addAttribute("url", "./list");
		}

		return path;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public void delete() throws Exception {

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(String p_code, Model model) throws Exception {
		ProductDTO productDTO = productService.getDetail(p_code);
		String path = "commons/message";

		if (productDTO != null) {
			model.addAttribute("detail", productDTO);
			path = "product/update";

		} else {
			model.addAttribute("result", "상품 수정에 실패했습니다.");
			model.addAttribute("url", "list");
		}

		return path;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Model model, ProductDTO productDTO) throws Exception {
		int result = productService.update(productDTO);
		String path = "commons/message";

		if (result > 0) {
			path = "redirect:./list";
		} else {
			model.addAttribute("result", "상품 등록에 실패했습니다.");
			model.addAttribute("url", "list");
		}
		return path;
	}

}
