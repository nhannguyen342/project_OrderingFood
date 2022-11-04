/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
/* global fetch */

function addComment(id) {
    fetch("/OrderingFood/api/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "foodId": id
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)
        
        return res.json();
    }).then(function(data) {
        
        let area = document.getElementById("commentArea");
        area.innerHTML = `
            <div class="row">
                <div class="col-md-2" style="padding: 10px">
                    <img class="rounded-circle img-fluid" src="<c:url value="/images/Anh-meo.jpg"/>" alt="11" />
                </div>
                <div class="col-md-10 my-date">
                    <p>${data.content}</p>
                    <i>${moment(data.createdDate).fromNow()}</i>
                </div>
            </div> ` 
        + area.innerHTML
    })
}

function addToCart(id, name, unitPrice) {
    event.preventDefault()
    
    fetch("/OrderingFood/api/cart", {
        method: 'post',
        body: JSON.stringify ({
            "foodId": id,
            "foodName": name,
            "unitPrice": unitPrice,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
        return res.json()
    }).then(function(data) {
        let counter = document.getElementById("cartCounter")
        counter.innerText = data
    })
}

function updateCart(obj, foodId) {
    fetch("/OrderingFood/api/cart", {
        method: 'put',
        body: JSON.stringify ({
            "foodId": foodId,
            "foodName": "",
            "unitPrice": 0,
            "quantity": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res){
        return res.json()
    }).then(function(data) {
        let counter = document.getElementById("cartCounter")
            counter.innerText = data.counter
            let amount = document.getElementById("amountCart")
            amount.innerText = data.amount
    })
}

function deleteCart(foodId) {
    if (confirm("Ban chac chan muon xoa mon an nay chu?") == true) {
       fetch(`/OrderingFood/api/cart/${foodId}`, {
            method: "delete"
        }).then(function (res){
            return res.json()
        }).then(function(data) {
            let counter = document.getElementById("cartCounter")
            counter.innerText = data.counter
            let amount = document.getElementById("amountCart")
            amount.innerText = data.amount
            let row = document.getElementById(`food${foodId}`)
            row.style.display = "none"
        }) 
    }   
}

function pay() {
    if (confirm("Ban chac chan thanh toan?") == true) {
        fetch("/OrderingFood/api/pay", {
            method: "post"
        }).then(function(res) {
            return res.json();
        }).then(function(code) {
            console.info(code);
            location.reload();
        })
    }
}
