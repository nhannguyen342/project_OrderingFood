<%-- 
    Document   : admin-left
    Created on : Oct 19, 2022, 3:32:13 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar bg-light">
    <ul class="navbar-nav">
        <li class="navbar-nav">
            <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
        </li>
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/admin/restaurant-stats"/>">Thống kê món ăn theo danh mục</a>
      </li>
    </ul>
</nav>
