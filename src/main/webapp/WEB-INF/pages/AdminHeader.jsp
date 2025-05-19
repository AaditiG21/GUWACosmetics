<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>GUWA Cosmetics Admin</title>

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&family=Kalnia:wght@700&display=swap" rel="stylesheet" />

    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />

    <!-- Your custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminHeader.css" />
</head>
<body>

<header class="header">
    <div class="header-container">
        <span class="logo">Guwa Admin Dashboard</span>
        <nav class="main-nav">
            <a href="AdminDashboard">Dashboard</a>
            <a href="Makeup">Makeup</a>
            <a href="Contactus">Contact Us</a>
            <a href="Aboutus">About Us</a>
            <a href="AdminProfile">
                <i class="fas fa-user-circle"></i>
            </a>
        </nav>
    </div>
</header>

</body>
</html>
