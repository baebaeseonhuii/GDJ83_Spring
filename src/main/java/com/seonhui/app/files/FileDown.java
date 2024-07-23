package com.seonhui.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDown extends AbstractView {
	// 하드디스크의 파일을 찾아서 클라이언트에 보내주는 메소드
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("File Down View");
//		Iterator<String> keys = model.keySet().iterator();
//		while (keys.hasNext()) {
//			String k = keys.next();
//			System.out.println(k);
//		}
		FileDTO fileDTO = (FileDTO) model.get("file");

		// 1. 경로 준비
		String directory = (String) model.get("board");

		String path = request.getSession().getServletContext().getRealPath("resources/upload/" + directory);

		// 2. 파일 준비
		File file = new File(path, fileDTO.getFileName());

		// 3. 응답시 한글 인코딩
		response.setCharacterEncoding("UTF-8");

		// 4. 파일의 크기
		response.setContentLength((int) file.length());

		// 5. 다운로드시 파일이름을 지정하고 인코딩 설정
		String name = fileDTO.getOriName();
		name = URLEncoder.encode(name, "UTF-8");

		// 6. 헤더 정보 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + name + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary"); // 운반할 때 쓰는 인코딩: 이진데이터

		// 7. 클라이언트에게 전송
		// 1) HDD에서 파일을 읽어와서 2)클라이언트로 아웃풋
		FileInputStream fi = new FileInputStream(file); // 매개변수로 어느경로의 어느파일을 읽어올건지를 받음
		OutputStream os = response.getOutputStream();

		FileCopyUtils.copy(fi, os); // 읽어오기, 내보내기

		// 8. 자원 해제
		os.close();
		fi.close();

	}

}
