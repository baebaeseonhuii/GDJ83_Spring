package com.seonhui.app.members;

import com.seonhui.app.files.FileDTO;

public class MemberFileDTO extends FileDTO {
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
