<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>GUWA Cosmetics</title>
    
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    
    <!-- Footer CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
</head>
<body>

   

    <!-- Clean Footer Section -->
    <footer class="footer">
        <div class="footer-container">
            <div class="footer-left">
                © 2024 GUWA Cosmetics. All rights reserved
            </div>
            <div class="footer-right">
                <a href="Contactus">Contact Us</a>
                <div class="footer-right">
            <!-- Simple Logout Form -->
            <form id="logoutForm" action="${pageContext.request.contextPath}/logout" method="post" style="display:inline;">
                <button type="submit" onclick="return confirmLogout()" class="logout-icon" title="Log out" style="background:none; border:none; cursor:pointer;">
                    <i class="fas fa-sign-out-alt"></i>
                </button>
            </form>
        </div>
    </div>
     </div>
       
    </footer>
    <script>
        function confirmLogout() {
            return confirm("Are you sure you want to logout?");
        }
    </script>
    

</body>
</html>
