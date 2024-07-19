package com.seonhui.app.members;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seonhui.app.DefaultTest;

public class MemberDAOTest extends DefaultTest {

	@Autowired
	private MemberDAO memberDAO;

//	@Test
//	public void loginTest() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("gd");
//		memberDTO = memberDAO.login(memberDTO);
//		assertEquals(2, memberDTO.getDtos().size());
//	}

	@Test
	public void addFileTest() throws Exception {
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setFileName("1234_hey.jpg");
		memberFileDTO.setOriName("hey.jpg");
		memberFileDTO.setUserName("jj");
		int result = memberDAO.addFile(memberFileDTO);
		assertEquals(1, result);
	}
}
