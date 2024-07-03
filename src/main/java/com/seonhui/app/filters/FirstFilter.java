package com.seonhui.app.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FirstFilter
 */
public class FirstFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public FirstFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Filter 객체가 소멸될 때 실행하는 메소드(자동으로 호출)

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		// 요청이 들어올 때 chain.doFilter 실행(다음 필터의 doFilter를 기다림)
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("First Filter In");
		chain.doFilter(request, response);
		System.out.println("First Filter Out");
		// 응답나갈 때 실행

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Filter 객체가 생성될 때 실행

	}

}
