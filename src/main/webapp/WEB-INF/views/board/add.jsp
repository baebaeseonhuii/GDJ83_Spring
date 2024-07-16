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
<div class="container">
		<div class="row">
			<h1>${board} 작성</h1>
		</div>
		<div class="container-fluid mt-5">
		<div class="row">
			<form method="post">
				<input type="hidden" value="${detail.boardNum}" name="boardNum">
				<div class="mb-3">
				<table class="table table-striped">
					<thead>
						<tr>
							<th><label for="boardTitle" class="form-label">제목</label> </th>
							<th colspan="2"><input type="text" class="form-control" id="boardTitle" name="boardTitle" value="${detail.boardTitle}"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>작성자</th>
							<td><input type="text" class="form-control" readonly value="${member.id}" id="boardWriter" name="boardWriter"></td>
							<td>등록일: 현재시각</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="2"><textarea class="form-control" id="boardContents" name="boardContents" rows="3">${detail.boardContents}</textarea></td>	
						</tr>
					</tbody>
				</table>
				<button type="submit" class="btn btn-success">등록</button>
			</div>
			</form>
		</div>
	</div>
</div>
				
			
	<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>