package com.seonhui.app.boards.notices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seonhui.app.boards.BoardDTO;
import com.seonhui.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {
		List<BoardDTO> ar = noticeService.getList(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("list", ar);
		return "board/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(Model model, BoardDTO boardDTO) throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("detail", boardDTO);
		return "board/detail";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "board/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, BoardDTO boardDTO) throws Exception {
		int result = noticeService.add(boardDTO);
		String path = "commons/message";
		if (result > 0) {
			path = "redirect:./list";
		} else {
			model.addAttribute("result", "게시물을 작성하지 못했습니다. 다시 시도해주세요");
			model.addAttribute("url", "./list");
		}

		return path;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model, BoardDTO boardDTO) throws Exception {
		int result = noticeService.delete(boardDTO);
		String path = "commons/message";
		if (result > 0) {
			path = "redirect:./list";
		} else {
			model.addAttribute("result", "게시물을 지우지 못했습니다.");
			model.addAttribute("url", "./list");
		}
		return path;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		String path = "commons/message";

		if (boardDTO != null) {
			model.addAttribute("detail", boardDTO);
			path = "board/update";

		} else {
			model.addAttribute("result", "게시물 수정에 실패했습니다.");
			model.addAttribute("url", "list");
		}

		return path;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Model model, BoardDTO boardDTO) throws Exception {
		int result = noticeService.update(boardDTO);
		String path = "commons/message";

		if (result > 0) {
			path = "redirect:./list";
		} else {
			model.addAttribute("result", "게시물 등록에 실패했습니다.");
			model.addAttribute("url", "list");
		}
		return path;
	}
}
