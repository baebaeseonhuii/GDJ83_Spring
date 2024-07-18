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
            <a class="btn btn-secondary" href="./delete?p_code=${detail.p_code}" role="button">삭제</a>
          </c:if>
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

      </div>
    </div>
  </div>
  <c:import url="../template/footer.jsp"></c:import>
</body>
</html>
