package com.GUWACosmetics.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.GUWACosmetics.model.CustomerModel;
import com.GUWACosmetics.service.RegisterService;
import com.GUWACosmetics.util.PasswordUtil;
import com.GUWACosmetics.util.ValidationUtil;
/**
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/Register" })
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RegisterService registerService = new RegisterService();

    /**
     * Handles the HTTP <code>GET</code> request.
     * <p>
     * This method is responsible for displaying the registration page to the user.
     * </p>
     * 
     * @param req the HttpServletRequest object that contains the request the client made of the servlet.
     * @param resp the HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException if the request for the GET could not be handled.
     * @throws IOException if an input or output error is detected when the servlet handles the request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    /**
     * Handles the HTTP <code>POST</code> request.
     * <p>
     * This method processes the registration form data, validates it, and attempts to create a new customer account.
     * </p>
     * 
     * @param req the HttpServletRequest object that contains the request the client made of the servlet.
     * @param resp the HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException if the request for the POST could not be handled.
     * @throws IOException if an input or output error is detected when the servlet handles the request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set character encoding for request and response
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        try {
            String validationMessage = validateRegistrationForm(req);
            if (validationMessage != null) {
                handleError(req, resp, validationMessage);
                return;
            }

            CustomerModel customerModel = extractCustomerModel(req);
            Boolean isAdded = registerService.registerCustomer(customerModel);

            if (isAdded == null) {
                handleError(req, resp, "Our server is under maintenance. Please try again later!");
            } else if (isAdded) {
                handleSuccess(req, resp, "Your account was successfully created!", "/login");
            } else {
                handleError(req, resp, "Username or email already exists. Please try different credentials.");
            }
        } catch (Exception e) {
            handleError(req, resp, "An unexpected error occurred. Please try again later!");
            e.printStackTrace();
        }
    }

    /**
     * Validates the registration form input data.
     * <p>
     * This method checks if all required fields are filled out and if the data entered is valid.
     * </p>
     * 
     * @param req the HttpServletRequest object that contains the form parameters.
     * @return a validation error message if any field is invalid, or null if all fields are valid.
     */
    private String validateRegistrationForm(HttpServletRequest req) {
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String username = req.getParameter("username");
        String phoneNumber = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("cpassword");

        // Basic null/empty checks
        if (ValidationUtil.isNullOrEmpty(firstName))
            return "First name is required.";
        if (ValidationUtil.isNullOrEmpty(lastName))
            return "Last name is required.";
        if (ValidationUtil.isNullOrEmpty(username))
            return "Username is required.";
        if (ValidationUtil.isNullOrEmpty(phoneNumber))
            return "Phone number is required.";
        if (ValidationUtil.isNullOrEmpty(email))
            return "Email is required.";
        if (ValidationUtil.isNullOrEmpty(password))
            return "Password is required.";
        if (ValidationUtil.isNullOrEmpty(confirmPassword))
            return "Please confirm your password.";

        // Field format validation
        if (!ValidationUtil.isValidName(firstName))
            return "First name must be 2-50 letters and spaces only.";
        if (!ValidationUtil.isValidName(lastName))
            return "Last name must be 2-50 letters and spaces only.";
        if (!ValidationUtil.isValidUsername(username))
            return "Username must start with a letter and be 4-20 alphanumeric characters.";
        if (!ValidationUtil.isValidPhoneNumber(phoneNumber))
            return "Phone number must be 10 digits starting with 98.";
        if (!ValidationUtil.isValidEmail(email))
            return "Please enter a valid email address.";
        if (!ValidationUtil.isValidPassword(password))
            return "Password must be at least 8 characters with 1 uppercase, 1 number, and 1 special character.";
        if (!ValidationUtil.doPasswordsMatch(password, confirmPassword))
            return "Passwords do not match.";

        return null; // All validations passed
    }

    /**
     * Extracts the customer data from the registration form and creates a new CustomerModel object.
     * <p>
     * This method is responsible for encrypting the password and creating the customer model.
     * </p>
     * 
     * @param req the HttpServletRequest object that contains the form parameters.
     * @return a CustomerModel object populated with the form data.
     * @throws Exception if an error occurs while processing the request.
     */
    private CustomerModel extractCustomerModel(HttpServletRequest req) throws Exception {
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String username = req.getParameter("username");
        String phoneNumber = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        password = PasswordUtil.encrypt(username, password);
        return new CustomerModel(firstName, lastName, username, phoneNumber, email, password);
    }

    /**
     * Handles a successful registration and redirects to the login page with a success message.
     * 
     * @param req the HttpServletRequest object that contains the session data.
     * @param resp the HttpServletResponse object used to send the response.
     * @param message the success message to display.
     * @param redirectPage the page to redirect to after successful registration.
     * @throws ServletException if an error occurs during the request handling.
     * @throws IOException if an error occurs while sending the response.
     */
    private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
            throws ServletException, IOException {
        req.getSession().setAttribute("success", message);
        resp.sendRedirect(req.getContextPath() + redirectPage);
    }

    /**
     * Handles an error during the registration process and repopulates the form with the user’s previous input.
     * 
     * @param req the HttpServletRequest object that contains the request data.
     * @param resp the HttpServletResponse object used to send the response.
     * @param message the error message to display.
     * @throws ServletException if an error occurs during the request handling.
     * @throws IOException if an error occurs while sending the response.
     */
    private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
            throws ServletException, IOException {
        req.setAttribute("error", message);
        // Repopulate form fields to maintain user input
        req.setAttribute("fname", req.getParameter("fname"));
        req.setAttribute("lname", req.getParameter("lname"));
        req.setAttribute("username", req.getParameter("username"));
        req.setAttribute("phone", req.getParameter("phone"));
        req.setAttribute("email", req.getParameter("email"));
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }
}
