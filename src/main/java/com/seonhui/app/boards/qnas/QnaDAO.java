package com.seonhui.app.boards.qnas;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seonhui.app.boards.BoardDAO;
import com.seonhui.app.boards.BoardDTO;
import com.seonhui.app.boards.BoardFileDTO;
import com.seonhui.app.files.FileDTO;
import com.seonhui.app.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.seonhui.app.boards.qnas.QnaDAO.";

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	@Override
	public Long getNum() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getNum");
	}

	@Override
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "addFile", boardFileDTO);
	}

	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "fileDetail", fileDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", boardDTO);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}

	public int reply(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "reply", qnaDTO);
	}

	public int replyUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "replyUpdate", qnaDTO);
	}

}
