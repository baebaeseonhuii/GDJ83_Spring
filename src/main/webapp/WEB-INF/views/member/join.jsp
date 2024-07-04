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
			<h1>회원가입</h1>
		</div>

		<div class="row">
			<form action="./join" method="post">
				<div class="mb-3">
				<div class="col-md-6">
					<label for="id" class="form-label">아이디</label> 
					<input type="text" class="form-control" id="id" name="id">
				</div>
				<div class="col-md-6">
					<label for="pw" class="form-label">비밀번호</label> 
					<input type="password" class="form-control" id="pw" name="pw">
				</div>
				<div class="col-md-6">
					<label for="phone" class="form-label">전화번호</label> 
					<input type="text" class="form-control" id="phone" name="phone">
				</div>
				<div class="col-md-6">
					<label for="name" class="form-label">이름</label> 
					<input type="text" class="form-control" id="name" name="name">
				</div>
				<div class="col-md-6">
					<label for="ss_num" class="form-label">주민등록번호</label> 
					<input type="text" class="form-control" id="ss_num" name="ss_num">
				</div>
				<div class="col-md-6">
					<label for="email" class="form-label">이메일</label> 
					<input type="text" class="form-control" id="email" name="email">
				</div>
				</div>
				<button type="submit" class="btn btn-success">가입하기</button>
			</form>
		</div>
	</div>
<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
<script type="text/javascript">

</script>
</body>
</html>