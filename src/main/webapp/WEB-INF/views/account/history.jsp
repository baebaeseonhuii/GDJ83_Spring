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
					<label for="timestamp" class="form-label">거래일</label> 
					<input type="text" class="form-control" value="${timestamp}" id="timestamp" name="timestamp" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="recipient_account" class="form-label">입금한 계좌번호</label> 
					<input type="text" class="form-control" value="${recipient_account}" id="recipient_account" name="recipient_account" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="money" class="form-label">거래액</label> 
					<input type="text" class="form-control" value="${money}" id="money" name="money" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="type_of_transaction" class="form-label">거래 종류</label> 
					<input type="text" class="form-control" value="${type_of_transaction}" id="type_of_transaction" name="type_of_transaction" readonly>
					<hr>
				</div>
				<div class="col-md-6">
					<label for="balance" class="form-label">잔액</label> 
					<input type="text" class="form-control" value="${balance}" id="balance" name="balance" readonly>
					<hr>
				</div>
				
				
		
		<a href="../member/mypage" class="btn btn-success">돌아가기</a>
		</div>
		</div>
		</div>
	
	
<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>