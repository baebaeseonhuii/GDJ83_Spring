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
                    <h1 class="mt-4">Simple Sidebar</h1>
                    <p>The starting state of the menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will change.</p>
                    <p>
                        Make sure to keep all page content within the
                        <code>#page-content-wrapper</code>
                        . The top navbar is optional, and just for demonstration. Just create an element with the
                        <code>#sidebarToggle</code>
                        ID which will toggle the menu when clicked.
                    </p>
                </div>
            </div>
        </div>
      <c:import url="../template/footer.jsp"></c:import>
    </body>
</html>
