<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootheader.jsp"></c:import>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
</head>
<body>
	<h1>공지사항 내용</h1>
	<div class="container-fluid mt-5">
		<div class="row justify-content-center">
			<div class="col-md-9">
				<table class="table table-striped">
					<thead>
						<tr>
							<th># ${detail.boardNum}</th>
							<th>제목</th>
							<th>${detail.boardTitle}</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>작성자</th>
							<td>${detail.boardWriter}</td>
							<td>등록일: ${detail.createDate}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="2">${detail.boardContents}</td>	
						</tr>
					</tbody>
				</table>
				<div>
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				    <li class="page-item">
				      <a class="page-link" href="./detail?boardNum=${dto.boardNum-1}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;이전글</span>
				      </a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="./detail?boardNum=${dto.boardNum+1}" aria-label="Next">
				        <span aria-hidden="true">다음글&raquo;</span>
				      </a>
				    </li>
				    <li class="page-item justify-content-end">
				      <a href="update?boardNum=${detail.boardNum}" class="btn btn-outline-success">게시글 수정</a>
				    </li>
				    <li class="page-item justify-content-end">
				      <a href="delete?boardNum=${detail.boardNum}" class="btn btn-outline-success">게시글 삭제</a>
				    </li>
				  </ul>
				</nav>
				
				
				</div>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>