<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<nav class="navbar bg-dark border-bottom border-body"
	data-bs-theme="dark">
	<ul class="nav justify-content-center">
		<li class="nav-item btn btn-outline-secondary me-5"><a class="nav-link text-white" href="/product/list">금융 상품 목록</a></li>
		<li class="nav-item btn btn-outline-secondary me-5"><a class="nav-link text-white" href="/notice/list">공지사항</a></li>
		
		<c:choose>
			<c:when test="${not empty member }">
				<li class="nav-item btn btn-outline-secondary"><a class="nav-link text-white" href="/member/logout">로그아웃</a></li>
				<li class="nav-item btn btn-outline-secondary"><a class="nav-link text-white" href="/member/mypage">마이페이지</a></li>
			</c:when>
			<c:otherwise>
				<li class="nav-item btn btn-outline-secondary"><a class="nav-link text-white" href="/member/login">로그인</a></li>
				<li class="nav-item btn btn-outline-secondary"><a class="nav-link text-white" href="/member/join">회원가입</a></li>
			</c:otherwise>
		</c:choose>
		
		<!-- 
		<c:if test="${empty member }">
		<li class="nav-item btn btn-outline-secondary"><a class="nav-link text-white" href="/member/login">로그인</a></li>
		<li class="nav-item btn btn-outline-secondary"><a class="nav-link text-white" href="/member/join">회원가입</a></li>
		</c:if>	
		
		<c:if test="${not empty member }">
		<li class="nav-item btn btn-outline-secondary"><a class="nav-link text-white" href="/member/logout">로그아웃</a></li>
		<li class="nav-item btn btn-outline-secondary"><a class="nav-link text-white" href="/member/mypage">마이페이지</a></li>
		</c:if>	
		 -->
		
	</ul>
</nav>
