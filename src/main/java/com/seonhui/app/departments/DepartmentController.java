package com.seonhui.app.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public void getList() throws Exception {
		System.out.println("department list");
		departService.getList();

	}
}
