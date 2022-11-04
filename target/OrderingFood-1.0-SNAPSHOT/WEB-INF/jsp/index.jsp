<%-- 
    Document   : index
    Created on : Sep 4, 2022, 12:33:05 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
     


<h1 class="text-center text-secondary">DANH MỤC THỨC ĂN</h1>

    <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_RESTAURANT')">
     <div>
         <a href="<c:url value="/restaurant/foods"/> ">QUẢN LÝ MÓN ĂN</a>
     </div>
      <div>
         <a href="<c:url value="/admin/restaurant-stats"/> ">THỐNG KÊ, BÁO CÁO</a>
     </div>
     </sec:authorize>
     <form action="">
         <div class="row">
            <div class="col-md-11">
                <input class="form-control" type="text" name="kw" placeholder="Nhập từ khóa để tìm kiếm..."/>
            </div>
             <div class="col-md-1">
                 <input type="submit" value="Tìm kiếm" class="btn btn-outline-secondary " data-mdb-ripple-color="dark"/>
             </div>
         </div>
     </form>
    <!-- Center-aligned -->
        <ul class="pagination pagination-sm">
            <c:forEach begin="1" end="${Math.ceil(foodCounter/9)}" var ="page">
                <li class="page-item"><a class="page-link" href="<c:url value="/"/>?page=${page}">${page}</a></li>
            </c:forEach>
        </ul>
     <div class="row">
         <c:forEach var="f" items="${foods}">
             <div class="col-md-4 " style="padding: 10px">
                <div class="card-body border text-center" style="width: 400px">
                    <a href="<c:url value="/foods/${f.id}"/>">
                        <c:if test="${f.image != null && f.image.startsWith('https') == true}">
                            <img class="img-fluid" src="<c:url value="${f.image}"/>" alt="{f.name}"/>
                        </c:if>
                        <c:if test="${f.image == null || f.image.startsWith('https') == false}">
                            <img class="img-fluid" src="<c:url value="/images/bunbo.png"/>" alt="{f.name}"/>
                        </c:if>    
                    </a>
                    <h4>${f.name}</h4>
                    <p>${f.unitPrice} VND</p>
                    <a href="#" class="btn btn-danger" onclick="addToCart(${f.id}, '${f.name}', ${f.unitPrice})">Đặt món</a>
                    <a href="#" class="btn btn-info">Mua ngay</a>
                </div>
               <div class="card-footer">
                   

               </div>
           </div>
        </c:forEach>
     </div>

