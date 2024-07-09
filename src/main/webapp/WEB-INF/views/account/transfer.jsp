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
			<h1>이체</h1>
		</div>

		<div class="row">
			<form action="./transfer" method="post">
				<input type="hidden" id = "ac_num" name = "ac_num" value = "${account.ac_num}">
				<input type="hidden" id = "account_balance" name = "account_balance" value = "${account.account_balance}">
				<div class="mb-3">
				<div class="col-md-6">
					<label for="recipient_account" class="form-label">입금할 계좌번호</label> 
					<input type="text" class="form-control" id="recipient_account" name="recipient_account">
				</div>
				<div class="col-md-6">
					<label for="money" class="form-label">보낼 금액</label> 
					<input type="text" class="form-control" id="money" name="money">
				</div>
				</div>
				<button type="submit" class="btn btn-success">이체하기</button>
			</form>
		</div>
	</div>
	
	<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>