<%-- 
    Document   : restaurant-stats
    Created on : Oct 19, 2022, 3:37:39 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-secondary">THỐNG KÊ MÓN ĂN THEO DANH MỤC MÓN ĂN</h1>

<div>
  <canvas id="myResStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã danh mục nhà hàng</th>
        <th>Tên danh mục nhà hàng</th>
        <th>Số lượng món ăn</th>
    </tr>
    <c:forEach items="${resStats}" var="r">
        <tr>
            <td>${r[0]}</td>
            <td>${r[1]}</td>
            <td>${r[2]}</td>
        </tr>
    </c:forEach>
</table>

<script>
    let resLabels=[], resInfo=[];
    
    <c:forEach items="${resStats}" var="r">
        resLabels.push('${r[1]}')
        resInfo.push(${r[2]})
    </c:forEach>
    
    window.onload = function() {
        resChart("myResStatsChart", resLabels, resInfo)
    }
</script>