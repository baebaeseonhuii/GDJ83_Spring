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

	<h1>공지사항</h1>
	<div class="container-fluid mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
			<div>
				<a href="add" class="btn btn-outline-success">새 글 작성</a>
			</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>

					<c:forEach items="${list}" var="dto">
						<tbody>
							<tr>
								<td>${dto.boardNum}</td>
								<td><a href="./detail?boardNum=${dto.boardNum}">${dto.boardNum}</a></td>
								<td>${dto.boardWriter}</td>
								<td>${dto.createDate}</td>
								<td>${dto.boardHit}</td>

							</tr>
						</tbody>
					</c:forEach>


				</table>
				<!-- 검색입력폼 -->
				<form  action="./list" method="get" class="row row-cols-lg-auto g-3 align-items-center">
					<div class="col-12">
						<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
						<select name="kind" class="form-select" id="inlineFormSelectPref">
							<option value="k1">작성자</option>
							<option value="k2">제목</option>
							<option value="k2">내용</option>
						</select>
					</div>
					
					<div class="col-12">
						<label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
						<div class="input-group">
							
							<input type="text" name="search" class="form-control"
								id="inlineFormInputGroupUsername" placeholder="검색어를 입력하세요">
						</div>
					</div>
					<div class="col-12">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<li class="page-item"><a
							class="page-link ${map.pre? '' : 'disabled'}"
							href="./list?page=${map.startNum-1}&kind=${map.kind}&search=${map.search}" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
						<c:forEach begin="${map.startNum}" end="${map.lastNum}" step="1"
							var="i">
							<li class="page-item"><a class="page-link"
								href="./list?page=${i}&kind=${map.kind}&search=${map.search}">${i}</a></li>
						</c:forEach>
						<li class="page-item"><a
							class="page-link ${map.next? '' : 'disabled'}"
							href="./list?page=${map.lastNum+1}&kind=${map.kind}&search=${map.search}" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
				
				<a href="/" class="btn btn-success">돌아가기</a>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>