/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function generateColor() {
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r}, ${g}, ${b})`
}

function resChart(id, resLabels =[], resInfo=[]) {
    const colors = []
    for (let i = 0;i < resInfo.length; i++)
        colors.push(generateColor())
    
    const data = {
        labels: resLabels,
        datasets: [{
          label: 'Thong ke mon an theo danh muc nha hang',
          data: resInfo,
          backgroundColor: colors,
          hoverOffset: 4
        }]
      };
      
      const config = {
        type: 'doughnut',
        data: data,
      };
      
      let ctx = document.getElementById(id).getContext("2d")
      new Chart(ctx, config)
}

