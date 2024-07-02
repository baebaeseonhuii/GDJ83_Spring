<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="row">
			<h1>상품 등록</h1>
		</div>

		<div class="row">
			<form action="./add" method="post">
				<div class="mb-3">
					<label for="p_code" class="form-label">상품 코드</label> 
					<input type="text" class="form-control" id="p_code" name="p_code">
				</div>
				
				<div class="mb-3">
					<label for="p_name" class="form-label">상품 이름</label> 
					<input type="text" class="form-control" id="p_name" name="p_name">
				</div>
				
				<div class="mb-3">
					<label for="interest" class="form-label">이자</label> 
					<input type="text" class="form-control" id="interest" name="interest">
				</div>
				<div class="mb-3">
					<label for="script" class="form-label">상품 설명</label> 
					<input type="text" class="form-control" id="script" name="script">
				</div>
				
				
				<button type="submit" class="btn btn-success">등록</button>
			</form>
		</div>
	</div>
</body>
</html>