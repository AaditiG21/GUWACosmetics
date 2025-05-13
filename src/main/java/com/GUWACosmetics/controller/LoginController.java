package com.GUWACosmetics.controller;

import com.GUWACosmetics.model.CustomerModel;
import com.GUWACosmetics.service.LoginService;
import com.GUWACosmetics.util.CookiesUtil;
import com.GUWACosmetics.util.SessionUtil;
import com.GUWACosmetics.util.RedirectionUtil;
import com.GUWACosmetics.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
/**
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ValidationUtil validationUtil;
    private RedirectionUtil redirectionUtil;
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        this.validationUtil = new ValidationUtil();
        this.redirectionUtil = new RedirectionUtil();
        this.loginService = new LoginService();
    }

    /**
     * Handles GET requests for the login page.
     * Forwards the request to the login.jsp page for rendering.
     *
     * @param req The HttpServletRequest object that contains the request the client made of the servlet.
     * @param resp The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs during request processing.
     * @throws IOException If an input or output error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
    }

    /**
     * Handles POST requests for logging in users.
     * Validates the input and checks if the user is an admin or a customer. Redirects based on the role.
     *
     * @param req The HttpServletRequest object that contains the request the client made of the servlet.
     * @param resp The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs during request processing.
     * @throws IOException If an input or output error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Validate input fields
        if (!validationUtil.isNullOrEmpty(username) && !validationUtil.isNullOrEmpty(password)) {
            // Check for hardcoded admin credentials
            if (username.equalsIgnoreCase("Aaditi") && password.equals("Aaditi21")) {
                // Admin login successful
                SessionUtil.setAttribute(req, "username", username);
                CookiesUtil.addCookie(resp, "role", "admin", 5 * 30);
                resp.sendRedirect(req.getContextPath() + "/admindashboard");
            } else {
                // Create customer model and authenticate
                CustomerModel customerModel = new CustomerModel(username, password);
                Boolean loginStatus = loginService.loginUser(customerModel);

                if (loginStatus != null && loginStatus) {
                    SessionUtil.setAttribute(req, "username", username);

                    // Customer login successful
                    CookiesUtil.addCookie(resp, "role", "customer", 5 * 30);
                    resp.sendRedirect(req.getContextPath() + "/Home");
                } else {
                    handleLoginFailure(req, resp, loginStatus);
                }
            }
        } else {
            redirectionUtil.setMsgAndRedirect(req, resp, "error", "Please fill all the fields!", "WEB-INF/pages/login.jsp");
        }
    }

    /**
     * Handles login failure by setting an appropriate error message.
     *
     * @param req The HttpServletRequest object that contains the request the client made of the servlet.
     * @param resp The HttpServletResponse object that contains the response the servlet sends to the client.
     * @param loginStatus A Boolean indicating the result of the login attempt (null for server issue, false for failed login).
     * @throws ServletException If an error occurs during request processing.
     * @throws IOException If an input or output error occurs.
     */
    private void handleLoginFailure(HttpServletRequest req, HttpServletResponse resp, Boolean loginStatus)
            throws ServletException, IOException {
        String errorMessage;

        if (loginStatus == null) {
            errorMessage = "We're experiencing a server issue. Please try again shortly.";
        } else {
            errorMessage = "Invalid username or password. Please try again.";
        }
        
        redirectionUtil.setMsgAndRedirect(req, resp, "error", errorMessage, "WEB-INF/pages/login.jsp");
    }
}
