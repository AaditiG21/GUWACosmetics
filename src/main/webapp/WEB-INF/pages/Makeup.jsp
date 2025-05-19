<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Makeup Product Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Makeup.css"/>
    <link href="https://fonts.cdnfonts.com/css/bestaline" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6882fa3990.js" crossorigin ="anonymous"></script>
    <jsp:include page="AdminHeader.jsp" />
    
</head>
<body>

<div class="search-container">
    <form method="get" action="${pageContext.request.contextPath}/Makeup">
        <input 
            type="text" 
            name="search" 
            class="search-box" 
            placeholder="Search products..." 
            value="${param.search != null ? param.search : ''}" />
        <button type="submit"><i class="fa-solid fa-magnifying-glass"></i> Search</button>
    </form>
</div>


<div class="container">
    <h1>Makeup Products</h1>

     <!-- Message Handling -->
    <c:if test="${not empty error}">
        <p class="error-message">${error}</p>
    </c:if>
    <c:if test="${not empty success}">
        <p class="success-message">${success}</p>
    </c:if>
    <!-- Product Table -->
    <div class="table-container">
        <table class="products-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Shade</th>
                    <th>Brand</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Image</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.shade}</td>
                        <td>${product.brand}</td>
                        <td>${product.price}</td>
                        <td>${product.stock}</td>
                       <td> <img style = "width:80px; height:120px;" src="${pageContext.request.contextPath}/resources/images/system/${product.image}"/></td>
                      
                        <td style="display:flex;">
                        
                            <form method="post" action="${pageContext.request.contextPath}/Makeup">
                                <input type="hidden" name="delete_id" value="${product.id}" />
                                
                                <button type="submit" name="action" value="delete">
                                    <i class="fa-regular fa-trash-can"></i>
                                </button>
                            </form>
                            <!-- Optional update button (can be implemented later) -->
                            <button type="button"><i class="fa-regular fa-pen-to-square"></i></button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Add Product Form -->
    <div class="crud-form">
        <h2>Add Product</h2>
       <form action="${pageContext.request.contextPath}/Makeup" method="post" enctype="multipart/form-data">

        
            <label> Name</label>
            <input type="text" name="name" required />

            <label>Shade</label>
            <input type="text" name="shade" required />

            <label>Brand</label>
            <input type="text" name="brand" required />

            <label>Stock</label>
            <input type="number" name="stock" required />

            <label>Price</label>
            <input type="number" name="price" required />
            
            <label for="image">Product Image</label> <input type="file"
						id="image" name="image">
						
            <div class="buttons">
                <button type="submit" name="action" value="add">Add</button>
                
                <!-- Update can be wired in future -->
            </div>
        </form>
    </div>
</div>

<jsp:include page="AdminFooter.jsp" />

</body>
</html>
