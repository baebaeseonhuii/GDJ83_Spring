package com.seonhui.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*") // parsing할 필요가 없어짐
public class DepartmentController {

	// IOC:Inversion Of Control 스프링 프레임워크가 개발자가 할 일을 대신 함
	// Controller, Service, Repository(DAO역할), Component(앞의 세가지 아닌 그 외 것)

	@Autowired
	private DepartmentService departService;

	@RequestMapping(value = "list", method = RequestMethod.GET) // 어떤 url이 왔을때 실행
	public void getList(Model model) throws Exception {
		System.out.println("department list");
		List<DepartmentDTO> ar = departService.getList();

		// Model+View
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("list", mv); //request.setAttribute랑 같음
		// return mv;

		model.addAttribute("list", ar);

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(Model model, int department_id) throws Exception {
		// 클라이언트의 parameter 이름이 매개변수명이랑 같으면 됨
		DepartmentDTO departmentDTO = departService.getDetail(department_id);

		String path = "commons/message";

		if (departmentDTO != null) {
			model.addAttribute("detail", departmentDTO);
			path = "department/detail";
		} else {
			model.addAttribute("result", "부서를 찾을 수 없습니다.");
			model.addAttribute("url", "./list");
		}
		return path;

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(DepartmentDTO departmentDTO, Model model) throws Exception {

		int result = departService.add(departmentDTO);
		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message.jsp";
			model.addAttribute("result", "부서 등록에 실패했습니다.");
			model.addAttribute("url", "./list");
		}

		return url;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public void delete() {

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update() {

	}
}
