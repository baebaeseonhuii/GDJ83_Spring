package com.seonhui.app.product;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	// heyyyyyy
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Long page, Model model) throws Exception {
		Map<String, Object> map = productService.getList(page);
		model.addAttribute("map", map);

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(Model model, ProductDTO productDTO) throws Exception {
		productDTO = productService.getDetail(productDTO);
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
	public String add() throws Exception {

		return "product/add";
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
	public String delete(Model model, ProductDTO productDTO) throws Exception {
		int result = productService.delete(productDTO);
		String path = "commons/message";
		if (result > 0) {
			path = "redirect:./list";
		} else {
			model.addAttribute("result", "상품을 지우지 못했습니다.");
			model.addAttribute("url", "./list");
		}
		return path;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.getDetail(productDTO);
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
