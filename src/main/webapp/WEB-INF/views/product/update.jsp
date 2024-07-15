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
			<h1>상품 수정</h1>
		</div>

		<div class="row">
			<form action="./update" method="post">
				<input type="hidden" name="index_Of_Lists"
					value="${detail.index_Of_Lists}">

				<div class="mb-3">
					<label for="p_code" class="form-label">상품 코드</label> <input
						type="text" class="form-control" id="p_code" name="p_code"
						value="${detail.p_code}">
				</div>

				<div class="mb-3">
					<label for="p_name" class="form-label">상품 이름</label> <input
						type="text" class="form-control" id="p_name" name="p_name"
						value="${detail.p_name}">
				</div>

				<div class="mb-3">
					<label for="interest" class="form-label">이자</label> <input
						type="text" class="form-control" id="interest" name="interest"
						value="${detail.interest}">
				</div>
				<div class="mb-3">
					<label for="script" class="form-label">상품 설명</label> <input
						type="text" class="form-control" id="script" name="script"
						value="${detail.script}">
				</div>


				<button type="submit" class="btn btn-success">확인</button>
				
			</form>
			
			<form action="./delete" method="post">
			<input type="hidden" name="index_Of_Lists" value="${detail.index_Of_Lists}">
			<button type="submit" class="btn btn-success mt-3">삭제</button>
			</form>
		</div>
	</div>
	<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>