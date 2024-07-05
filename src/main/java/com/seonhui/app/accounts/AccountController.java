package com.seonhui.app.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account/*")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(AccountDTO accountDTO, Model model) throws Exception {
		int result = accountService.add(accountDTO);
		String path = "commons/message";
		model.addAttribute("result", "계좌계설 성공");
		model.addAttribute("url", "/");
		return path;
	}
}
