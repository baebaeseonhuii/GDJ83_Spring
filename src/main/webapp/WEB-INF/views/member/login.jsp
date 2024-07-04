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
			<h1>로그인</h1>
		</div>

		<div class="row">
			<form action="./login" method="post">
				<div class="mb-3">
				<div class="col-md-6">
					<label for="id" class="form-label">아이디</label> 
					<input type="text" class="form-control" value="${id}" id="id" name="id">
				</div>
				<div class="col-md-6">
					<label for="pw" class="form-label">비밀번호</label> 
					<input type="password" class="form-control" id="pw" name="pw">
				</div>
				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
					<label class="form-check-label" for="exampleCheck1">ID 기억하기</label>
				</div>
				</div>
				<button type="submit" class="btn btn-success">로그인</button>
			</form>
		</div>
	</div>
	
	<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>