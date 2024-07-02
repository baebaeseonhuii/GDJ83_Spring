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
	<h1>상품 상세 페이지</h1>
	<div class="container-fluid mt-5">
		<div class="row justify-content-center">
			<div class="col-md-9">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>상품 코드</th>
							<th>상품 이름</th>
							<th>이자</th>
							<th>상품 설명</th>

						</tr>
					</thead>

					<tbody>
						<tr>
							<td>${detail.p_code}</td>
							<td>${detail.p_name}</td>
							<td>${detail.interest}</td>
							<td>${detail.script}</td>

						</tr>
					</tbody>



				</table>

				<div>
					<a href="delete?p_code=${detail.p_code}"
						class="btn btn-outline-success">부서 삭제</a> <a
						href="update?p_code=${detail.p_code}"
						class="btn btn-outline-success">부서 수정</a>
				</div>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>