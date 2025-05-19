<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GUWA Cosmetics</title>

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&family=Kalnia:wght@700&display=swap" rel="stylesheet">

    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <!-- Your custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>

    <header class="header">
        <div class="header-container">
            <span class="logo">Glam Up with Aaditi</span>
            <nav class="main-nav">
                <a href="Home">Home</a>
                <a href="Product">Product</a>
                <a href="Aboutus">About Us</a>
                <a href="AdminDashboard">Dashboard</a>
                <input type="text" class="search-box" placeholder="Search...">
                <a href="CustomerProfile">
                    <i class="fas fa-user-circle"></i>
                </a>
   
              
            </nav>
        </div>
    </header>

</body>
</html>
