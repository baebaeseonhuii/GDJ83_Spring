package com.seonhui.app.boards;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.seonhui.app.util.Pager;

public interface BoardService {

	// list
	public List<BoardDTO> getList(Pager pager) throws Exception;

	// add
	public int add(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception;

	// update
	public int update(BoardDTO boardDTO) throws Exception;

	// delete
	public int delete(BoardDTO boardDTO) throws Exception;

	// getDetail
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

}
