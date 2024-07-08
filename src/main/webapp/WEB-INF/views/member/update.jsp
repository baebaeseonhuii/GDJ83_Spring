<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootheader.jsp"></c:import>
</head>
<body>
	<div class="container">
		<div class="row mb-5">
			<h1>회원수정</h1>
		</div>
		<form action="./update" method="post">
			<div class="row">

				<div class="mb-3">
					<div class="col-md-6">
						<label for="id" class="form-label">아이디</label> <input type="text"
							class="form-control" value="${member.id}" id="id"
							name="id">
					</div>
					<div class="col-md-6">
						<label for="phone" class="form-label">전화번호</label> <input
							type="text" class="form-control"
							value="${member.phone}" id="phone" name="phone">
					</div>
					<div class="col-md-6">
						<label for="name" class="form-label">이름</label> <input type="text"
							class="form-control" value="${member.name}"
							id="name" name="name">
					</div>
					<div class="col-md-6">
						<label for="ss_num" class="form-label">주민등록번호</label> <input
							type="text" class="form-control"
							value="${member.ss_num}" id="ss_num" name="ss_num">
					</div>
					<div class="col-md-6">
						<label for="email" class="form-label">이메일</label> <input
							type="text" class="form-control"
							value="${member.email}" id="email" name="email">
					</div>
				</div>
				<div class="mb-3">
					<button type="submit" class="btn btn-success">완료</button>
				</div>
		</form>


		<a href="../" class="btn btn-success">돌아가기</a>

	</div>
	</div>
	<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>