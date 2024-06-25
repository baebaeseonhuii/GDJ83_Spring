package com.seonhui.app.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	// employee_id, first_name, last_name, job_id만 보여주기
	// java.sql패키지에 있는 date 가져와야됨 다른 패키지가 아니고

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("employee list");
		List<EmployeeDTO> ar = employeeService.getList();
		model.addAttribute("list", ar);
	}
}
