<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:forEach var="m" items="${products}">
      <!-- Product 1 -->
      <div class="product-card">
      
       <img src="${pageContext.request.contextPath}/resources/images/system/${m.image}"/>
        <div class="product-details">
          <p class="product-name">${m.name}</p>
          <p class="product-shade">${m.shade}</p>
          <p class="product-price">${m.price}</p>
          
           <button class="shop-button">Buy Now</button>
        </div>
      </div>
     </c:forEach>	

    </section>

    <!-- Footer -->
    <jsp:include page="footer.jsp"/>

  </main>

</body>
</html>
