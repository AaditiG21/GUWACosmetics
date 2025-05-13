<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="jakarta. servlet.http.HttpSession" %>
<%@ page import="jakarta. servlet.http.HttpServletRequest" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GUWA Cosmetics</title>
    <link href="https://fonts.googleapis.com/css2?family=Inria+Sans:wght@400;700&family=Kalnia:wght@700&family=Meow+Script&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminHeader.css">
</head>
<body>

   
    <header class="header">
    <div class="logo">Guwa Admin Dashboard</div>
    <nav class="nav">
      <a href="AdminDashboard">Dashboard</a>
      <a href="Makeup">Makeup</a>
      <a href="Contactus">Contact Us</a>
      <a href="Aboutus">About Us</a>
      <a href="AdminProfile">Profile</a>
    </nav>
  </header>

</body>
</html>