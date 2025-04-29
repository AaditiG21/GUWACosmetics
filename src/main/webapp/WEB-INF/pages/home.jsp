<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/css/home.css"/>
    <title>GUWA Cosmetics - Home</title>
</head>
<body>

    <!-- Header Section -->
    <div class="header-container">
        <div class="header-content">
            <div class="logo">Glam Up With Aaditi</div>
            <div class="nav-container">
                <a href="#" class="nav-item">Home</a>
                <a href="#" class="nav-item">Admin Dashboard</a>
                <a href="#" class="nav-item">Products</a>
                <a href="#" class="nav-item">About Us</a>
            </div>
        </div>
    </div>

    
    <div class="main-container">
        <div class="content">
            <h1 class="title">Shop with the best</h1>
            <p class="subtitle">Stay stocked, Stay stunning</p>
            <button class="shop-button">Shop Now</button>
        </div>
        <div class="container">>
        <div class= "image">
        <div class="image1">
            <img src="${pageContext.request.contextPath}/resources/images/system/james.jpg" alt="GUWA Cosmetic Products">
        </div>
        <div class="image2">
            <img src="${pageContext.request.contextPath}/resources/images/system/Lipgloss.jpg" alt="GUWA Cosmetic Products">
        </div>
          <div class="image3">
            <img src="${pageContext.request.contextPath}/resources/images/system/Highliter.jpg" alt="GUWA Cosmetic Products">
        </div>
          <div class="image4">
            <img src="${pageContext.request.contextPath}/resources/images/system/foundation.jpg" alt="GUWA Cosmetic Products">
        </div>
          <div class="image5">
            <img src="${pageContext.request.contextPath}/resources/images/system/eyeshadow.jpg" alt="GUWA Cosmetic Products">
        </div>
        <div class="image6">
            <img src="${pageContext.request.contextPath}/resources/images/system/Mascara.jpg" alt="GUWA Cosmetic Products">
        </div>
  </div>
    </div>
    </div>

    <!-- Footer Section -->
    <div class="footer-container">
        <div class="footer-content">
            <div class="copyright">© 2024 GUWA Cosmetics. All rights reserved</div>
            <div class="footer-links">
                <a href="#" class="footer-link">Contact Us</a>
                <a href="#" class="footer-link">Log out</a>
            </div>
        </div>
    </div>
</body>
</html>
