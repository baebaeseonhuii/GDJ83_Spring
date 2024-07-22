package com.seonhui.app.boards;

import java.sql.Date;
import java.util.List;

public class BoardDTO {
	private Long boardNum;
	private String boardWriter;
	private Date createDate;
	private String boardTitle;
	private String boardContents;
	private String boardCategory;
	private Date updateDate;
	private Long boardHit;
	private Integer del;
	private List<BoardFileDTO> boardFileDTO;

	public Integer getDel() {
		if (this.del == null) {
			del = 0;
		}
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public Long getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContents() {
		return boardContents;
	}

	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(Long boardHit) {
		this.boardHit = boardHit;
	}

	public List<BoardFileDTO> getBoardFileDTO() {
		return boardFileDTO;
	}

	public void setBoardFileDTO(List<BoardFileDTO> boardFileDTO) {
		this.boardFileDTO = boardFileDTO;
	}
}
