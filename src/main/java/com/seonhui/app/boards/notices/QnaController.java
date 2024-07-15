package com.seonhui.app.boards.notices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@GetMapping("list")
	public ModelAndView getList(ModelAndView mv) throws Exception {
		mv.setViewName("board/list");
		return mv;
	}

	@GetMapping("detail")
	public ModelAndView getDetail(ModelAndView mv) throws Exception {
		mv.setViewName("board/detail");
		return mv;
	}

	@GetMapping("add")
	public ModelAndView add(ModelAndView mv) throws Exception {
		mv.setViewName("board/add");
		return mv;
	}

	@GetMapping("update")
	public ModelAndView update(ModelAndView mv) throws Exception {
		mv.setViewName("board/update");
		return mv;
	}

	@GetMapping("delete")
	public ModelAndView delete(ModelAndView mv) throws Exception {
		mv.setViewName("board/list");
		return mv;
	}

}
