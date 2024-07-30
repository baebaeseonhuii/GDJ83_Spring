package com.seonhui.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class TestInterceptor extends HandlerInterceptorAdapter {
	
	//controller 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {


		//return이 true라면 다음 인터셉터나 controller로 보냄
		//return이 false라면 진입 막아줌
		
		System.out.println("test interceptor prehandler");
		
		return true;
	}
	
	//controller 나갈때
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("test interceptor posthandler");
	}
	
	//jsp 렌더링 끝난 후(HTML로 만든 후)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("test interceptor afterCompletion");
	}
	
}
