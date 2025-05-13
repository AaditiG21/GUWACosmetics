<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/home.css"/>
    <jsp:include page="header.jsp" />
    
</head>
<body>

<div class="main-container">
    <div class="content">
        <h1 class="title">Shop with the best</h1>
        <p class="subtitle">Stay stocked, Stay stunning</p>
        <button class="shop-button">Shop Now</button>
    </div>
    
    <div class="container">
        <!-- Top Row -->
        <div class="image1">
            <img src="${pageContext.request.contextPath}/resources/images/system/james.jpg" alt="GUWA Cosmetic Products">
            <div class="product-label">
                <h3 class="product-name">Artist Palette</h3>
                
            </div>
        </div>
        
        <div class="image2">
            <img src="${pageContext.request.contextPath}/resources/images/system/Lipgloss.jpg" alt="GUWA Cosmetic Products">
            <div class="product-label">
                <h3 class="product-name">Luxury Lip Gloss</h3>
               
            </div>
        </div>
        
        <div class="image3">
            <img src="${pageContext.request.contextPath}/resources/images/system/Highliter.jpg" alt="GUWA Cosmetic Products">
            <div class="product-label">
                <h3 class="product-name">Glow Highlighter</h3>
                
            </div>
        </div>
        
        <!-- Bottom Row -->
        <div class="image4">
            <img src="${pageContext.request.contextPath}/resources/images/system/foundation.jpg" alt="GUWA Cosmetic Products">
            <div class="product-label">
                <h3 class="product-name">Liquid Foundation</h3>
                
            </div>
        </div>
        
        <div class="image5">
            <img src="${pageContext.request.contextPath}/resources/images/system/eyeshadow.jpg" alt="GUWA Cosmetic Products">
            <div class="product-label">
                <h3 class="product-name">Shimmer Eyeshadow</h3>
               
            </div>
        </div>
        
        <div class="image6">
            <img src="${pageContext.request.contextPath}/resources/images/system/Mascara.jpg" alt="GUWA Cosmetic Products">
            <div class="product-label">
                <h3 class="product-name">Volume Mascara</h3>
               
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>