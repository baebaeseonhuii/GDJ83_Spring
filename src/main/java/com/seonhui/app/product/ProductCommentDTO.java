package com.seonhui.app.product;

import com.seonhui.app.boards.CommentDTO;

public class ProductCommentDTO extends CommentDTO {
	private String p_code;

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

}
