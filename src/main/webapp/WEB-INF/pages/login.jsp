<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to GUWA</title>
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/css/login.css"/>
</head>
<body>
    
   
    <div class="login-container">
        <!-- Left-aligned Form Section -->
        <div class="login-form">
            <div class="welcome-header">
                <h1>GUWA Cosmetics</h1>
                <h2>Login – The First Step to Flawless Inventory.</h2>
            </div>

            <form action="login" method="post">
                <% if (request.getParameter("Error") != null) { %>
                    <p class="error-message"><%= request.getParameter("Error") %></p>
                <% } %>
                <% if (request.getAttribute("error") != null) { %>
                    <p class="error-message"><%= request.getAttribute("error") %></p>
                <% } %>

                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" required>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>

                <button type="submit" class="login-button">Login</button>
                
                <div class="links">
                    <a href="Register">Register if new</a>
                    
                    <a href="#">Forgot Password?</a>
                </div>
            </form>
        </div>

        
        <div class="login-image">
            <img src="${pageContext.request.contextPath}/resources/images/system/register.jpg" 
                 alt="GUWA Cosmetic Products">
                 
        </div>
    </div>

</body>
</html>