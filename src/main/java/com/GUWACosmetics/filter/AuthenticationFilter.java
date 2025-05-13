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
    private static final String ADMIN_PROFILE = "/AdminProfile";  // Fixed double slash
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
     * <p>
     * This method checks if a user is logged in, verifies their role, and ensures they have access to the requested resource.
     * If the user is not authorized or logged in, they are redirected accordingly.
     * </p>
     * 
     * @param request the ServletRequest object that contains the request made by the client.
     * @param response the ServletResponse object that will be sent to the client.
     * @param chain the FilterChain used to pass the request and response along to the next filter or servlet.
     * @throws IOException if an I/O error occurs during the filtering process.
     * @throws ServletException if the filtering process cannot be completed.
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
                // Admin is logged in
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
            if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)  || uri.endsWith(ROOT)) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(contextPath + LOGIN);
            }
        }
    }

    /*@Override
    public void destroy() {
        // Cleanup logic, if required
    }*/
}
