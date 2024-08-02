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
  <div class="d-flex background" id="wrapper" >
    <!-- Sidebar-->
    <c:import url="./template/sidebar.jsp"></c:import>

    <!-- Page content wrapper-->
    <div id="page-content-wrapper" class="back">

      <!-- Top navigation-->
      <c:import url="./template/topbar.jsp"></c:import>

      <!-- Page content-->
    
    	<img id="tama" alt="jumping tamagochi" src="/resources/images/index/tama.gif">
    
      
    </div>
  </div>
  <c:import url="./template/footer.jsp"></c:import>
</body>
</html>
