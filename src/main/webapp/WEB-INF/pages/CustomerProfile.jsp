<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css"
     href="${pageContext.request.contextPath}/css/CustomerProfile.css"/>
  <title>profile</title>
  <jsp:include page="header.jsp" />
</head>

<body>
    <div class="profile-container">
        <div class="profile-content">
            <!-- Left Column - Avatar -->
            <div class="profile-left">
                <div class="face-container">
                    <div class="face-profile">
                        <i class="fas fa-user avatar-placeholder"></i>
                        <!-- <img src="profile-pic.jpg" alt="Profile Picture"> -->
                    </div>
                    <a href="#" class="upload-btn">Upload Picture</a>
                </div>
            </div>

            <!-- Right Column - Form -->
            <div class="profile-right">
                <form class="profile-form">
                    <div class="form-group">
                     <h2 class="section-title"> CUSTOMER PROFILE</h2>
                        <label class="form-label">Username:</label>
                        <div class="form-control-wrapper">
                            <input type="text" class="form-control" value="" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="form-label">E-mail:</label>
                        <div class="form-control-wrapper">
                            <input type="email" class="form-control" value="">
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="form-label">Password:</label>
                        <div class="form-control-wrapper">
                            <input type="text" class="form-control" placeholder="">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="form-label">Repeat Password:</label>
                        <div class="form-control-wrapper">
                            <input type="text" class="form-control" placeholder="">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="form-label">About Me:</label>
                        <div class="form-control-wrapper">
                            <textarea class="form-control"></textarea>
                        </div>
                    </div>

                    <button type="submit" class="update-btn">Update Profile</button>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>