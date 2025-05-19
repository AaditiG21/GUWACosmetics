package com.GUWACosmetics.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.GUWACosmetics.util.CookiesUtil;
import com.GUWACosmetics.util.SessionUtil;
/**
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 */

/**
 * Servlet implementation class LogoutController
 *
 * This servlet handles the logout functionality by removing the user role from cookies
 * and invalidating the session, followed by redirecting the user to the login page.
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Handles POST requests for logging out the user.
	 * This method deletes the role cookie, invalidates the session, and redirects to the login page.
	 *
	 * @param request The HttpServletRequest object that contains the request the client made of the servlet.
	 * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
	 * @throws ServletException If an error occurs during request processing.
	 * @throws IOException If an input or output error occurs.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Delete the role cookie
		CookiesUtil.deleteCookie(response, "role");

		// Invalidate the session
		SessionUtil.invalidateSession(request);

		// Redirect to the login page
		response.sendRedirect(request.getContextPath() + "/login.jsp?logout=logout");
	}
	

}
