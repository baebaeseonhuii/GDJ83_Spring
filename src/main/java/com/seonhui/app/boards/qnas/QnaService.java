package com.seonhui.app.boards.qnas;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seonhui.app.boards.BoardDTO;
import com.seonhui.app.boards.BoardFileDTO;
import com.seonhui.app.boards.BoardService;
import com.seonhui.app.files.FileDTO;
import com.seonhui.app.files.FileManager;
import com.seonhui.app.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;

	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// rownum
		pager.makeRow();
		// paging
		pager.makeNum(qnaDAO.getTotalCount(pager));
		return qnaDAO.getList(pager);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		Long num = qnaDAO.getNum();
		boardDTO.setBoardNum(num);
		int result = qnaDAO.add(boardDTO);
		if (files == null) {
			return result;
		}
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/QnA");
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
			result = qnaDAO.addFile(boardFileDTO);
		}

		return result;
	}

	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		return qnaDAO.fileDetail(fileDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.delete(boardDTO);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	public int reply(QnaDTO qnaDTO, MultipartFile[] files, HttpSession session) throws Exception {
		QnaDTO parent = (QnaDTO) qnaDAO.getDetail(qnaDTO);
		// 부모를 가져와야 답글에서 insert할 수 있음
		// 1. step에 1씩 업데이트
		int result = qnaDAO.replyUpdate(parent);

		// 2. 답글의 ref, step, depth를 세팅
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);
		result = qnaDAO.reply(qnaDTO);
		if (files == null) {
			return result;
		}
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/QnA");
		System.out.println(path);

		for (MultipartFile f : files) {
			if (f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);

			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(f.getOriginalFilename());
			boardFileDTO.setBoardNum(qnaDTO.getBoardNum());
			result = qnaDAO.addFile(boardFileDTO);
		}
		return result;
	}

}
