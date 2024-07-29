<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="../template/header.jsp"></c:import>
        <title>Pineapple</title>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <c:import url="../template/sidebar.jsp"></c:import>
            
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
            
                <!-- Top navigation-->
                <c:import url="../template/topbar.jsp"></c:import>
                
                <!-- Page content-->
                <div class="container-fluid col-6 justify-contents-center">
                    <h1 class="mt-4 mb-4">관심목록</h1>
					<div>
						<button type="button" class="btn btn-outline-danger" id="delAll">선택 삭제</button>
					</div>
                    <table class="table mt-4">
                    <thead>
                      <tr>
                      	<th>
                      	<label>전체 선택</label>
                      		<input type="checkbox" name="check" id="allCheck">
                      	</th>
                        <th scope="col" colspan="2">상품명</th>
                        <th scope="col">이자율</th>
                        <th>삭제</th>
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                      <c:forEach items="${list}" var="dto" varStatus="i">
                        <tr id="w${i.index}">
                          <td><input type="checkbox" class="check" data-del-id="w${i.index}" name="check" data-wish-id="${dto.p_code}"></td>
                          <th colspan="2">${dto.p_name}</th>
                       	  <td>${dto.interest}</td>
                       	  <td><button type="button" class="btn btn-secondary wishDelete" data-del-id="w${i.index}" data-wish-id="${dto.p_code}">X</button></td>
                        </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                  <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-md-center">
                      <li class="page-item"><a class="page-link ${pager.pre ? '' : 'disabled'}"  href="./wishList?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
                      <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                        <li class="page-item"><a class="page-link ${pager.page eq i ? 'active' : ''}" href="./wishList?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>                      
                      </c:forEach>
                      <li class="page-item"><a class="page-link ${pager.next ? '' : 'disabled'}"  href="./wishList?page=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
                    </ul>
                    
                    
                  </nav>
                </div>
            </div>
        </div>
      <c:import url="../template/footer.jsp"></c:import>
      <script type="text/javascript" src="/resources/js/product/wishDelete.js"></script>
    </body>
</html>
