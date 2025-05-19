<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>GUWA Cosmetics</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminFooter.css">
    <script src="https://kit.fontawesome.com/6882fa3990.js" crossorigin ="anonymous"></script>
</head>
<body>

    <!-- Your main page content here -->

    <!-- Clean Footer Section -->
   <footer class="site-footer">
        <div class="footer-container">
            <div class="footer-left">
                © 2024 GUWA Cosmetics. All rights reserved
            </div>
            <div class="footer-right">
            <!-- Simple Logout Form -->
            <form id="logoutForm" action="${pageContext.request.contextPath}/logout" method="post" style="display:inline;">
                <button type="submit" onclick="return confirmLogout()" class="logout-icon" title="Log out" style="background:none; border:none; cursor:pointer;">
                    <i class="fas fa-sign-out-alt"></i>
                </button>
            </form>
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