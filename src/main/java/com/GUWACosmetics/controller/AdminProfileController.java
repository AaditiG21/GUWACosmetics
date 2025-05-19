package com.GUWACosmetics.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.GUWACosmetics.model.CustomerModel;
import com.GUWACosmetics.service.ProfileService;
import com.GUWACosmetics.util.PasswordUtil;

/**
 * Servlet controller for rendering the Admin Profile page.
 * 
 * This servlet handles both GET and POST requests for the `/AdminProfile` endpoint
 * and forwards the request to the `AdminProfile.jsp` view.
 * 
 * LMU ID: 23048679  
 * NAME: Aaditi Ghimire
 */
@WebServlet(
    asyncSupported = true,
    urlPatterns = { "/AdminProfile" }
)
public class AdminProfileController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProfileService service;

    /**
     * Default constructor.
     * Initializes the servlet.
     */
    public AdminProfileController() {
        super();
        this.service = new ProfileService();
    }

    /**
     * Handles GET requests by loading admin profile data and forwarding to the JSP view.
     *
     * @param request  the {@link HttpServletRequest} object containing client request
     * @param response the {@link HttpServletResponse} object for the response to client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            System.out.println("Username from session: " + username);

            CustomerModel profile = service.getCustomerByUsername(username);

            if (profile != null) {
                System.out.println("Customer loaded: " + profile.getUserName());
                String encryptedPassword = profile.getPassword();
                System.out.println("Encrypted from DB: " + encryptedPassword);
                String decryptedPassword = PasswordUtil.decrypt(encryptedPassword, profile.getUserName());
                System.out.println("Decrypted password: " + decryptedPassword);
                profile.setPassword(decryptedPassword);
                request.setAttribute("customer", profile);
            } else {
                System.out.println("No customer found for username");
            }
        } else {
            System.out.println("Session or username attribute is null");
        }

        request.getRequestDispatcher("WEB-INF/pages/AdminProfile.jsp").forward(request, response);
    }

    /**
     * Handles POST requests for updating the admin profile.
     * Accepts form parameters, validates passwords, updates profile, and forwards to the JSP.
     *
     * @param request  the {@link HttpServletRequest} object containing client-submitted form data
     * @param response the {@link HttpServletResponse} object for sending feedback to client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newpassword");
        String confirmPassword = request.getParameter("confirmpassword");

        String encryptedPassword = null;
        boolean updatePassword = false;

        if (newPassword != null && !newPassword.isEmpty()) {
            if (newPassword.equals(confirmPassword)) {
                encryptedPassword = PasswordUtil.encrypt(userName, newPassword);
                updatePassword = true;
            } else {
                request.setAttribute("error", "New password and confirm password do not match.");
                doGet(request, response);
                return;
            }
        }

        boolean success = service.updateUserProfile(
            userName, firstName, lastName, phonenumber, email, password, updatePassword ? encryptedPassword : null
        );

        if (success) {
            request.setAttribute("message", "Profile updated successfully.");
        } else {
            request.setAttribute("error", "Failed to update profile.");
        }

        doGet(request, response);
    }
}
