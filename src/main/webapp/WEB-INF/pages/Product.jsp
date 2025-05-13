<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- product.html -->
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Product Page</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Product.css"/>
  <jsp:include page="header.jsp" />
</head>

<body>

 


  <main>
    
    

    <!-- Product List Section -->
    <section class="product-list">
      <!-- Product 1 -->
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/system/P1.jpg" alt="La Colors Lip Gloss">
        <div class="product-details">
          <p class="product-name">La Colors Lip Gloss</p>
          <p class="product-shade">Shade: Splash girl</p>
          <p class="product-price">Rs 350</p>
           <button class="shop-button">Buy Now</button>
        </div>
      </div>

      <!-- Product 2 -->
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/system/F1.jpg" alt="Chanel Foundation">
        <div class="product-details">
          <p class="product-name">Chanel Foundation</p>
          <p class="product-shade">Shade: Pure beige</p>
          <p class="product-price">Rs 4500</p>
          <button class="shop-button">Buy Now</button>
        </div>
      </div>

      <!-- Product 3 -->
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/system/P2.jpg" alt="Wet n Wild Concealer">
        <div class="product-details">
          <p class="product-name">Wet n Wild Concealer</p>
          <p class="product-shade">Shade: Natural gold</p>
          <p class="product-price">Rs 800</p>
          <button class="shop-button">Buy Now</button>
        </div>
      </div>

      <!-- Product 4 -->
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/system/P3.jpg" alt="Rare Beauty Blush">
        <div class="product-details">
          <p class="product-name">Rare Beauty Blush</p>
          <p class="product-shade">Shade: Sensation</p>
          <p class="product-price">Rs 2000</p>
          <button class="shop-button">Buy Now</button>
        </div>
      </div>

      <!-- Product 5 -->
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/system/P4.jpg" alt="GUWA Lipstick">
        <div class="product-details">
          <p class="product-name">GUWA Lipstick</p>
          <p class="product-shade">Shade: Mocha</p>
          <p class="product-price">Rs 780</p>
          <button class="shop-button">Buy Now</button>
        </div>
      </div>

      <!-- Product 6 -->
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/system/P5.jpg" alt="NYX Eyeshadow">
        <div class="product-details">
          <p class="product-name">NYX Eyeshadow</p>
          <p class="product-shade">Shade: Everyday glow</p>
          <p class="product-price">Rs 2200</p>
          <button class="shop-button">Buy Now</button>
        </div>
      </div>

      <!-- Product 7 -->
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/system/P6.jpg" alt="Huda Beauty Powder">
        <div class="product-details">
          <p class="product-name">Laura Mercier</p>
          <p class="product-shade">Shade: Setting dust</p>
          <p class="product-price">Rs 1700</p>
          <button class="shop-button">Buy Now</button>
        </div>
      </div>

      <!-- Product 8 -->
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/system/P7.jpg" alt="NYX Lip Tint">
        <div class="product-details">
          <p class="product-name">NYX Lip Tint</p>
          <p class="product-shade">Shade: Reddy red</p>
          <p class="product-price">Rs 1300</p>
          <button class="shop-button">Buy Now</button>
        </div>
      </div>

    </section>

    <!-- Footer -->
    <jsp:include page="footer.jsp"/>

  </main>

</body>
</html>
