<%-- 
    Document   : product
    Created on : Sep 5, 2022, 11:55:23 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<h1 class="text-center text-secondary">QUẢN LÝ MÓN ĂN</h1>



<c:url value="/restaurant/foods" var="action"/>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
    
</c:if>

<form:form method="post" action="${action}" modelAttribute="food"
           enctype="multipart/form-data">
    
    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    
    <div class="form-group">
        <label for="name">Tên món ăn</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
        <form:errors path="name" cssClass="alert alert-danger" element="div" />
    </div>
     <div class="form-group">
        <label for="decription">Mô tả</label>
        <form:textarea id="decription" path="decription" cssClass="form-control"></form:textarea>
     </div>
     <div class="form-group">
        <label for="unitPrice">Giá</label>
        <form:input type="text" id="unitPrice" path="unitPrice" cssClass="form-control"/>
        <form:errors path="unitPrice" cssClass="alert alert-danger" element="div" />

     </div>
         <div class="form-group">
        <label for="rest">Danh mục</label>
        <form:select id="rest" path="restaurant" cssClass="form-control">
            <c:forEach items="${restaurants}" var="res">
                <option value="${res.id}">${res.name}</option>
            </c:forEach>
        </form:select>
        <form:errors path="restaurant" cssClass="alert alert-danger" element="div" />
    </div>
       
    <div class="form-group">
        <label for="file">Ảnh món ăn</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <br>
    <div class="form-group text-center">
            <input type="submit" value="Thêm món ăn" class="btn btn-outline-secondary btn-lg" data-mdb-ripple-color="dark"/>
    </div>
    <br>
    
</form:form>