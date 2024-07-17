package com.seonhui.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		System.out.println("master");
		// 내장객체 꺼내기
		// 하위 -> 상위 O (request에서 session은 가능)
		// 상위 -> 하위 X (세션에서 리퀘스트 못꺼냄)
		HttpSession session = request.getSession();

//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			System.out.println(c.getName());
//			System.out.println(c.getValue());
//			System.out.println();
//		}
//		Cookie cookie = new Cookie("test", "BSH");
//		cookie.setMaxAge(60);
//		response.addCookie(cookie);
		return "index";
	}

}
