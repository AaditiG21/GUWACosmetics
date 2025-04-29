package com.GUWACosmetics.controller;

import java.io.IOException;

import com.GUWACosmetics.model.CustomerModel;
import com.GUWACosmetics.service.RegisterService;
import com.GUWACosmetics.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * LMU ID: 23048677
 * NAME: Aaditi Ghimire
 */

/**
 * RegisterController handles user registration requests and processes form
 * submissions for the registration page.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Register" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final RegisterService registerService = new RegisterService();
	private RegisterService service;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		this.setService(new RegisterService());
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			CustomerModel customerModel = extractRegisterModel(req);
			System.out.println("Extracted Customers");
			Boolean isAdded = registerService.registerCustomer(customerModel);
			System.out.println("User registered");
			if (isAdded == null) {
				handleError(req, resp, "Our server is under maintenance. Please try again later!");
			} else if (isAdded) {
				handleSuccess(req, resp, "Your account is successfully created!", "/WEB-INF/pages/login.jsp");
			} else {
				handleError(req, resp, "Could not register your account. Please try again later!");
			}
		} catch (Exception e) {
			handleError(req, resp, "An unexpected error occurred. Please try again later!");
			e.printStackTrace(); // Log the exception
		}
		
	}

	private CustomerModel extractRegisterModel(HttpServletRequest req) throws Exception{
		
		 String firstName = req.getParameter("First_Name");
         String lastName = req.getParameter("Last_Name");
         String username = req.getParameter("UserName");
         String phoneNumber = req.getParameter("Phone_Number");
         String email = req.getParameter("Email");
         String password = req.getParameter("Passworrd");
         String confirmPassword = req.getParameter("confirm_password");
		
		if (password == null || !password.equals(confirmPassword)) {
			throw new Exception("Passwords do not match or are invalid.");
		}

		// Encrypt password before storing
		password = PasswordUtil.encrypt(username, password);

		return new CustomerModel(firstName, lastName, username, phoneNumber, email, password);
	}



	private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
			throws ServletException, IOException {
		req.setAttribute("success", message);
		req.getRequestDispatcher(redirectPage).forward(req, resp);
	}

	private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
			throws ServletException, IOException {
		req.setAttribute("error", message);
		req.getRequestDispatcher("/WEB-INF/pages/Register.jsp").forward(req, resp);
		
	}
	
	public RegisterService getService() {
		return service;
	}
	public void setService(RegisterService service) {
		this.service = service;
	}
}
