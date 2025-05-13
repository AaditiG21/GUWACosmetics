package com.GUWACosmetics.controller;

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

/**
 * Servlet implementation class CustomerProfileController
 * This controller handles requests related to the Customer Profile page.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/CustomerProfile" })
public class CustomerProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public CustomerProfileController() {
        super();
    }

    /**
     * Handles GET requests for the Customer Profile page.
     * Forwards the request to the CustomerProfile.jsp page for rendering.
     *
     * @param request The HttpServletRequest object that contains the request the client made of the servlet.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs during the request processing.
     * @throws IOException If an input or output error is detected when the servlet handles the request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the CustomerProfile.jsp page
        request.getRequestDispatcher("WEB-INF/pages/CustomerProfile.jsp").forward(request, response);
    }

    /**
     * Handles POST requests for the Customer Profile page.
     * Forwards the request to the GET handler (no special processing required for this controller).
     *
     * @param request The HttpServletRequest object that contains the request the client made of the servlet.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs during the request processing.
     * @throws IOException If an input or output error is detected when the servlet handles the request.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward POST requests to the same page as GET (no special form handling in this case)
        doGet(request, response);
    }
}
