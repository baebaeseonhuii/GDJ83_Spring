<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="border-end bg-white" id="sidebar-wrapper">
    <div class="sidebar-heading border-bottom bg-light" id="pineappleHome">Pineapple🍍</div> 
    <div class="list-group list-group-flush">
       <c:if test="${member eq null}">
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/member/join">회원가입</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/member/login">로그인</a>
       </c:if>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/notice/list">공지사항</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/qna/list">QnA</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/product/list">상품목록</a>
      <c:if test="${member ne null}">
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/member/mypage">마이페이지</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/member/logout">로그아웃</a>
      </c:if>
    </div>
</div>