<%-- 
    Document   : login
    Created on : Sep 6, 2022, 9:55:38 PM
    Author     : ACER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-secondary">ĐĂNG NHẬP</h1>

<c:if test="${param.error !=null}">
    <div class="alert alert-danger">
        Đã có lỗi xảy ra! Vui lòng quay lại sau!
    </div>
</c:if>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Bạn không có quyền truy cập!
    </div>
</c:if>

<c:url value="/login" var="action"/>

<form method="post" action="${action}">
    <div class="form-group">
        <label for="userName">Username</label>
        <input type="text" id="userName" name="userName" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="userPassword">Password</label>
        <input type="password" id="userPassword" name="userPassword" class="form-control"/>
    </div>
    <br>
    <div class="form-group text-center">
        <input type="submit" value="ĐĂNG NHẬP" class="btn btn-outline-secondary btn-lg" data-mdb-ripple-color="dark"/>
    </div>
    <br>
</form>