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
                <div class="container-fluid col-6 justify-contents-center">
                    <form action="update" method="post">
                    <input type="hidden" name="boardWriter" value="${member.id}">
                    <input type="hidden" name="boardNum" value="${detail.boardNum}">
                    <table class="table mt-4">

                      <tbody class="table-group-divider">
                        <tr>
                          <th scope="col">제목</th>
                          <td scope="col" colspan="3"><input type="text" style="width:100%;" name="boardTitle" value="${detail.boardTitle}"></td>
                        </tr>
                        <tr>
                          <th scope="col">작성자</th>
                          <td scope="col" colspan="3">${member.id}</td>
                        </tr>
                        <tr>
                          <td colspan="4">
                            <p><b>상세 설명</b></p>
                            <textarea name="boardContents" style="width:100%;">${detail.boardContents}</textarea>
                          </td>
                        </tr>
                      </tbody>
                  </table>
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
