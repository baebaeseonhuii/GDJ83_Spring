<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="./template/header.jsp"></c:import>
<title>Pineapple</title>
<link rel="stylesheet" href="/resources/css/snake.css">
</head>
<body>
  <div class="d-flex" id="wrapper">
    <!-- Sidebar-->
    <c:import url="./template/sidebar.jsp"></c:import>

    <!-- Page content wrapper-->
    <div id="page-content-wrapper">

      <!-- Top navigation-->
      <c:import url="./template/topbar.jsp"></c:import>

      <!-- Page content-->
      <div class="container-fluid col-6 justify-contents-center">        
      <div class="game-container mt-5">
          <h3>스네이크 게임</h3>
          <canvas id="game-board" width="100%" height="100%"></canvas>
          <div class="buttons">
            <button id="start-btn">시작</button>
            <button id="stop-btn">정지</button>
          </div>
          <p class="score">
            점수: <span id="score">0</span>
          </p>
        </div>
        <script src="/resources/js/snake.js"></script>
      </div>
    </div>
  </div>
  <c:import url="./template/footer.jsp"></c:import>
</body>
</html>
