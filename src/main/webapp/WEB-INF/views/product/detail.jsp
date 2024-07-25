<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
          <input type="button" class="btn btn-secondary" value="목록" onclick="history.back();" />
          <c:if test="${member ne null}">
            <a href="../account/add?p_code=${detail.p_code}" class="btn btn-outline-success">상품 가입</a>
          </c:if>
          <c:if test="${member.id eq 'seon'}">
            <a class="btn btn-secondary" href="./update?p_code=${detail.p_code}" role="button">수정</a>
            <a class="btn btn-secondary" href="./delete?index_Of_Lists=${detail.index_Of_Lists}" role="button">삭제</a>
          </c:if>
          	<button class="btn btn-secondary" type="button" data-product-id="${detail.p_code}" data-user-id="${member.id}" id="addWish">관심목록추가</button>
        </div>
        <table class="table mt-4">
          <thead>
            <tr>
              <th scope="col">상품번호</th>
              <th scope="col">상품명</th>
              <th scope="col">이자율</th>
            </tr>
          </thead>
          <tbody class="table-group-divider">
            <tr>
              <td>${detail.index_Of_Lists}</td>
              <th scope="row">${detail.p_name}</th>
              <td>${detail.interest}</td>
            </tr>
            <tr>
              <td colspan="3">
                <p>
                  <b>상세 설명</b>
                </p>
                <p>${detail.script}</p>
              </td>
            </tr>
          </tbody>
        </table>
        <div id="wishResult">

        </div>
	<div>
		<c:forEach items="${detail.productFileDTO}" var="f">
			<a href="/resources/upload/products/${f.fileName}">${f.oriName}</a>
		</c:forEach>
	</div>
	
	<!-- 댓글 -->
	<div>
		<button type="button" class="btn btn-outline-warning mt-3 mb-5" data-bs-toggle="modal" data-bs-target="#commentModal">
		  댓글 입력
		</button>
		<!-- 댓글 모달 창 -->
			<div class="modal fade" id="commentModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="exampleModalLabel">댓글</h1>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			       <div class="form-floating">
					  <textarea class="form-control" placeholder="Leave a comment here" id="commentContents" style="height: 100px"></textarea>
					  
					</div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" id="commentClose" data-bs-dismiss="modal">닫기</button>
			        <button type="button" class="btn btn-warning" id="commentButton" data-product-id="${detail.p_code}" data-user-id="${member.id}">댓글 등록</button>
			      </div>
			    </div>
			  </div>
			</div>
		<!-- 댓글 목록 -->
		<div id="commentList" class="pn">
		
		</div>
	</div>	
	</div>
	
      </div>
    </div>
  </div>
  <c:import url="../template/footer.jsp"></c:import>
  <script type="text/javascript" src="/resources/js/product/wish.js"></script>
  <script type="text/javascript" src="/resources/js/commons/comment.js"></script>
</body>
</html>
