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
                    </div>
                    <a href="#" class="upload-btn">Upload Picture</a>
                </div>
            </div>

            <!-- Right Column - Form -->
            <div class="profile-right">
                <form class="profile-form">
                
                    <div class="form-group">
                     <h2 class="section-title"> CUSTOMER PROFILE</h2>
                     
                     <div class="form-group">
                        <label class="form-label">Username:</label>
                        <div class="form-control-wrapper">
                            <input type="text" class="form-control" id="username" name="username" value="${customer.userName}" required>
                        </div>
                    </div>
                        <label class="form-label">First Name:</label>
                        <div class="form-control-wrapper">
                       		<input type="text" class="form-control" id="firstname" name="firstname" value="${customer.firstName}" required>
                        </div>
                    </div>
                    
                    
                    <div class="form-group">
                        <label class="form-label">Last Name:</label>
                        <div class="form-control-wrapper">
                            <input type="text" class="form-control" id="lastname" name="lastname" value="${customer.lastName}" required>
                        </div>
                    </div>
                    
                    
                    
                    <div class="form-group">
                        <label class="form-label">Phone Number:</label>
                        <div class="form-control-wrapper">
                           <input type="text" class="form-control" id="phonenumber" name="phonenumber" value="${customer.phonenumber}" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="form-label">E-mail:</label>
                        <div class="form-control-wrapper">
                           <input type="text"  class="form-control" id="email" name="email" value="${customer.email}" required>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="form-label">Password:</label>
                        <div class="form-control-wrapper">
                           <input type="text"  class="form-control" id="password" name="password" value="${customer.password}" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="form-label">New Password:</label>
                        <div class="form-control-wrapper">
                           <input type="text"  class="form-control" id="newpassword" name="newpassword"  required>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="form-label">Confirm Password:</label>
                        <div class="form-control-wrapper">
                           <input type="text"  class="form-control" id=confirmpassword name="confirmpassword"   required>
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