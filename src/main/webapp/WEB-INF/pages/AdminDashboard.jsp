<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/AdminDashboard.css"/>
</head>
<body>
  <header>
   
     <jsp:include page="header.jsp" />
  </header>

  <main>
    <input type="text" placeholder="Search">

    <div class="stats">
      <div>Total Products<br><b>200</b></div>
      <div>Low Stock Items<br><b>30</b></div>
      <div>Out of stock<br><b>6</b></div>
      <div>Total Inventory Value<br><b>3,00,500</b></div>
      <div>New this month<br><b>7</b></div>
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
          <button>Create</button>
          <button>Update</button>
          <button class="delete">Delete</button>
          <button class="view">View</button>
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

    <jsp:include page="footer.jsp"/>
  </main>
</body>
</html>
