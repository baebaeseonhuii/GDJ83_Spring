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
			<h1>거래 내역 조회</h1>
		</div>
		
	<div class="container-fluid mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div>
					<a href="list?ac_num=${param.ac_num}}&order=DESC">과거순으로</a>
				</div>
			
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>거래일</th>
							<th>거래한 계좌번호</th>
							<th>거래액</th>
							<th>거래 종류</th>
							<th>잔액</th>
						</tr>
					</thead>

					<c:forEach items="${list}" var="dto">
						<tbody>
							<tr>
								<td>${dto.timestamp}</td>
								<td>${dto.account_u}</td>
								<td class="${dto.type_of_transaction == '입금'?'text-primary':'text-danger'}">
									${dto.money}
								</td>
								<td class="${dto.type_of_transaction == '입금'?'text-primary':'text-danger'}">
									${dto.type_of_transaction}
								</td>
								<td>${dto.balance}</td>

							</tr>
						</tbody>
					</c:forEach>


				</table>
					<a href="../member/mypage" class="btn btn-success">돌아가기</a>
				</div>
		</div>
	</div>

				
				
		
		</div>
		
	
	
<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>