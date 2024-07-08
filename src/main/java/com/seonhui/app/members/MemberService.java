package com.seonhui.app.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seonhui.app.accounts.AccountDAO;
import com.seonhui.app.accounts.AccountDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

	public int join(MemberDTO memberDTO) throws Exception {
		return memberDAO.join(memberDTO);
	}

	public Map<String, Object> login(MemberDTO memberDTO) throws Exception {
		// DB에 있는 id pw 따로, 사용자로부터 받은 매개변수 따로 있어서 둘이 비교해야함
		Map<String, Object> map = new HashMap<String, Object>(); // 객체를 만들수있는 구현클래스

		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getPw().equals(memberDTO.getPw())) {
				List<AccountDTO> ar = accountDAO.list(memberDTO);// 중복가능, 순서유지 가능
				map.put("member", result);
				map.put("account", ar);
				return map;
			} else {
				return null;
			}
		}

		return null;

	}

	public int update(MemberDTO memberDTO) throws Exception {
		return memberDAO.update(memberDTO);
	}

	public int delete(MemberDTO memberDTO) throws Exception {
		return memberDAO.delete(memberDTO);
	}
}
