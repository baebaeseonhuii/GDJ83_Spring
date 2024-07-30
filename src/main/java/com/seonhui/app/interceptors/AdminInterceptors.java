package com.seonhui.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seonhui.app.members.MemberDTO;

public class AdminInterceptors extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		if(memberDTO == null) {
			response.sendRedirect("/member/login");
			return false;
		} 
		
		if(!memberDTO.getId().equals("seon")) {
			request.setAttribute("result", "권한이 없습니다.");
			request.setAttribute("url", "/");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/message.jsp");
			view.forward(request, response);
			return false;
		}
		
		return true;
	}
}
