package com.GUWACosmetics.controller;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;

import com.GUWACosmetics.model.CustomerModel;
import com.GUWACosmetics.service.RegisterService;
import com.GUWACosmetics.util.PasswordUtil;
import com.GUWACosmetics.util.RedirectionUtil;

/**
 * RegisterController handles user registration requests and processes form
 * submissions. It also manages file uploads and account creation.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Register" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private RegisterService registerService;
	private RedirectionUtil redirectionUtil;

	@Override
	public void init() throws ServletException {
		this.registerService = new RegisterService();
		this.redirectionUtil = new RedirectionUtil();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Web-INF/pages/register.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			CustomerModel customerModel = extractCustomerModel(req);
			Boolean isAdded = registerService.registerCustomer(customerModel);

			if (isAdded == null) {
				handleError(req,resp, "Our Server is under maintenance. Try again Later");
						
			
			} else {
				handleError(req, resp, 
						"Could not register your account. Please try again later!");
			}
		} catch (Exception e) {
			handleError(req, resp,
					"An unexpected error occurred. Please try again later!");
			e.printStackTrace(); // Log the exception
		}
	}
	
	private boolean handleSucess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage) throws 
	ServletException, IOException {
		req.setAttribute("success",message);
		req.getRequestDispatcher(redirectPage).forward(req,resp);
		
	}
	
	private boolean handleError(HttpServletRequest req, HttpServletResponse resp, String message) throws 
	ServletException, IOException {
		req.setAttribute("error",message);
		req.getRequestDispatcher("/Web-INF/pages/register.jsp").forward(req,resp);
	}


	
}