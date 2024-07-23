package com.seonhui.app.boards;

import java.util.List;

import com.seonhui.app.files.FileDTO;
import com.seonhui.app.util.Pager;

public interface BoardDAO {
	Long getTotalCount(Pager pager) throws Exception;

	// public 이랑 abstract는 interface class 안에서 생략 가능
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;

	// add
	public int add(BoardDTO boardDTO) throws Exception;

	// addFile
	public int addFile(BoardFileDTO boardFileDTO) throws Exception;

	// get SEQ number
	Long getNum() throws Exception;

	// update
	int update(BoardDTO boardDTO) throws Exception;

	// delete
	int delete(BoardDTO boardDTO) throws Exception;

	// getDetail
	BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

	// fileDetail
	FileDTO fileDetail(FileDTO fileDTO) throws Exception;

}
