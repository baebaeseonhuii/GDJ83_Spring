<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                

                    <table class="table mt-5">
                    
                    <tbody class="table-group-divider">
                      <c:forEach items="${list}" var="comment">
                      <div>
                      	<p style="margin:0; color:grey">${comment.boardWriter}</p>
                      	<p>${comment.boardContents}</p>
                      	<p style="font-size: 11px">${comment.createDate}</p>
                      	<c:if test="${comment.boardWriter eq member.id}">
                      	<button class="btn btn-danger delBtn" data-del-btn="${comment.boardNum}">댓글 삭제</button>
                      	</c:if>
                      </div>
                      <hr>
                      </c:forEach>
                    </tbody>
                  </table>
                  
                  <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-md-center">
                      <li class="page-item"><a class="pn page-link ${pager.pre ? '' : 'disabled'}" data-page-num="${pager.startNum - 1}" href="#">Previous</a></li>
                      <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                        <li class="page-item"><a class="pn page-link ${pager.page eq i ? 'active' : ''}" data-page-num="${i}" href="#">${i}</a></li>                      
                      </c:forEach>
                      <li class="page-item"><a class="pn page-link ${pager.next ? '' : 'disabled'}" data-page-num="${pager.lastNum + 1}" href="#">Next</a></li>
                    </ul>
                  </nav>
               <button class="list">Test</button>
            
      <c:import url="../template/footer.jsp"></c:import>
    