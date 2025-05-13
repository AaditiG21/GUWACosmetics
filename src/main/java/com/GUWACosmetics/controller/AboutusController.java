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
 * Servlet implementation class AboutusController
 * Handles the requests for the "About Us" page.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Aboutus" })
public class AboutusController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public AboutusController() {
        super();
    }

    /**
     * Handles GET requests to the About Us page.
     * Retrieves dynamic data and forwards the request to Aboutus.jsp for rendering.
     * 
     * @param request The HttpServletRequest object that contains the request the client made of the servlet.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If an error occurs during the request processing.
     * @throws IOException If an input or output error is detected when the servlet handles the request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Sample dynamic parameters (these could come from a database, API, etc.)
        String companyName = "GUWA Cosmetics";
        String companyDescription = "GUWA Cosmetics offers premium beauty products to help you look and feel your best.";
        String contactEmail = "contact@guwacosmetics.com";
        String missionStatement = "Our mission is to provide the best quality cosmetics with a commitment to sustainability.";
        
        // Setting the parameters as request attributes
        request.setAttribute("companyName", companyName);
        request.setAttribute("companyDescription", companyDescription);
        request.setAttribute("contactEmail", contactEmail);
        request.setAttribute("missionStatement", missionStatement);

        // Forward the request to Aboutus.jsp for rendering the dynamic content
        request.getRequestDispatcher("/WEB-INF/pages/Aboutus.jsp").forward(request, response);
    }

    /**
     * Handles POST requests. For the "About Us" page, it simply forwards the request to the GET handler.
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
