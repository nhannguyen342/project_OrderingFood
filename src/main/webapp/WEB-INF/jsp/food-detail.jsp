<%-- 
    Document   : food-detail
    Created on : Sep 8, 2022, 1:24:28 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-secondary">CHI TIẾT MÓN ĂN</h1>
<div class="row">
    <div class="col-md-6">
        <c:if test="${food.image != null && food.image.startsWith('https') == true}">
            <img class="card-img-top img-fluid" src="<c:url value="${food.image}" />" alt="${food.name}"/> 
        </c:if>
        
        <c:if test="${food.image == null || food.image.startsWith('https') == false}">
            <img class="card-img-top img-fluid" src="<c:url value="/images/bunbo.png" />" alt="${food.name}"/>
        </c:if>  
    </div>
    <div class="col-md-6">
        <h1>${food.name}</h1>
        <h3 class="text-danger">${food.unitPrice} VND</h3>
        <p>${food.decription}</p>
        <div>
            <input type="button" value="Đặt món" class="btn btn-outline-secondary" data-mdb-ripple-color="dark"/>
        </div>
    </div>
</div>              
<br><br>
<br>
<div class="stars">
  <form action="">
    <input class="star star-5" id="star-5" type="radio" name="star"/>
    <label class="star star-5" for="star-5"></label>
    <input class="star star-4" id="star-4" type="radio" name="star"/>
    <label class="star star-4" for="star-4"></label>
    <input class="star star-3" id="star-3" type="radio" name="star"/>
    <label class="star star-3" for="star-3"></label>
    <input class="star star-2" id="star-2" type="radio" name="star"/>
    <label class="star star-2" for="star-2"></label>
    <input class="star star-1" id="star-1" type="radio" name="star"/>
    <label class="star star-1" for="star-1"></label>
  </form>
</div>

<br><br>
<form >
    <div class="form-group">
        <textarea class="form-control" id="commentId" placeholder="Nhập bình luận và đánh giá của bạn.."></textarea>
        <br>
        <input type="submit" onclick="addComment(${food.id})"
               value="Gửi bình luận" class="btn btn-outline-secondary btn-lg" data-mdb-ripple-color="dark"/>
        
    </div>
               <br>
</form>

        

<c:forEach items="${food.commentSet}" var="comment">
<div class="row">
    <div class="col-md-2">
        <img style="width: 150px" class="rounded-circle" src="${comment.userId.avatar}" />
    </div>
    <div class="col-md-10 my-date">
        <p>${comment.userId.fullName}</p>
        <p>${comment.content}</p>
        <i>${comment.createdDate}</i>
    </div>
</div> 
</c:forEach>

<script>
    window.onload = function() {
        let dates = document.querySelectorAll(".my-date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText ="Commented " + moment(d.innerText).fromNow()
        } 
    }  
</script>

<style>
div.stars {
  width: 270px;
  display: inline-block;
}
 
input.star { display: none; }
 
label.star {
  float: right;
  padding: 10px;
  font-size: 36px;
  color: #444;
  transition: all .2s;
}
 
input.star:checked ~ label.star:before {
  content: '\f005';
  color: #FD4;
  transition: all .25s;
}
 
input.star-5:checked ~ label.star:before {
  color: #FE7;
  text-shadow: 0 0 20px #952;
}
 
input.star-1:checked ~ label.star:before { color: #F62; }
 
label.star:hover { transform: rotate(-15deg) scale(1.3); }
 
label.star:before {
  content: '\f006';
  font-family: FontAwesome;
}
</style>
