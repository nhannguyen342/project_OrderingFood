<%-- 
    Document   : header
    Created on : Sep 5, 2022, 1:41:29 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm navbar-dark  " style="background-color: #EAD2AC;">
  <div class="container-fluid ">
      <a class="navbar-brand text-dark" href="<c:url value="/"/>">NTN-Restaurant</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse " id="mynavbar">
       
        <ul class="navbar-nav me-auto "> 
            <c:forEach var="r" items="${restaurants}" >
                <li class="nav-item active ">
                    <c:url value="/" var="resPath">
                        <c:param name="RestId" value="${r.id}"></c:param>
                    </c:url>
                    <a class="nav-link text-dark" href="${resPath}" />${r.name}</a>
                </li>
            </c:forEach>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                  <li class="nav-item active border border-secondary rounded spacing">
                      <a class="nav-link text-dark " href="<c:url value="/login" />" >Đăng nhập</a>
                  </li>
                   <li class="nav-item active border border-secondary rounded spacing-1">
                      <a class="nav-link text-dark " href="<c:url value="/register" />" >Đăng ký</a>
                  </li>
            </c:if>
          
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item active spacing">
                    <a class="nav-link text-dark" href="<c:url value="/" />" >${pageContext.request.userPrincipal.name}</a>
                </li>
                <li class="nav-item active border border-secondary rounded spacing-1">
                    <a class="nav-link text-dark" href="<c:url value="/logout" />" >Đăng xuất</a>
                </li>
            </c:if>
                <li class="nav-item active ">
                    <a href="<c:url value="/cart"/>" class="nav-link text-dark">
                        <i class="fas fa-cart-plus" style="font-size: 21px"></i>
                        <div class="badge badge-danger text-dark" id="cartCounter">${cartCounter}</div>
                    </a>
                </li>
      </ul>
    </div>
  </div>
</nav>
<style>
    .spacing {
        margin-left:840px;
    }
    
    .spacing-1 {
        margin-left: 10px
    }
</style>
    

