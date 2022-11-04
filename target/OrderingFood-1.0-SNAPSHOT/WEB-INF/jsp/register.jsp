<%-- 
    Document   : register
    Created on : Sep 6, 2022, 11:13:25 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-secondary">ĐĂNG KÝ</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action"/>

<form:form method="post" action="${action}" modelAttribute="user">
    <div class="form-group">
        <label for="fullName">Full name</label>
        <form:input type="text" id="fullName" path="fullName" class="form-control"/>  
    </div>
    
    <div class="form-group">
        <label for="phone">Phone</label>
        <form:input type="text" id="phone" path="phone" class="form-control"/>  
    </div>
    
    <div class="form-group">
        <label for="userName">User name</label>
        <form:input type="text" id="userName" path="userName" class="form-control"/>  
    </div>
    <div class="form-group">
        <label for="userPassword">User password</label>
        <form:input type="password" id="userPassword" path="userPassword" class="form-control"/>  
    </div>
    <div class="form-group">
        <label for="confirm-userPassword">Confirm password</label>
        <form:input type="password" id="confirm-userPassword" path="confirmUserPassword" class="form-control"/>  
    </div>
    <br>
    <div class="form-group text-center">
        <input type="submit" value="ĐĂNG KÝ" class="btn btn-outline-secondary btn-lg" data-mdb-ripple-color="dark"/>
    </div>
    <br>
    
</form:form>
