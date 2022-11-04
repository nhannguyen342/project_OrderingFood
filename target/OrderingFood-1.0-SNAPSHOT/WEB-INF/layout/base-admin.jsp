<%-- 
    Document   : base-admin
    Created on : Oct 19, 2022, 2:41:07 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link rel='stylesheet prefetch' href='https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css'>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="<c:url value="/css/style.css" />" rel="stylesheet"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
        <script src="<c:url value="/js/main.js"/>"></script>
        <link href="file://E:/fontawesome/css/all.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <body>
        <h1 class="text-center text-primary" style="background-color: #EAD2AC;">TRANG THỐNG KÊ - BÁO CÁO</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-xs-12">
                    <!-- HEADER -->
                    <tiles:insertAttribute name="left"/>
                </div>
                <div class="col-md-8 col-xs-12">
                     <!-- CONTENT -->
                    <tiles:insertAttribute name="content"/>
                </div>
            </div>
                
            <!-- FOOTER -->
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
    
    <script src="<c:url value="/js/stats.js"/>"></script>
</html>
