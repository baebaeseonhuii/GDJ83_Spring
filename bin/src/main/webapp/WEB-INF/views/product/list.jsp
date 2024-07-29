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
                    <h1 class="mt-4">상품 목록</h1>

                    <table class="table mt-4">
                    <thead>
                      <tr>
                        <th scope="col">상품번호</th>
                        <th scope="col" colspan="2">상품명</th>
                        <th scope="col">이자율</th>
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                      <c:forEach items="${list}" var="dto">
                        <tr>
                          <td>${dto.index_Of_Lists}</td>
                          <th colspan="2"><a href="./detail?p_code=${dto.p_code}" class="list-group-item list-group-item-action list-group-item-light" style="text-decoration: none; color:black;">${dto.p_name} </a></th>
                       
                          <td>${dto.interest}</td>
                        </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                  <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-md-center">
                      <li class="page-item"><a class="page-link ${pager.pre ? '' : 'disabled'}"  href="./list?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
                      <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                        <li class="page-item"><a class="page-link ${pager.page eq i ? 'active' : ''}" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>                      
                      </c:forEach>
                      <li class="page-item"><a class="page-link ${pager.next ? '' : 'disabled'}"  href="./list?page=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
                    </ul>
                    <c:if test="${member.id eq 'seon'}">
                      <div class="d-md-flex justify-content-md-end">
                        <a class="btn btn-secondary" href="./add" role="button">상품추가</a>
                      </div>
                    </c:if>
                    
                  </nav>
                </div>
            </div>
        </div>
      <c:import url="../template/footer.jsp"></c:import>
    </body>
</html>
