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
          <input type="button" class="btn btn-secondary" value="목록" onclick="history.back();" />
          <c:if test="${member.id eq account.id}">
            <a class="btn btn-secondary" href="./list?ac_num=${account.ac_num}" role="button">거래내역조회</a>
            <a class="btn btn-outline-success" href="./transfer?ac_num=${account.ac_num}" role="button">이체</a>
          </c:if>
        </div>
        <table class="table mt-4">
          <tbody class="table-group-divider">
            <tr>
              <th scope="col">회원ID</th>
              <td>${account.id}</td>
              <th scope="col">계좌번호</th>
              <td colspan="3">${account.ac_num}</td>
              <th scope="col">상품코드</th>
              <td>${account.p_code}</td>
            </tr>
            <tr>
              <th scope="col">상품이름</th>
              <td>${account.productDTO.p_name}</td>
              <th scope="col">계좌개설일</th>
              <td>${account.account_date}</td>
              <th scope="col">이자율</th>
              <td>${account.productDTO.interest}</td>
              <th scope="col">잔고</th>
              <td>${account.account_balance}</td>
            </tr>
            <tr>
              <td scope="col" colspan="8">
                <p>
                  <b>상세설명</b>
                </p> ${account.productDTO.script}
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
