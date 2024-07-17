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
                <form action="add" method="post">
                <div class="container-fluid col-6 justify-contents-center">
                  <table class="table mt-4">
                    <thead>
                      <tr>
                        <th scope="col">상품코드(SN)</th>
                        <th scope="col">상품명</th>
                        <th scope="col">이자율</th>
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <tr>
                          <td ><input type="text" name="p_code" value=""></td>
                          <th scope="row"><input type="text" name="p_name" value=""></th>
                          <td><input type="text" name="interest" value=""></td>
                        </tr>
                        <tr>
                          <td colspan="3">
                            <p>세부정보</p>
                            <textarea name="script" style="width:100%;"></textarea>
                          </td>
                        </tr>
                    </tbody>
                  </table>
                  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button class="btn btn-secondary me-md-2" type="submit">등록</button>
                  </div>
                </div>
              </form>
            </div>
        </div>
      <c:import url="../template/footer.jsp"></c:import>
    </body>
</html>
