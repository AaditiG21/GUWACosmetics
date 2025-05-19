package com.GUWACosmetics.service;

import com.GUWACosmetics.config.DbConfig;
import com.GUWACosmetics.model.ProductModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class to manage Makeup products.
 * Handles database operations such as adding, retrieving, searching, and deleting products.
 * 
 * @author Aaditi Ghimire
 */
public class MakeupService {

    private Connection dbConn;

    /**
     * Initializes the service and establishes a database connection.
     */
    public MakeupService() {
        try {
            this.dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Adds a new product to the database.
     * 
     * @param productModel the product model containing the product details to add
     * @return {@code Boolean.TRUE} if the product was successfully added,
     *         {@code Boolean.FALSE} if the operation failed,
     *         or {@code null} if the database connection is not available
     */
    public Boolean addProduct(ProductModel productModel) {
        if (dbConn == null) {
            System.err.println("Database not connected");
            return null;
        }

        String insertQuery = "INSERT INTO product (product_name, product_shade, product_brand, product_stock, product_price, Image) "
                           + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = dbConn.prepareStatement(insertQuery)) {
            stmt.setString(1, productModel.getName());
            stmt.setString(2, productModel.getShade());
            stmt.setString(3, productModel.getBrand());
            stmt.setInt(4, productModel.getStock());
            stmt.setInt(5, productModel.getPrice());
            stmt.setString(6, productModel.getImage());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error adding product: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves all makeup products from the database.
     * 
     * @return a list of all products; empty list if none found or on error
     */
    public List<ProductModel> getAllMakeupProducts() {
        List<ProductModel> products = new ArrayList<>();
        String query = "SELECT * FROM product";

        try (Statement stmt = dbConn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ProductModel product = new ProductModel(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("product_shade"),
                    rs.getString("product_brand"),
                    rs.getInt("product_stock"),
                    rs.getInt("product_price"),
                    rs.getString("Image")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving products: " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }

    /**
     * Deletes a product from the database by its ID.
     * 
     * @param id the product ID to delete
     * @return {@code true} if the product was deleted successfully, {@code false} otherwise
     */
    public boolean deleteProductById(int id) {
        String deleteQuery = "DELETE FROM product WHERE product_id = ?";

        try (PreparedStatement stmt = dbConn.prepareStatement(deleteQuery)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Searches for products whose names contain the given search string.
     * 
     * @param productName the product name or partial name to search for
     * @return a list of matching products; empty list if none found or on error
     */
    public List<ProductModel> searchProductsByName(String productName) {
        List<ProductModel> products = new ArrayList<>();
        String query = "SELECT * FROM product WHERE product_name LIKE ?";

        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, "%" + productName + "%"); // Partial match
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProductModel product = new ProductModel(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("product_shade"),
                    rs.getString("product_brand"),
                    rs.getInt("product_stock"),
                    rs.getInt("product_price"),
                    rs.getString("Image")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error searching products: " + e.getMessage());
            e.printStackTrace();
        }

        return products;
    }
}
