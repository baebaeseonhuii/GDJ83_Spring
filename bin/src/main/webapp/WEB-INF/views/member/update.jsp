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
        <form method="post" action="update">
          <table class="table mt-4">
            <tbody class="table-group-divider">
              <tr>
                <td>ID(수정불가)</td>
                <th><input type="text" value="${member.id}" readonly name="id"></th>
                <td>이름</td>
                <td><input type="text" value="${member.name}" name="name"></td>
              </tr>
              <tr>
                <td>email</td>
                <td><input type="text" value="${member.email}" name="email"></td>
                <td>전화번호</td>
                <td><input type="text" value="${member.phone}" name="phone"></td>
              </tr>
            </tbody>
          </table>
          <input type="hidden" value="${member.ss_num}" name="ss_num">
          <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-secondary me-md-2" type="submit">수정</button>
          </div>
        </form>
      </div>
    </div>
  </div>
  <c:import url="../template/footer.jsp"></c:import>
</body>
</html>
