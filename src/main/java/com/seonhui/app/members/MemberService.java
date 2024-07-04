package com.seonhui.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	public int join(MemberDTO memberDTO) throws Exception {

		return memberDAO.join(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		// DB에 있는 id pw 따로, 사용자로부터 받은 매개변수 따로 있어서 둘이 비교해야함
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getPw().equals(memberDTO.getPw())) {
				return result;
			} else {
				return null;
			}
		}

		return result;

	}

	public void logout() {

	}
}
