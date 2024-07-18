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
                    <h1 class="mt-4">공지사항</h1>

                    <table class="table mt-4">
                    <thead>
                      <tr>
                        <th scope="col">글번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">작성일</th>
                        <th scope="col">조회수</th>
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <tr>
                          <td>${detail.boardNum}</td>
                          <th scope="row">${detail.boardTitle}</th>
                          <td>${detail.boardWriter}</td>
                          <td>${detail.createDate}</td>
                          <td>${detail.boardHit}</td>
                        </tr>
                        <tr>
                          <td colspan="5">
                            ${detail.boardContents}
                          </td>
                        </tr>
                    </tbody>
                  </table>
                  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <input type="button" class="btn btn-secondary" value="목록" onclick="history.back();" />
                    <c:if test="${member.id eq detail.boardWriter}">
                      <a class="btn btn-secondary" href="./update?boardNum=${detail.boardNum}" role="button">수정</a>
                      <a class="btn btn-secondary" href="./delete?boardNum=${detail.boardNum}" role="button">삭제</a>
                    </c:if>
                    <c:if test="${board eq 'QnA' and member ne null}">
                      <a class="btn btn-secondary" href="./add?boardNum=${detail.boardNum}" role="button">답글</a>
                    </c:if>
                  </div>
                </div>
            </div>
        </div>
      <c:import url="../template/footer.jsp"></c:import>
    </body>
</html>
