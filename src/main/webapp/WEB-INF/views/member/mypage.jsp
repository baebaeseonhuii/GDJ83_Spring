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
        <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-5">
          <a class="btn btn-secondary" href="./update?id=${member.id}" role="button">수정</a>
          <a class="btn btn-danger" href="./delete?id=${member.id}" role="button">탈퇴</a>
        </div>
        <table class="table mt-4">
          <tbody class="table-group-divider">
            <tr>
              <td>ID</td>
              <th>${member.id}</th>
              <td>이름</td>
              <td>${member.name}</td>
            </tr>
            <tr>
              <td>email</td>
              <td>${member.email}</td>
              <td>전화번호</td>
              <td>${member.phone}</td>
            </tr>
            <tr><td colspan="4"></td></tr>
            <tr>
              <td colspan="4">보유 계좌</td>
            </tr>
            <tr>
              <th colspan="2">계좌번호</th>
              <th colspan="2">잔고</th>
            </tr>
            <c:forEach items="${member.dtos}" var="dto">
              <tr>
                <td colspan="2"><a href="/account/detail?ac_num=${dto.ac_num}" class="list-group-item list-group-item-action list-group-item-light" style="color:black;">${dto.ac_num}</a></td>
                <td colspan="2">${dto.account_balance}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>

      </div>
    </div>
  </div>
  <c:import url="../template/footer.jsp"></c:import>
</body>
</html>
