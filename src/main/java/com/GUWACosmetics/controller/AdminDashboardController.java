package com.GUWACosmetics.controller;

import com.GUWACosmetics.service.DashboardService;
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
 * Servlet implementation class AdminDashboardController
 * This controller handles the requests for the Admin Dashboard page.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AdminDashboard" })
public class AdminDashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DashboardService dashboardService;

    /**
     * Default constructor.
     */
    public AdminDashboardController() {
        super();
    }

    @Override
    public void init() throws ServletException {
        dashboardService = new DashboardService();
    }

    /**
     * Handles GET requests for the Admin Dashboard page.
     * Retrieves necessary data and forwards the request to the AdminDashboard.jsp page for rendering.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch stats from the service
        int totalProducts = dashboardService.getTotalProducts();
        int lowStock = dashboardService.getLowStockItems();
        int outOfStock = dashboardService.getOutOfStockItems();
        int highestPrice = dashboardService.getHighestPriceProduct();
        int lowestPrice = dashboardService.getLowestPriceProduct();

        // Set attributes for JSP
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("lowStock", lowStock);
        request.setAttribute("outOfStock", outOfStock);
        request.setAttribute("highestPrice", highestPrice);
        request.setAttribute("lowestPrice", lowestPrice);

        // Forward to JSP
        request.getRequestDispatcher("WEB-INF/pages/AdminDashboard.jsp").forward(request, response);
    }

    /**
     * Handles POST requests for the Admin Dashboard page.
     * Forwards the request to the GET handler.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
