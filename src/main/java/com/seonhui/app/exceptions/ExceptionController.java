package com.seonhui.app.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //예외를 전문적으로 처리하는 어노테이션
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public String exception1(Model model) {
		return "errors/error_400";
	}
}
