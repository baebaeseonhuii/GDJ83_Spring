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
        <form method="post" action="join">
          <table class="table mt-5">
            <tbody class="table-group-divider">
              <tr>
                <td>ID</td>
                <th><input type="text" name="id"></th>
                <td>PW</td>
                <th><input type="password" name="pw"></th>
              </tr>
              <tr>
                <td>이름</td>
                <td><input type="text" name="name"></td>
                <td>전화번호</td>
                <td><input type="text" name="phone"></td>
              </tr>
              <tr>
                <td>email</td>
                <td><input type="email" name="email"></td>
                <td>주민번호</td>
                <td><input type="text" name="ss_num"></td>
              </tr>
              
            </tbody>
          </table>
          <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-secondary me-md-2" type="submit">가입</button>
          </div>
        </form>
      </div>
    </div>
  </div>
  <c:import url="../template/footer.jsp"></c:import>
</body>
</html>
