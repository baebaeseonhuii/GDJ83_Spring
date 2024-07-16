package com.seonhui.app.boards.qnas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seonhui.app.boards.BoardDTO;
import com.seonhui.app.boards.BoardService;
import com.seonhui.app.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// rownum
		pager.makeRow();
		// paging
		pager.makeNum(qnaDAO.getTotalCount(pager));
		return qnaDAO.getList(pager);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return qnaDAO.add(boardDTO);
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

	public int reply(QnaDTO qnaDTO) throws Exception {
		QnaDTO parent = (QnaDTO) qnaDAO.getDetail(qnaDTO);
		// 부모를 가져와야 답글에서 insert할 수 있음
		// 1. step에 1씩 업데이트
		int result = qnaDAO.replyUpdate(parent);

		// 2. 답글의 ref, step, depth를 세팅
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);
		return qnaDAO.reply(qnaDTO);
	}

}
