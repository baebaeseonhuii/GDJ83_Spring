package com.seonhui.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.seonhui.app.members.MemberDTO;
import com.seonhui.app.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	// heyyyyyy
	@Autowired
	private ProductService productService;

	@GetMapping("addWish")
	public String addWish(String p_code, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		int result = productService.addWish(p_code, memberDTO.getId());
		model.addAttribute("msg", result);

		return "commons/result";
	}

	@GetMapping("wishList")
	public void getWishList(HttpSession session, Model model, Pager pager) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		List<ProductDTO> list = productService.getWishList(memberDTO.getId());
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);

	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model, Pager pager) throws Exception {
		List<ProductDTO> list = productService.getList(pager);

		model.addAttribute("pager", pager);
		model.addAttribute("list", list);

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
	public String add(Model model, ProductDTO productDTO, HttpSession session, MultipartFile[] files) throws Exception {
		int result = productService.add(productDTO, session, files);
		String path = "commons/message";
		if (result > 0) {
			path = "redirect:./list";
		} else {
			model.addAttribute("result", "상품을 찾을 수 없습니다.");
			model.addAttribute("url", "./list");
		}

		return path;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
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

	@GetMapping("deleteWishList")
	public String deleteWishList(String p_code, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = productService.deleteWishList(p_code, memberDTO.getId());
		model.addAttribute("msg", result);
		return "commons/result";
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
