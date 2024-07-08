package com.seonhui.app.members;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() throws Exception {
		return "member/join";
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, Model model) throws Exception {
		int result = memberService.join(memberDTO);
		String path = "commons/message";
		model.addAttribute("result", "회원가입 성공");
		model.addAttribute("url", "/");
		return path;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model, @CookieValue(name = "remember", required = false, defaultValue = "") String value) {
		// 쿠키를 꺼내서 그 값을 보내줌
		model.addAttribute("id", value);
//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			if (c.getName().equals("remember")) {
//				request.setAttribute("id", c.getValue());
//			}
//		}

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO, Model model, String remember, HttpServletResponse response,
			HttpSession session) throws Exception {
		// 로그인할때 회원정보&계좌정보 같이 세션에 담기
		if (remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getId());
			cookie.setMaxAge(60 * 30);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		// memberDTO = memberService.login(memberDTO);
		memberDTO = memberService.login(memberDTO);
		String path = "commons/message";
		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);
			model.addAttribute("result", "로그인 성공");
			model.addAttribute("url", "/");
		} else {
			model.addAttribute("result", "로그인 실패");
			model.addAttribute("url", "./login");
		}
		return path;
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate(); // 세션의 유지시간을 0으로 함
		// invalidate()안쓰고싶으면
//		session.setAttribute("member", null);
//		session.removeAttribute("member");
//		session.removeValue(null);
//		session.isNew();
		return "redirect:/";
	}

	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage(Model model, HttpSession session) throws Exception {
		// MemberDTO dto = (MemberDTO) session.getAttribute("member");

		// dto = memberService.login(dto);
		// model.addAttribute("member", dto);

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update() throws Exception {
		return "member/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO, Model model, HttpSession session) throws Exception {
		int result = memberService.update(memberDTO);
		session.setAttribute("member", memberDTO);
		String path = "commons/message";
		model.addAttribute("result", "수정하셨습니다.");
		model.addAttribute("url", "./mypage");
		return path;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(Model model, HttpSession session, MemberDTO memberDTO) throws Exception {
		memberDTO = (MemberDTO) session.getAttribute("member");
		int result = memberService.delete(memberDTO);
		String path = "commons/message";
		if (result > 0) {
			session.invalidate();
			model.addAttribute("result", "탈퇴하셨습니다.");
			model.addAttribute("url", "../");
		} else {
			model.addAttribute("result", "탈퇴 못하셨습니다.");
			model.addAttribute("url", "./mypage");
		}
		return path;
	}

}
