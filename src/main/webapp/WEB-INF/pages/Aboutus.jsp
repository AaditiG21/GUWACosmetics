<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Aboutus.css"/>
</head>
<body>
    <header>
        <div class="container header-content">
            
             <jsp:include page="header.jsp" />
        </div>
    </header>

    <main class="container">
        <h2 class="about-us-title">About Us</h2>
        <div class="about-content">
            <div class="about-box">
                <p>GUWA cosmetics focuses on providing the customers the best and high quality products.
                Our page offers you high range of makeup products and fragrance options.
                Our aim is to make beauty accessible and easy to find. GUWA makes sure you have the best product at your belldoor.</p>
            </div>

            <div class="Aboutus-image">
                <div class="profile-container clearfix">
                    <img src="${pageContext.request.contextPath}/resources/images/system/A1.jpg" alt="GUWA Cosmetic Products" class="profile-img">
                    <div class="profile-info">
                        <h1 class="M1">Name:Jesh Delevigne</h1>
                        <h2 class="M1">Age:21</h2>
                        <h3 class="M1">Working in Guwa since:2000</h3>
                        <button class="button">View More</button>
                    </div>
                </div>
            </div>

            <div class="Aboutus-image">
                <div class="profile-container clearfix">
                    <img src="${pageContext.request.contextPath}/resources/images/system/A2.jpg" alt="GUWA Cosmetic Products" class="profile-img">
                    <div class="profile-info">
                        <h1 class="M1">Name:Indiana Sharma</h1>
                        <h2 class="M1">Age:22</h2>
                        <h3 class="M1">Working in Guwa since:2005</h3>
                        <button class="button">View More</button>
                    </div>
                </div>
            </div>

            <div class="about-box">
                <p>Guwa believes that makeup is more than just a beauty.
                Its about feeling confident and comfortable in your own skin.
                Our Guwa team produce makeup with one goal set in mind - to bring only good.
                Being environmentally conscious we work with brands that prioritizes sustainable packaging.</p>
            </div>
        </div>
    </main>

    <jsp:include page="footer.jsp"/>

    
</body>
</html>