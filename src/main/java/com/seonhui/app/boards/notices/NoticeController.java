package com.seonhui.app.boards.notices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.getList();
		model.addAttribute("list", ar);
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(Model model, NoticeDTO noticeDTO) throws Exception {
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("detail", noticeDTO);
		return "notice/detail";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "notice/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
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
	public String delete(Model model, NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.delete(noticeDTO);
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
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.getDetail(noticeDTO);
		String path = "commons/message";

		if (noticeDTO != null) {
			model.addAttribute("detail", noticeDTO);
			path = "notice/update";

		} else {
			model.addAttribute("result", "게시물 수정에 실패했습니다.");
			model.addAttribute("url", "list");
		}

		return path;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Model model, NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
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
