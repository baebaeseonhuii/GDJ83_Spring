package com.seonhui.app.boards.notices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.seonhui.app.boards.BoardDAO;
import com.seonhui.app.boards.BoardDTO;
import com.seonhui.app.boards.BoardService;
import com.seonhui.app.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {

		pager.makeRow();

		pager.makeNum(boardDAO.getTotalCount(pager));

		return boardDAO.getList(pager);

	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return boardDAO.getDetail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return boardDAO.add(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return boardDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return boardDAO.delete(boardDTO);
	}
}
