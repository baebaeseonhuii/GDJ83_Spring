package com.seonhui.app.accounts;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seonhui.app.members.MemberDTO;
import com.seonhui.app.records.RecordDTO;
import com.seonhui.app.records.RecordService;

@Controller
@RequestMapping("/account/*")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private RecordService recordService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(AccountDTO accountDTO, Model model, HttpSession session) throws Exception {
		String id = ((MemberDTO) session.getAttribute("member")).getId();
		accountDTO.setId(id);
		int result = accountService.add(accountDTO);
		String path = "commons/message";
		model.addAttribute("result", "계좌계설 성공");
		model.addAttribute("url", "/");
		return path;
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(Model model, AccountDTO accountDTO) throws Exception {
		accountDTO = accountService.detail(accountDTO);

		model.addAttribute("account", accountDTO);
	}

	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public void transfer() throws Exception {
	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transfer(RecordDTO recordDTO) throws Exception {
		// recordDTO: 계좌번호가 1개
		// 보내는 계좌의 파라미터 이름: ac_num
		// 받는 계좌의 파라미터 이름: account_u

		int result = recordService.record(recordDTO);
		return "redirect:/member/mypage";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(ListOption listOption, Model model) throws Exception {
		List<RecordDTO> ar = recordService.list(listOption);
		model.addAttribute("list", ar);
	}

}
