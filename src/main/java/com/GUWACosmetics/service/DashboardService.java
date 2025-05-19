package com.GUWACosmetics.service;

import com.GUWACosmetics.config.DbConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Service class that handles dashboard-related queries for products.
 */
public class DashboardService {

    /**
     * Gets the total number of products in the database.
     * 
     * @return the total count of products
     */
    public int getTotalProducts() {
        String query = "SELECT COUNT(*) FROM product";
        return getIntValueFromQuery(query);
    }

    /**
     * Gets the number of products that have low stock (stock less than 1).
     * 
     * @return the count of low stock products
     */
    public int getLowStockItems() {
        String query = "SELECT COUNT(*) FROM product WHERE product_stock < 1";
        return getIntValueFromQuery(query);
    }

    /**
     * Gets the number of products that are out of stock (stock = 0).
     * 
     * @return the count of out-of-stock products
     */
    public int getOutOfStockItems() {
        String query = "SELECT COUNT(*) FROM product WHERE  product_stock= 0";
        return getIntValueFromQuery(query);
    }

    /**
     * Gets the highest price among all products.
     * 
     * @return the highest product price
     */
    public int getHighestPriceProduct() {
        String query = "SELECT MAX(product_price) FROM product";
        return getIntValueFromQuery(query);
    }

    /**
     * Gets the lowest price among all products.
     * 
     * @return the lowest product price
     */
    public int getLowestPriceProduct() {
        String query = "SELECT MIN(product_price) FROM product";
        return getIntValueFromQuery(query);
    }

    /**
     * Executes a SQL query that returns a single integer value (e.g., COUNT, MAX, MIN).
     * 
     * @param query the SQL query to execute
     * @return the integer result from the query, or 0 if an error occurs
     */
    private int getIntValueFromQuery(String query) {
        int result = 0;
        try (Connection conn = DbConfig.getDbConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // You can replace this with logging later
        }
        return result;
    }
}
