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
	<h1>금융 상품 목록</h1>
	<div class="container-fluid mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>상품 코드</th>
							<th>상품 이름</th>
							<th>이자</th>

						</tr>
					</thead>

					<c:forEach items="${list}" var="dto">
						<tbody>
							<tr>
								<td>${dto.index_Of_Lists}</td>
								<td>${dto.p_code}</td>
								<td><a href="./detail?p_code=${dto.p_code}">${dto.p_name}</a></td>
								<td>${dto.interest}</td>

							</tr>
						</tbody>
					</c:forEach>


				</table>
				<nav aria-label="Page navigation example">
  					<ul class="pagination justify-content-center">
    					<li class="page-item">
      						<a class="page-link" href="#" aria-label="Previous">
        						<span aria-hidden="true">&laquo;</span>
      						</a>
    					</li>
    						<li class="page-item"><a class="page-link" href="./list?page=1">1</a></li>
    						<li class="page-item"><a class="page-link" href="./list?page=2">2</a></li>
    						<li class="page-item"><a class="page-link" href="./list?page=3">3</a></li>
    						<li class="page-item"><a class="page-link" href="./list?page=4">4</a></li>
    						<li class="page-item"><a class="page-link" href="./list?page=5">5</a></li>
    						<li class="page-item"><a class="page-link" href="./list?page=6">6</a></li>
    						<li class="page-item"><a class="page-link" href="./list?page=7">7</a></li>
    						<li class="page-item"><a class="page-link" href="./list?page=8">8</a></li>
    						<li class="page-item"><a class="page-link" href="./list?page=9">9</a></li>
    						<li class="page-item"><a class="page-link" href="./list?page=${totalPage}">${totalPage}</a></li>
    						<li class="page-item">
      						<a class="page-link" href="#" aria-label="Next">
        						<span aria-hidden="true">&raquo;</span>
      						</a>
    					</li>
 					 </ul>
				</nav>
				<div>
					<a href="add" class="btn btn-outline-success">상품 등록</a>
				</div>
				<a href="/" class="btn btn-success">돌아가기</a>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/sample/bootfooter.jsp"></c:import>
</body>
</html>