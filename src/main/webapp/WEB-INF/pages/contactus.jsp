<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - GUWA Cosmetics</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Contactus.css"/>
</head>
<body>
    <div class="container">
        <!-- Header -->
        <header>
            
             <jsp:include page="header.jsp" />
        </header>

        <!-- Contact Page Content -->
        <div class="content">
            <h1 class="page-title">Contact Us</h1>
            
            <div class="contact-grid">
                <div class="contact-item">
                    <div class="contact-icon">
                        <i class="phone-icon"></i>
                    </div>
                    <h3 class="contact-title">Give us a call?</h3>
                    <p class="contact-info">+977-9867843</p>
                    <p class="contact-info">+01-5677822</p>
                </div>
                <div class="contact-item">
                    <div class="contact-icon">
                       
                    </div>
                    <h3 class="contact-title">Location</h3>
                    <p class="contact-info">Nawal, Kathmandu</p>
                </div>
                <div class="contact-item">
                    <div class="contact-icon">
                        <i class="email-icon"></i>
                        
                    </div>
                    <h3 class="contact-title">Message us at</h3>
                    <p class="contact-info">guwacosmetics111@gmail.com</p>
                </div>
            </div>

            <div class="contact-form-container">
                <h2 class="form-title">Send Us a Message</h2>
                <form class="contact-form">
                    <div class="form-group">
                        <input type="text" class="form-input" placeholder="Your Name" required>
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-input" placeholder="Your Email" required>
                    </div>
                    <div class="form-group">
                        <textarea class="form-input" placeholder="Share us your thoughts?" rows="6" required></textarea>
                    </div>
                    <button type="submit" class="submit-btn">Send Message</button>
                </form>
            </div>

            <div class="hours">
                <h3 class="hours-title">Business Hours</h3>
                <p>Opening time: 10am</p>
                <p>Closing time: 7pm</p>
                <p>Open Monday through Saturday</p>
            </div>
        </div>

        <!-- Footer -->
        <footer>
            <div class="copyright">© 2024 GUWA Cosmetics. All rights reserved</div>
            <div class="footer-btns">
                <a href="contact.html" class="footer-btn active">Contact Us</a>
                <a href="logout.html" class="footer-btn outline">Log out</a>
            </div>
        </footer>
    </div>
</body>
</html>