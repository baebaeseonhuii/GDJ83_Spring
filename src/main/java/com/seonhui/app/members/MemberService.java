package com.seonhui.app.members;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seonhui.app.accounts.AccountDAO;
import com.seonhui.app.files.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private FileManager fileManager;

	private String name = "members";

	public int join(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {

		int result = memberDAO.join(memberDTO);

		if (files == null) {
			return result;
		}

		// application 객체 (ServletContext객체)
		ServletContext servletContext = session.getServletContext();
		// 내 컴퓨터에서 브라우저로 파일을 내보내기
		// 1. 어디에 저장? 배포되는 운영체제의 루트부터, 운영체제가 알고있는 경로
		String path = servletContext.getRealPath("resources/upload/members");

		System.out.println(path);

		String fileName = fileManager.fileSave(path, files);
		// 2. 파일명 설정
		// 1) 시간
//		Calendar calendar = Calendar.getInstance();
//		long n = calendar.getTimeInMillis();
//		String fileName = files.getOriginalFilename();
//		fileName = fileName.substring(fileName.indexOf(".") + 1);
//		System.out.println(fileName);
//		fileName = n + "." + fileName;
//		fileName = n + "_" + files.getOriginalFilename();
//		System.out.println(fileName);

		// 2) 라이브러리 사용
//		fileName = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();
//		System.out.println(fileName);

		// 3. HDD에 파일 저장
		// file = new File(file, fileName); // file이라는 폴더에 fileName을 저장

		// 1) MultipartFile
		// files.transferTo(file);

		// 2) FileCopyUtils
		// FileCopyUtils.copy(files.getBytes(), file);
		// 저장된 파일명을 DB에 저장

		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setUserName(memberDTO.getId());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(files.getOriginalFilename());
		memberDAO.addFile(memberFileDTO);

		return result;
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		// DB에 있는 id pw 따로, 사용자로부터 받은 매개변수 따로 있어서 둘이 비교해야함
		// Map<String, Object> map = new HashMap<String, Object>(); // 객체를 만들수있는 구현클래스

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

	public int update(MemberDTO memberDTO) throws Exception {
		return memberDAO.update(memberDTO);
	}

	public int delete(MemberDTO memberDTO) throws Exception {
		return memberDAO.delete(memberDTO);
	}

	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return memberDAO.detail(memberDTO);
	}
}
