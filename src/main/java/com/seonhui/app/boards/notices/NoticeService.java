package com.seonhui.app.boards.notices;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seonhui.app.boards.BoardDAO;
import com.seonhui.app.boards.BoardDTO;
import com.seonhui.app.boards.BoardFileDTO;
import com.seonhui.app.boards.BoardService;
import com.seonhui.app.files.FileDTO;
import com.seonhui.app.files.FileManager;
import com.seonhui.app.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	@Qualifier("noticeDAO") // 빈의 이름이 noticeDAO인걸 찾아서 boardDAO에 넣어달라
	private BoardDAO boardDAO;

	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {

		pager.makeRow();

		pager.makeNum(boardDAO.getTotalCount(pager));

		return boardDAO.getList(pager);

	}

	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return boardDAO.getDetail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		Long num = boardDAO.getNum();
		boardDTO.setBoardNum(num);
		int result = boardDAO.add(boardDTO);
		if (files == null) {
			return result;
		}
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/Notice");
		System.out.println(path);

		for (MultipartFile f : files) {
			if (f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);

			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(f.getOriginalFilename());
			boardFileDTO.setBoardNum(num);
			result = boardDAO.addFile(boardFileDTO);
		}

		return result;
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
