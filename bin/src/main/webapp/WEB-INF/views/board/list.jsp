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
        <h1 class="mt-4">${board }</h1>



        <form action="./list" method="get" class="row row-cols-lg-auto g-3 d-md-flex justify-content-md-end mt-3">
          <div class="col-12">
            <label class="visually-hidden" for="kind">Preference</label> <select name="kind" class="form-select" id="kind">
              <option value="writer" ${pager.kind eq 'writer' ? 'selected' : ''}>작성자</option>
              <option value="title" ${pager.kind eq 'title' ? 'selected' : ''}>제목</option>
              <option value="contents" ${pager.kind eq 'contents' ? 'selected' : ''}>내용</option>
            </select>
          </div>

          <div class="col-12">
            <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
            <div class="input-group">

              <input type="text" name="search" class="form-control" id="search" placeholder="검색어를 입력하세요">
            </div>
          </div>
          <div class="col-12">
            <button type="submit" class="btn btn-secondary">Submit</button>
          </div>
          <c:if test="${board eq 'Notice'}">
            <div class="dropdown d-md-flex justify-content-md-end">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">정렬</button>
              <ul class="dropdown-menu">
                <li><a class="btn btn-success dropdown-item" href="list?order=1">최신순으로</a></li>
                <li><a class="btn btn-success dropdown-item" href="list?order=2">조회수순으로</a></li>
              </ul>
            </div>
          </c:if>
        </form>

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
            <c:forEach items="${list}" var="dto">
              <tr>
                <td>${dto.boardNum}</td>
                <th scope="row">
                  <c:choose>
                    <c:when test="${dto.del ne 1}">
                     <a href="./detail?boardNum=${dto.boardNum}"
                     class="list-group-item list-group-item-action list-group-item-light" 
                     style="text-decoration: none; color:black;">
                       <c:if test="${board == 'QnA'}">
                        <c:forEach begin="1" end="${dto.depth}">--</c:forEach>
                       </c:if>
                       ${dto.boardTitle}
                     </a>
                   </c:when>
                   <c:otherwise>
                    삭제된 게시글입니다
                   </c:otherwise>
                  </c:choose>               
                </th>
                <td>${dto.boardWriter}</td>
                <td>${dto.createDate}</td>
                <td>${dto.boardHit}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <nav aria-label="Page navigation example">
          <ul class="pagination justify-content-md-center">
            <li class="page-item"><a class="page-link ${pager.pre ? '' : 'disabled'}" href="./list?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
              <li class="page-item"><a class="page-link ${pager.page eq i ? 'active' : ''}" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
            </c:forEach>
            <li class="page-item"><a class="page-link ${pager.next ? '' : 'disabled'}" href="./list?page=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
          </ul>
          <c:if test="${member ne null}">
            <div class="d-md-flex justify-content-md-end">
              <a class="btn btn-secondary" href="./add" role="button">게시글추가</a>
            </div>
          </c:if>

        </nav>
      </div>
    </div>
  </div>
  <c:import url="../template/footer.jsp"></c:import>
</body>
</html>
