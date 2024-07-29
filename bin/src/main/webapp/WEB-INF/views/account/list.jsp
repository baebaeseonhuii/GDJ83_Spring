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
        <h1 class="mt-4">상품 목록</h1>
        <div class="d-md-flex justify-content-md-end">
          <div class="dropdown d-inline me-2">
            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">시간순</button>
            <ul class="dropdown-menu">
              <li><a class="btn btn-success dropdown-item" href="list?ac_num=${param.ac_num}">과거 거래순으로</a></li>
              <li><a class="btn btn-success dropdown-item" href="list?ac_num=${param.ac_num}&order=1">최근 거래순으로</a></li>
            </ul>
          </div>
          <div class="dropdown d-inline me-2">
            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">입출금순</button>
            <ul class="dropdown-menu">
              <li><a class="btn btn-success dropdown-item" href="list?ac_num=${param.ac_num}&depositOrWithdraw=1">입금</a></li>
              <li><a class="btn btn-success dropdown-item" href="list?ac_num=${param.ac_num}&depositOrWithdraw=0">출금</a></li>
              <li><a class="btn btn-success dropdown-item" href="list?ac_num=${param.ac_num}">입출금</a></li>
            </ul>
          </div>
          <a href="../member/mypage" class="btn btn-secondary">돌아가기</a>
        </div>
        <table class="table mt-4">
          <thead>
            <tr>
              <th scope="col">거래일</th>
              <th scope="col">거래한 계좌번호</th>
              <th scope="col">거래금액</th>
              <th scope="col">거래 종류</th>
              <th scope="col">잔액</th>
            </tr>
          </thead>
          <tbody class="table-group-divider">
            <c:forEach items="${list}" var="dto">
              <tr>
                <td>${dto.timestamp}</td>
                <td>${dto.account_u}</td>
                <td class="${dto.type_of_transaction == '입금'?'text-primary':'text-danger'}">${dto.money}</td>
                <td class="${dto.type_of_transaction == '입금'?'text-primary':'text-danger'}">${dto.type_of_transaction}</td>
                <td>${dto.balance}</td>
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
