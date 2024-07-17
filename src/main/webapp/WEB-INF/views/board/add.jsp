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
                    <form action="add" method="post">
                    <input type="hidden" style="border-width:0;" name="boardWriter" value="${member.id}">
                    <table class="table mt-4">

                      <tbody class="table-group-divider">
                        <tr>
                          <th scope="col">제목</th>
                          <td scope="col" colspan="3"><input type="text" style="width:100%;" name="boardTitle"></td>
                        </tr>
                        <tr>
                          <th scope="col">작성자</th>
                          <td scope="col" colspan="3">${member.id}</td>
                        </tr>
                        <tr>
                          <th colspan="4">
                            게시글 내용
                          </th>
                        </tr>
                        <tr>
                          <td colspan="4">
                            <textarea name="boardContents" style="width:100%;"></textarea>
                          </td>
                        </tr>
                      </tbody>
                  </table>
                  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button class="btn btn-secondary me-md-2" type="submit">등록</button>
                  </div>
                  </form>
                </div>
            </div>
        </div>
      <c:import url="../template/footer.jsp"></c:import>
    </body>
</html>
