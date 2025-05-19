package com.GUWACosmetics.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.GUWACosmetics.util.CookiesUtil;
import com.GUWACosmetics.util.SessionUtil;

/**
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 *
 * This filter handles authentication and authorization based on user roles.
 */
@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    // Constants for URL paths
    private static final String LOGIN = "/login";
    private static final String LOGOUT = "/logout";
    private static final String REGISTER = "/Register";
    private static final String HOME = "/Home";
    private static final String ROOT = "/";
    private static final String ADMIN_DASHBOARD = "/AdminDashboard";
    private static final String ADMIN_PROFILE = "/AdminProfile"; 
    private static final String ABOUT_US = "/Aboutus";
    private static final String CONTACT_US = "/Contactus";
    private static final String CUSTOMER_PROFILE = "/CustomerProfile";
    private static final String MAKEUP = "/Makeup";
    private static final String PRODUCT = "/Product";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    /**
     * Filters requests based on user authentication and role.
     * 
     * @param request  the {@link ServletRequest} object containing the client's request
     * @param response the {@link ServletResponse} object containing the servlet's response
     * @param chain    the {@link FilterChain} to pass the request and response to the next entity
     * @throws IOException      if an input or output error occurs during the filtering
     * @throws ServletException if the filtering could not be performed
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();

        // Allow static resources
        if (uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".css") || uri.endsWith(".js")) {
            chain.doFilter(request, response);
            return;
        }

        if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER) || uri.endsWith(LOGOUT)) {
            chain.doFilter(request, response);
            return;
        }

        boolean isLoggedIn = SessionUtil.getAttribute(req, "username") != null;
        String userRole = CookiesUtil.getCookie(req, "role") != null
                ? CookiesUtil.getCookie(req, "role").getValue()
                : null;

        System.out.println("URI: " + uri + ", isLoggedIn: " + isLoggedIn + ", Role: " + userRole);

        if (isLoggedIn) {
            if ("admin".equals(userRole)) {
                if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
                    res.sendRedirect(req.getContextPath() + ADMIN_DASHBOARD);
                } else if (uri.endsWith(ADMIN_DASHBOARD) || uri.endsWith(PRODUCT) ||
                         uri.endsWith(ADMIN_PROFILE) || uri.endsWith(ABOUT_US) || uri.endsWith(CONTACT_US)
                        || uri.endsWith(LOGOUT) || uri.endsWith(ROOT) || uri.endsWith(HOME)
                        || uri.endsWith(MAKEUP)) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect(req.getContextPath() + ADMIN_DASHBOARD);
                }

            } else if ("customer".equals(userRole)) {
                if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
                    res.sendRedirect(contextPath + HOME);
                    return;
                }

                if (uri.endsWith(HOME) || uri.endsWith(ROOT) || uri.endsWith(ABOUT_US) || uri.endsWith(MAKEUP)
                        || uri.endsWith(PRODUCT) || uri.endsWith(CONTACT_US)
                        || uri.endsWith(CUSTOMER_PROFILE) || uri.endsWith(LOGOUT)) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect(contextPath + HOME);
                }
            } else {
                // Role not recognized
                res.sendRedirect(contextPath + LOGIN);
            }
        } else {
            // Not logged in
            if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER) || uri.endsWith(ROOT)) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(contextPath + LOGIN);
            }
        }
    }

    // Optional destroy method can be added here if cleanup is needed
}
