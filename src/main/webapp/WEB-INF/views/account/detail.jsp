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
			<h1>내가 가입한 상품의 정보</h1>
		</div>
		<div class="row">
				<div class="mb-3">
				<div class="col-md-6">
					<label for="account_balance" class="form-label">회원아이디</label> 
					<input type="text" class="form-control" value="${account.id}" id="id" name="id" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="ac_num" class="form-label">계좌번호</label> 
					<input type="text" class="form-control" value="${account.ac_num}" id="ac_num" name="ac_num" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="account_balance" class="form-label">상품코드</label> 
					<input type="text" class="form-control" value="${account.p_code}" id="p_code" name="p_code" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="account_balance" class="form-label">상품이름</label> 
					<input type="text" class="form-control" value="${account.productDTO.p_name}" id="p_name" name="p_name" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="account_balance" class="form-label">계좌 개설일</label> 
					<input type="text" class="form-control" value="${account.account_date}" id="account_date" name="account_date" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="account_balance" class="form-label">이자율</label> 
					<input type="text" class="form-control" value="${account.productDTO.interest}" id="interest" name="interest" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="account_balance" class="form-label">상품설명</label> 
					<input type="text" class="form-control" value="${account.productDTO.script}" id="script" name="script" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="account_balance" class="form-label">잔액</label> 
					<input type="text" class="form-control" value="${account.account_balance}" id="account_balance" name="account_balance" readonly>
					<hr>
				</div>
				
		<a href="./transfer?ac_num=${account.ac_num}" class="btn btn-success">이체</a>
		<a href="./history?ac_num=${account.ac_num}" class="btn btn-success">거래내역</a>
		<a href="../member/mypage" class="btn btn-success">돌아가기</a>
		</div>
		</div>
		</div>
	
	
<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>