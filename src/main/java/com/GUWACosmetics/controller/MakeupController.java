package com.GUWACosmetics.controller;

import com.GUWACosmetics.model.ProductModel;
import com.GUWACosmetics.service.MakeupService;
import com.GUWACosmetics.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
/**
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/Makeup" })
public class MakeupController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MakeupService service;

    public MakeupController() {
        super();
        this.service = new MakeupService();
    }

    /**
     * Handles GET requests to fetch and display all makeup products.
     *
     * @param request The HttpServletRequest object that contains the request made by the client.
     * @param response The HttpServletResponse object that contains the response to be sent to the client.
     * @throws ServletException If an error occurs during the processing of the request.
     * @throws IOException If an input or output error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ProductModel> products = service.getAllMakeupProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("WEB-INF/pages/Makeup.jsp").forward(request, response);
    }

    /**
     * Handles POST requests to add a new product or delete an existing one.
     *
     * @param req The HttpServletRequest object that contains the request made by the client.
     * @param resp The HttpServletResponse object that contains the response to be sent to the client.
     * @throws ServletException If an error occurs during the processing of the request.
     * @throws IOException If an input or output error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            // Delete action
            if ("delete".equals(action)) {
                int deleteId = Integer.parseInt(req.getParameter("delete_id"));
                service.deleteProductById(deleteId);

                List<ProductModel> products = service.getAllMakeupProducts();
                req.setAttribute("products", products);
                req.getRequestDispatcher("WEB-INF/pages/Makeup.jsp").forward(req, resp);
                return;
            }
            // Validate & Add Product
            String validationMessage = validateMakeupForm(req);
            if (validationMessage != null) {
                handleError(req, resp, validationMessage);
                return;
            }
            ProductModel productModel = extractProductModel(req);
            Boolean isAdded = service.addProduct(productModel);

            if (isAdded == null) {
                handleError(req, resp, "Our server is under maintenance. Please try again later!");
            } else if (isAdded) {
                handleSuccess(req, resp, "Product successfully added!", "WEB-INF/pages/Makeup.jsp");
            } else {
                handleError(req, resp, "Could not add product. Please try again later!");
            }
        } catch (Exception e) {
            handleError(req, resp, "An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Validates the form data for adding a new makeup product.
     *
     * @param req The HttpServletRequest object that contains the request parameters to validate.
     * @return A validation error message if validation fails, or null if the form is valid.
     */
    private String validateMakeupForm(HttpServletRequest req) {
        StringBuilder errors = new StringBuilder();

        String name = req.getParameter("name");
        String shade = req.getParameter("shade");
        String brand = req.getParameter("brand");
        String stock = req.getParameter("stock");
        String price = req.getParameter("price");

        if (ValidationUtil.isNullOrEmpty(name))
            errors.append("Product name is required.<br>");

        if (ValidationUtil.isNullOrEmpty(shade))
            errors.append("Shade is required.<br>");

        if (ValidationUtil.isNullOrEmpty(brand))
            errors.append("Brand is required.<br>");

        if (ValidationUtil.isNullOrEmpty(stock) || !ValidationUtil.isValidStock(stock))
            errors.append("Valid stock is required.<br>");

        if (ValidationUtil.isNullOrEmpty(price) || !ValidationUtil.isValidPrice(price))
            errors.append("Valid price is required.<br>");

        return errors.length() == 0 ? null : errors.toString();
    }

    /**
     * Extracts a ProductModel object from the form data.
     *
     * @param req The HttpServletRequest object that contains the form parameters to extract.
     * @return A ProductModel object populated with the form data.
     */
    private ProductModel extractProductModel(HttpServletRequest req) {
        String name = req.getParameter("name");
        String shade = req.getParameter("shade");
        String brand = req.getParameter("brand");
        int stock = Integer.parseInt(req.getParameter("stock"));
        int price = Integer.parseInt(req.getParameter("price"));

        return new ProductModel(name, shade, brand, stock, price);
    }

    /**
     * Handles the success response, showing a success message and redirecting to the makeup page.
     *
     * @param req The HttpServletRequest object that contains the request parameters.
     * @param resp The HttpServletResponse object that contains the response to be sent to the client.
     * @param message The success message to display.
     * @param redirectPage The page to redirect to after processing the request.
     * @throws ServletException If an error occurs during the request handling.
     * @throws IOException If an I/O error occurs during the request handling.
     */
    private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
            throws ServletException, IOException {
        req.setAttribute("success", message);
        List<ProductModel> products = service.getAllMakeupProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher(redirectPage).forward(req, resp);
    }

    /**
     * Handles the error response, showing an error message and redirecting to the makeup page.
     *
     * @param req The HttpServletRequest object that contains the request parameters.
     * @param resp The HttpServletResponse object that contains the response to be sent to the client.
     * @param message The error message to display.
     * @throws ServletException If an error occurs during the request handling.
     * @throws IOException If an I/O error occurs during the request handling.
     */
    private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
            throws ServletException, IOException {
        req.setAttribute("error", message);
        List<ProductModel> products = service.getAllMakeupProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("WEB-INF/pages/Makeup.jsp").forward(req, resp);
    }
}
