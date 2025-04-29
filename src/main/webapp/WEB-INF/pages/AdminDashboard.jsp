<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- dashboard.html -->
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/AdminDashboard.css"/>
</head>
<body>
  <header>
    <h1>Glam Up With Aaditi</h1>
    <nav>
      <button>Home</button>
      <button class="active">Admin Dashboard</button>
      <button>Product</button>
      <button>About Us</button>
    </nav>
  </header>
  <main>
    <input type="text" placeholder="search">

    <section class="stats">
      <div>Total Products<br>200</div>
      <div>Low Stock Items<br>30</div>
      <div>Out of stock<br>6</div>
      <div>Total Inventory Value<br>3,00,500</div>
      <div>New this month<br>7</div>
    </section>

    <section class="dashboard-tables">
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
          <button>Create</button><button>Update</button><button>Delete</button><button>View</button>
        </div>
      </div>
      <div class="orders">
        <h3>Orders</h3>
        <table>
          <tr><th>Name</th><th>Brand</th><th>Shade</th><th>Packed</th><th>Shipped</th></tr>
          <tr><td>Blush</td><td>Rare Beauty</td><td>Sensatio</td><td>5</td><td>8</td></tr>
          <tr><td>Setting Powde</td><td>Huda beaut</td><td>Trans</td><td>6</td><td>10</td></tr>
          <tr><td>Eyeshadow</td><td>NYX</td><td>Popx</td><td>2</td><td>8</td></tr>
          <tr><td>Lipgloss</td><td>LA Colors</td><td>Splash girl</td><td>15</td><td>10</td></tr>
        </table>
      </div>
    </section>

    <footer>
      <button>Contact Us</button>
      <button>Log out</button>
    </footer>
  </main>
</body>
</html>
