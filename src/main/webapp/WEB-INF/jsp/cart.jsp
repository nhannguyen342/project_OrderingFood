<%-- 
    Document   : cart
    Created on : Oct 17, 2022, 4:23:38 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-secondary">GIỎ HÀNG</h1>

<c:if test="${carts == null}">
    <h4 class="text-secondary">Chưa có món ăn nào trong giỏ</h4>
</c:if>

<c:if test="${carts != null}">
    <table class="table">
        <tr>
            <th>Mã món ăn</th>
            <th>Tên món ăn</th>
            <th>Đơn giá</th>
            <th>Số lượng món ăn</th>
            <th></th>
        </tr>
        <c:forEach items="${carts}" var ="c">
            <tr id="food${c.foodId}">
                <td>${c.foodId}</td>
                <td>${c.foodName}</td>
                <td>${c.unitPrice} VND</td>
                <td>
                    <div class="form-group">
                        <input type="number" onblur="updateCart(this, ${c.foodId})" value="${c.quantity}" class="form-control"/>
                    </div>
                </td>
                <td>
                    <input type="button" 
                           value="Xóa" 
                           onclick="deleteCart(${c.foodId})"
                           class="btn btn-outline-secondary" data-mdb-ripple-color="dark"/> 
                </td>
            </tr>
        </c:forEach>
    </table>
    
    <div>
        <h4 class="text-info">Tổng tiền hóa đơn: <span id="amountCart">${cartStats.amount}</span> VND</h4>
        
    </div>
    
        <input type="button" onclick="pay()" value="Thanh toán" class="btn btn-outline-secondary btn-lg" data-mdb-ripple-color="dark"/>
    <br><br>
</c:if>    