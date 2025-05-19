<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css"/>
    <title>Register</title>
    
</head>
<body>
    <div class="register-container">
        <form action="${pageContext.request.contextPath}/Register" method="post">
            <% 
                String errorMessage = (String) request.getAttribute("error");
                String successMessage = (String) request.getAttribute("success");
                if (errorMessage != null && !errorMessage.isEmpty()) {
            %>
                <p class="error-message"><%= errorMessage %></p>
            <%
                }
                if (successMessage != null && !successMessage.isEmpty()) {
            %>
                <p class="success-message"><%= successMessage %></p>
            <%
                }
            %> 

            <h2>Register to explore more</h2>

            <label>First Name:</label>
            <input type="text" id="fname" name="fname">

            <label>Last Name:</label>
            <input type="text" id="lname" name="lname">

            <label>Username:</label>
            <input type="text" id="username" name="username">

            <label>Phone number:</label>
            <input type="tel" id="phone" name="phone">

            <label>Email Address:</label>
            <input type="email" id="email" name="email">

            <label>Password:</label>
            <input type="password" id="password" name="password">

            <label>Confirm Password:</label>
            <input type="password" id="cpassword" name="cpassword">

            <div class="buttons">
                <button type="submit">Register</button>
                <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/login'">Cancel</button>

            </div>
        </form>

        <div class="background-image">
            <img src="${pageContext.request.contextPath}/resources/images/system/L2.jpg" alt="GUWA Cosmetic Products">
        </div>
    </div>

    
    <div class="social-footer">
        <p>Connect with us:</p>
        <div class="social-icons">
            <a href="https://www.facebook.com/" target="_blank" aria-label="Facebook">
                <img src="${pageContext.request.contextPath}/resources/images/system/facebook.png" alt="Facebook">
            </a>
            <a href="https://www.instagram.com/" target="_blank" aria-label="Instagram">
                <img src="${pageContext.request.contextPath}/resources/images/system/instagram.png" alt="Instagram">
            </a>
            <a href="https://www.tiktok.com/" target="_blank" aria-label="TikTok">
                <img src="${pageContext.request.contextPath}/resources/images/system/tiktok.png" alt="TikTok">
            </a>
        </div>
    </div>
</body>
</html>
