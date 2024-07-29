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
        <div class="row mt-5">
      <h3>이체</h3>
      <h3>예시 계좌번호: 1720419680702</h3>
    </div>  
        <form method="post" action="transfer">
          <input type="hidden" value="${param.ac_num}" name="ac_num">
          <table class="table mt-4">
            <tbody class="table-group-divider">
              <tr>
                <th scope="col">이체할계좌번호</th>
                <td colspan="2"><input type="text" style="width:100%;" name="account_u"></td>
              </tr>
              <tr>
                <th scope="col">이체할금액</th>
                <td><input type="number" style="width:100%;" name="money"></td>
              </tr>
            </tbody>
          </table>
          <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-secondary me-md-2" type="submit">이체</button>
          </div>
        </form>

      </div>
    </div>
  </div>
  <c:import url="../template/footer.jsp"></c:import>
</body>
</html>
