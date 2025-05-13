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
 * Servlet implementation class ProductController
 * <p>
 * This servlet handles requests related to the Product page. It forwards the requests 
 * to the Product.jsp page to display product information.
 * </p>
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Product" })
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * Default constructor. 
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Handles the HTTP <code>GET</code> request.
     * <p>
     * Forwards the request to the Product.jsp page to display product-related content.
     * </p>
     * 
     * @param request the HttpServletRequest object that contains the request the client made of the servlet.
     * @param response the HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException if the request for the GET could not be handled.
     * @throws IOException if an input or output error is detected when the servlet handles the request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forwards the request to Product.jsp to display product details
        request.getRequestDispatcher("WEB-INF/pages/Product.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> request.
     * <p>
     * This method currently forwards the request to the Product.jsp page. 
     * You can extend this method to handle POST requests, such as adding or updating products.
     * </p>
     * 
     * @param request the HttpServletRequest object that contains the request the client made of the servlet.
     * @param response the HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException if the request for the POST could not be handled.
     * @throws IOException if an input or output error is detected when the servlet handles the request.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forwards the POST request to the same page (Product.jsp) for now
        doGet(request, response);
    }
}
