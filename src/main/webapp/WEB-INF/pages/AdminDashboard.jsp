<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/AdminDashboard.css"/>
  <jsp:include page="AdminHeader.jsp" />
   <%
        String success = request.getParameter("success");
        if ("true".equals(success)) {
        %>
            <script>
                alert("Log in successful as Admin!");
            </script>
        <%
        }
        %>
</head>
<body>

 <main>
    <div class="stats">
      <div class="stats">
  <div>Total Products<br><b>${totalProducts}</b></div>
  <div>Low Stock Items<br><b>${lowStock}</b></div>
  <div>Out of stock<br><b>${outOfStock}</b></div>
  <div>Highest Price Product<br><b>${highestPrice}</b></div>
  <div>Lowest Price Product<br><b>${lowestPrice}</b></div>
</div>

    </div>

    <div class="dashboard-tables">
      <div class="trending">
        <h3>Trending Products</h3>
        <table>
          <tr><th>Name</th><th>Brand</th><th>Shade</th><th>Price</th></tr>
          <tr><td>Lip Gloss</td><td>Shein</td><td>POP</td><td>1300</td></tr>
          <tr><td>Foundation</td><td>Chanel</td><td>Creamy</td><td>5500</td></tr>
          <tr><td>Eyeshadow</td><td>Lakme</td><td>All Round</td><td>3330</td></tr>
          <tr><td>Eye Kajal</td><td>NOTE</td><td>Black</td><td>1100</td></tr>
        </table>
        <div class="actions">
          
          <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/Makeup'">Add</button>
        </div>
      </div>
      <div class="orders">
        <h3>Orders</h3>
        <table>
          <tr><th>Name</th><th>Brand</th><th>Shade</th><th>Packed</th><th>Shipped</th></tr>
          <tr><td>Blush</td><td>Rare Beauty</td><td>Sensatio</td><td>5</td><td>8</td></tr>
          <tr><td>Setting Powder</td><td>Huda Beauty</td><td>Trans</td><td>6</td><td>10</td></tr>
          <tr><td>Eyeshadow</td><td>NYX</td><td>Popx</td><td>2</td><td>8</td></tr>
          <tr><td>Lipgloss</td><td>LA Colors</td><td>Splash girl</td><td>15</td><td>10</td></tr>
        </table>
       
      </div>
      
    </div>
    
  </main>

  <jsp:include page="AdminFooter.jsp"/>
</body>
</html>
