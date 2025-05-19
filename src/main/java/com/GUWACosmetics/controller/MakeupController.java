package com.GUWACosmetics.controller;

import com.GUWACosmetics.model.ProductModel;
import com.GUWACosmetics.service.MakeupService;
import com.GUWACosmetics.util.ImageUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

/**
 * Controller to handle makeup product-related operations such as listing, adding,
 * updating, and deleting products.
 * 
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Makeup" })
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class MakeupController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ImageUtil imageUtil = new ImageUtil();
    private MakeupService service;

    /**
     * Default constructor that initializes the MakeupService.
     */
    public MakeupController() {
        super();
        this.service = new MakeupService();
    }

    /**
     * Handles GET requests to list all makeup products or perform search.
     *
     * @param request  the {@link HttpServletRequest} object containing the request parameters
     * @param response the {@link HttpServletResponse} object for sending the response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchQuery = request.getParameter("search");
        List<ProductModel> products;

        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            products = service.searchProductsByName(searchQuery.trim());
        } else {
            products = service.getAllMakeupProducts();
        }

        request.setAttribute("products", products);
        request.getRequestDispatcher("WEB-INF/pages/Makeup.jsp").forward(request, response);
    }

    /**
     * Handles POST requests for adding, updating, or deleting makeup products.
     *
     * @param req  the {@link HttpServletRequest} object containing form data
     * @param resp the {@link HttpServletResponse} object for sending the response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("delete".equals(action)) {
                int deleteId = Integer.parseInt(req.getParameter("delete_id"));
                service.deleteProductById(deleteId);
                handleSuccess(req, resp, "Product deleted successfully!", "WEB-INF/pages/Makeup.jsp");
                return;
            }

            if (!isMultipartContent(req)) {
                handleError(req, resp, "Form must be submitted as multipart/form-data.");
                return;
            }

            boolean uploadSuccess = uploadImage(req);
            if (!uploadSuccess) {
                req.setAttribute("error", "Failed to upload image.");
                req.getRequestDispatcher("WEB-INF/pages/Makeup.jsp").forward(req, resp);
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
     * Checks whether the request contains multipart content.
     *
     * @param request the {@link HttpServletRequest} to check
     * @return true if the content is multipart/form-data, false otherwise
     */
    private boolean isMultipartContent(HttpServletRequest request) {
        String contentType = request.getContentType();
        return contentType != null && contentType.toLowerCase().startsWith("multipart/");
    }

    /**
     * Extracts product information from the multipart form submission.
     *
     * @param req the {@link HttpServletRequest} containing the product data
     * @return a populated {@link ProductModel} instance
     * @throws IOException      if an I/O error occurs
     * @throws ServletException if a servlet-specific error occurs
     */
    private ProductModel extractProductModel(HttpServletRequest req) throws IOException, ServletException {
        String name = req.getParameter("name");
        String shade = req.getParameter("shade");
        String brand = req.getParameter("brand");
        int stock = Integer.parseInt(req.getParameter("stock"));
        int price = Integer.parseInt(req.getParameter("price"));

        String imageUrl = null;
        if (isMultipartContent(req)) {
            Part image = req.getPart("image");
            if (image != null && image.getSize() > 0) {
                imageUrl = imageUtil.getImageNameFromPart(image);
            }
        }

        return new ProductModel(name, shade, brand, stock, price, imageUrl);
    }

    /**
     * Handles the uploading of the product image file.
     *
     * @param req the {@link HttpServletRequest} containing the image part
     * @return true if the image is uploaded successfully or no image is provided, false otherwise
     * @throws IOException      if an I/O error occurs
     * @throws ServletException if a servlet-specific error occurs
     */
    private boolean uploadImage(HttpServletRequest req) throws IOException, ServletException {
        if (!isMultipartContent(req)) {
            return false;
        }
        Part image = req.getPart("image");
        if (image == null || image.getSize() == 0) {
            return true;
        }
        return imageUtil.uploadImage(image, req.getServletContext().getRealPath("/"), "system");
    }

    /**
     * Handles successful product operations by setting attributes and forwarding to a JSP.
     *
     * @param req          the {@link HttpServletRequest} object
     * @param resp         the {@link HttpServletResponse} object
     * @param message      the success message to display
     * @param redirectPage the JSP page to forward to
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
            throws ServletException, IOException {
        req.setAttribute("success", message);
        List<ProductModel> products = service.getAllMakeupProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher(redirectPage).forward(req, resp);
    }

    /**
     * Handles error scenarios by setting error messages and forwarding to a JSP.
     *
     * @param req     the {@link HttpServletRequest} object
     * @param resp    the {@link HttpServletResponse} object
     * @param message the error message to display
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
            throws ServletException, IOException {
        req.setAttribute("error", message);
        List<ProductModel> products = service.getAllMakeupProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("WEB-INF/pages/Makeup.jsp").forward(req, resp);
    }
}
