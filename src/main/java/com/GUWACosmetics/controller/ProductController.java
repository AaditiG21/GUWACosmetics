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
import java.util.List;

import com.GUWACosmetics.model.ProductModel;
import com.GUWACosmetics.service.MakeupService;

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
        private MakeupService service;
        /**
         * Default constructor for ProductsController.
         */
        public ProductController() {
            super();
            this.service = new MakeupService();
        }

        /**
         * Handles GET requests to "/products".
         * Forwards the request to the products JSP page for rendering.
         *
         * @param request  the HttpServletRequest object that contains the request the client made to the servlet
         * @param response the HttpServletResponse object that contains the response the servlet returns to the client
         * @throws ServletException if an input or output error is detected when the servlet handles the GET request
         * @throws IOException      if the request for the GET cannot be handled
         * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
         */
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	List<ProductModel> products;
    		products = service.getAllMakeupProducts();
    		request.setAttribute("products", products);
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
