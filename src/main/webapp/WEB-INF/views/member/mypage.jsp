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
			<h1>마이페이지</h1>
		</div>
		

		<div class="row">
			
				<div class="mb-3">
				<div class="col-md-6">
					<label for="id" class="form-label">아이디</label> 
					<input type="text" class="form-control" value="${member.id}" id="id" name="id" readonly>
				</div>
				<div class="col-md-6">
					<label for="phone" class="form-label">전화번호</label> 
					<input type="text" class="form-control" value="${member.phone}" id="phone" name="phone" readonly>
				</div>
				<div class="col-md-6">
					<label for="name" class="form-label">이름</label> 
					<input type="text" class="form-control" value="${member.name}" id="name" name="name" readonly>
				</div>
				<div class="col-md-6">
					<label for="ss_num" class="form-label">주민등록번호</label> 
					<input type="text" class="form-control" value="${member.ss_num}" id="ss_num" name="ss_num" readonly>
				</div>
				<div class="col-md-6">
					<label for="email" class="form-label">이메일</label> 
					<input type="text" class="form-control" value="${member.email}" id="email" name="email" readonly>
				</div>
				</div>
				<div class="mb-3">
					<a href="./update" class="btn btn-success">회원수정</a>
				</div>
				
				<div class="mb-3">
				<form action="./delete" method="post">
					<button type="submit" class="btn btn-success">탈퇴</button>
				</div>
				
				
			
		</div>
	</div>
	
	<div class="container">
		<div class="row mb-5">
			<h1>내가 가입한 상품</h1>
		</div>
		<div class="row">
			<c:forEach items="${member.dtos}" var="ac">
				
				<div class="mb-3">
				<div class="col-md-6">
					<label for="ac_num" class="form-label">계좌번호</label> 
					<input type="text" class="form-control" value="${ac.ac_num}" id="ac_num" name="ac_num" readonly>
				</div>
				<div class="col-md-6">
					<label for="account_balance" class="form-label">잔액</label> 
					<input type="text" class="form-control" value="${ac.account_balance}" id="account_balance" name="account_balance" readonly>
					<hr>
				</div>
				</div>
			</c:forEach>
		<a href="../" class="btn btn-success">돌아가기</a>
		</div>
		</div>
	
	
<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>