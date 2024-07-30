package com.seonhui.app.interceptors;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seonhui.app.boards.BoardDTO;
import com.seonhui.app.members.MemberDTO;
import com.seonhui.app.product.ProductDTO;

public class WriterInterceptor extends HandlerInterceptorAdapter {
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		if(method.toUpperCase().equals("POST")) {
			return;
		}
		
		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");

		Map<String, Object> map = modelAndView.getModel();
		Iterator<String> it = map.keySet().iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		BoardDTO boardDTO = (BoardDTO) map.get("detail");
		if (!boardDTO.getBoardWriter().equals(memberDTO.getId())) {
//			modelAndView.setViewName("redirect:/");
			
			modelAndView.setViewName("commons/message");
			modelAndView.addObject("result", "작성자만 수정 가능합니다");
			modelAndView.addObject("url", "/");
		}
	}
}
