package com.GUWACosmetics.util;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 */
public class RedirectionUtil {

    private static final String baseUrl = "/WEB-INF/pages/";
    public static final String RegisterUrl = baseUrl + "register.jsp";
    public static final String loginUrl = baseUrl + "login.jsp";
    public static final String HomeUrl = baseUrl + "home.jsp";
    public static final String AdminDashboardUrl = baseUrl + "AdminDashboard.jsp";

    /**
     * Sets a message attribute to the request object.
     *
     * @param req the HttpServletRequest object to set the attribute on.
     * @param msgType the type of the message (e.g., "error", "success").
     * @param msg the message to be set as an attribute.
     */
    public void setMsgAttribute(HttpServletRequest req, String msgType, String msg) {
        req.setAttribute(msgType, msg);
    }

    /**
     * Redirects the request to a specified page using RequestDispatcher.
     *
     * @param req the HttpServletRequest object for the request.
     * @param resp the HttpServletResponse object for the response.
     * @param page the JSP page to redirect the request to.
     * @throws ServletException if the request dispatcher encounters a servlet issue.
     * @throws IOException if there is an I/O issue during the forwarding process.
     */
    public void redirectToPage(HttpServletRequest req, HttpServletResponse resp, String page)
            throws ServletException, IOException {
        req.getRequestDispatcher(page).forward(req, resp);
    }

    /**
     * Sets a message attribute and redirects the request to a specified page.
     *
     * @param req the HttpServletRequest object for the request.
     * @param resp the HttpServletResponse object for the response.
     * @param msgType the type of the message (e.g., "error", "success").
     * @param msg the message to be set as an attribute.
     * @param page the JSP page to redirect the request to.
     * @throws ServletException if the request dispatcher encounters a servlet issue.
     * @throws IOException if there is an I/O issue during the forwarding process.
     */
    public void setMsgAndRedirect(HttpServletRequest req, HttpServletResponse resp, String msgType, String msg,
            String page) throws ServletException, IOException {
        setMsgAttribute(req, msgType, msg);
        redirectToPage(req, resp, page);
    }
}
